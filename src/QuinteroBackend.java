import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.nio.file.Path;

public class QuinteroBackend {

    private File data;
    private ArrayList<Advisory> advisories;
    private ArrayList<Location> locations;
    private ArrayList<String> lines;
    private HashMap<Advisory, Location> presetMap;

    public QuinteroBackend(){
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        data = new File(s+"/test.txt");
        advisories = new ArrayList<>();
        locations = new ArrayList<>();
        lines = new ArrayList<>();
        presetMap = new HashMap<>();
        getData(); //retrieves data from file
    }

    void getData(){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(data);
            br = new BufferedReader(fr);
            while(true){
                String a = br.readLine();
                lines.add(a);
                if(a.equals("x")) break;
                else{
                    String[] ra = a.split(" - ");
                    advisories.add(new Advisory(ra[0], Integer.parseInt(ra[1]), Integer.parseInt(ra[2])));
                }
            }
            while(true){
                String a = br.readLine();
                lines.add(a);
                if(a.equals("x")) break;
                else{
                    String[] ra = a.split(" - ");
                    locations.add(new Location(ra[0], Integer.parseInt(ra[1])));
                }
            }
            for(Advisory a : advisories) a.previous = locations.get(a.ptemp);
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(data);
            bw = new BufferedWriter(fw);
            for(String text : lines) {
                bw.write(text);
                bw.newLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            try{
                bw.close();
                fw.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void addAdvisory(String name){
        int value = 0;
        for(Advisory a : advisories)
            value += a.total;
        if(advisories.size() != 0) value /= advisories.size();

        Location newprev = locations.get((int)(Math.random()*locations.size()));
        advisories.add(new Advisory(name, value, newprev));
        lines.add(0, name+" - "+value+" - "+locations.indexOf(newprev));
    }

    public void removeAdvisory(String name){
        lines.remove(advisories.indexOf(getAdvByName(name)));
        advisories.remove(getAdvByName(name));
    }

    public void removeLocation(String name){
        lines.remove(locations.indexOf(getLocByName(name))+advisories.size()+1);
        locations.remove(getLocByName(name));
    }

    public void editAdvisory(String name, String changeTo){
        Advisory adv = getAdvByName(name);
        adv.name = changeTo;
        lines.set(advisories.indexOf(adv), adv.name+" - "+adv.total+" - "+locations.indexOf(adv.previous));
    }

    public void editLocation(String name, String changeTo){
        Location loc = getLocByName(name);
        loc.name = changeTo;
        lines.set(locations.indexOf(loc)+advisories.size()+1, loc.name+" - "+loc.score);
    }

    public void addLocation(String name, int score){
        locations.add(new Location(name, score));
        lines.add(advisories.size()+1, name+" - "+score);
    }

    public void setLocation(String a, String l){
        presetMap.put(getAdvByName(a), getLocByName(l));
    }

    public HashMap<Advisory, Location> randomize() {
        ArrayList<Advisory> sortedA = new ArrayList<>(); //sort advisories from least to greatest past score
        ArrayList<Advisory> cloneA = (ArrayList)advisories.clone();
        for(int i = 0; i < advisories.size(); i++) {
            Advisory least = cloneA.get(0);
            for(Advisory a : advisories)
                if(presetMap.containsKey(a)) cloneA.remove(a);
            for (int j = 1; j < cloneA.size(); j++)
                if(cloneA.get(j).total < least.total) least = cloneA.get(j);
            sortedA.add(least);
            cloneA.remove(least);
        }
        ArrayList<Location> sortedL = new ArrayList<>(); //sort locations from greatest to least score
        ArrayList<Location> cloneL = (ArrayList)locations.clone();
        for(int i = 0; i < locations.size(); i++) {
            Location greatest = cloneL.get(0);
            for(Location l : locations)
                if(presetMap.containsKey(l)) cloneL.remove(l);

            for (int j = 1; j < cloneL.size(); j++)
                if(cloneL.get(j).score > greatest.score) greatest = cloneL.get(j);
            sortedL.add(greatest);
            cloneL.remove(greatest);
        }
        boolean cont = true;
        while(cont){ //check to ensure no advisory gets the same location as previously
            cont = false;
            for(int i = 0; i < sortedA.size(); i++)
                if(sortedA.get(i).previous.equals(sortedL.get(i))){
                    Location temp = sortedL.get(i);
                    ArrayList<Integer> attempts = new ArrayList<>();
                    for(int o = 0; attempts.size() == 0; o++)
                        for(Location l : locations)
                            if(!l.equals(temp) && Math.abs(l.score - temp.score) == o){
                                attempts.add(sortedL.indexOf(l));
                            }
                    System.out.println(attempts.size());
                    Collections.swap(sortedL, i, attempts.get((int)(Math.random()*attempts.size())));
                    cont = true;
                }
        }
        HashMap<Advisory, Location> result = new HashMap<>(); //generate hashmap
        for(int i = 0; i < sortedA.size(); i++) result.put(sortedA.get(i), sortedL.get(i));
        result.putAll(presetMap);

        return result;
    }

    public void confirm(HashMap<Advisory, Location> result){ //updates the totals and previous values
        for(Advisory a : advisories) {
            a.total += result.get(a).score;
            a.previous = result.get(a);
            lines.set(advisories.indexOf(a), a.name+" - "+a.total+" - "+locations.indexOf(a.previous));
        }
    }

    private Advisory getAdvByName(String name){
        for(Advisory a : advisories) if(a.name.equals(name)) return a;
        return null;
    }

    private Location getLocByName(String name){
        for(Location l : locations) if(l.name.equals(name)) return l;
        return null;
    }
}
