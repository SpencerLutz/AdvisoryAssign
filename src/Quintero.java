import java.io.*;
import java.util.ArrayList;

public class Quintero {

    static String filepath = "/Users/student/Desktop/";
    static File data = new File(filepath+"test.txt");
    static ArrayList<Advisory> advisories = new ArrayList<>();
    static ArrayList<Location> locations = new ArrayList<>();
    static ArrayList<String> lines = new ArrayList<>();

    static int ap = 0, lp = 0;

    public static void main(String[] args){
        getData();
        ap = advisories.size();
        lp = ap+1+locations.size();

        //code here

        save();
    }

    static void getData(){
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
                    String[] ra = a.split(" ");
                    advisories.add(new Advisory(ra[0], Integer.parseInt(ra[1])));
                }
            }
            while(true){
                String a = br.readLine();
                lines.add(a);
                if(a.equals("x")) break;
                else{
                    String[] ra = a.split(" ");
                    locations.add(new Location(ra[0], Integer.parseInt(ra[1])));
                }
            }
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
        ap = advisories.size();
    }

    static void save(){
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

    static void addAdvisory(String name){
        int value = 0;
        for(Advisory a : advisories)
            value += a.total;
        value /= advisories.size();

        advisories.add(new Advisory(name, value));
        lines.add(ap, name+" "+value);
    }

    static void addLocation(String name, int score){
        advisories.add(new Advisory(name, score));
        lines.add(lp, name+" "+score);
    }

    void randomize(){
        //todo
    }
}
