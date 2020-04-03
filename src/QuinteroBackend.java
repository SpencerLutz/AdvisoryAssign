import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.nio.file.Path;

public class QuinteroBackend {
    private File data;                              // file that stores info
    private ArrayList<Advisory> advisories;         // list of advisories
    private ArrayList<Location> locations;          // list of locations
    public ArrayList<String> lines;                 // list of lines to write to file
    public HashMap<Advisory, Location> assignments; // final location assignments
    private HashMap<Advisory, Location> presetMap;  // map of any advisories with locations preset by the user

    public QuinteroBackend() {
        String path = Paths.get("").toAbsolutePath().toString(); // gets current path
        data        = new File(s+"/test.txt"); // creates File object at current path
        advisories  = new ArrayList<>(); 
        locations   = new ArrayList<>();
        lines       = new ArrayList<>();
        assignments = new HashMap<>();
        presetMap   = new HashMap<>();
        getData(); // retrieves data from file
    }

    private void getData() {
        FileReader fr     = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(data);   // creates FileReader for data
            br = new BufferedReader(fr); // creates BufferedReader with fr

            while (true) {                   // parse through the Advisory section of file
                String line = br.readLine(); // reads current line
                lines.add(line);             // adds to list of lines
                if (line.equals("x")) break; // check if end of Advisory section
                else {
                    String[] parts = line.split(" - "); // split line into 3 parts
                    advisories.add(new Advisory(parts[0], Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]))); // create advisory with data from file
                }                                     
            }

            while (true) { // see above, same but for location data
                String a = br.readLine();
                lines.add(a);
                if (a.equals("x")) break;
                else {
                    String[] ra = a.split(" - ");
                    locations.add(new Location(ra[0], Integer.parseInt(ra[1])));
                }
            }

            for (Advisory a : advisories)                    // loop through advisories
                a.location = locations.get(a.locationIndex); // set current location based on given index
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                br.close();
                fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /******************************************************
    * Writes any new data to the file. Call this method   *
    * once, and do not call any other methods after this. *
    ******************************************************/
    public void save() {
        BufferedWriter bw = null;
        FileWriter fw     = null;

        try {

            fw = new FileWriter(data);   // creates FileWriter for data
            bw = new BufferedWriter(fw); // creates BufferedWriter for fw

            for (String text : lines) { // loop through lines
                bw.write(text);        // write each line to file
                bw.newLine();          // move to new line
            }
 
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                bw.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /******************************************************************
    * Saves advisory and location mappings as a CSV to allow the user *
    * to print as a spreadsheet. Pass in the desired save location.   *
    ******************************************************************/
    public void saveCSV(String filepath) {
        File save = new File(filepath+"/Assignments.csv"); // create File object
        BufferedWriter bw = null;
        FileWriter fw     = null;

        try {

            fw = new FileWriter(save);   // creates FileWriter for File save
            bw = new BufferedWriter(fw); // creates BufferedWriter from fw
            String[][] info = new String[assignments.keySet().size()][2]; // create 2d array
            int i = 0; // index variable

            for (Advisory adv : assignments.keySet()) { // loop through advisories
                info[i][0] = adv.name;                  // populates array with 
                info[i][1] = assignments.get(adv).name; // advisory and location names
                i++;                                    // from assignments, increment
            }                                           // the index variable

            for (int j = 0; j < info.length; j++) {      // loop through generated array
                bw.write(info[j][0] + "," + info[j][1]); // convert array to CSV format
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                bw.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /***********************************************************
    * Creates an Advisory, accepts the desired name. The total *
    * value is set to the average of all existing Advisories.  *
    ***********************************************************/
    public void addAdvisory(String name) {
        int value = 0;

        for (Advisory a : advisories) { // set value equal to the
            value += a.total;           // sum of all totals
        }

        if (advisories.size() != 0) {   // divide by zero check
            value /= advisories.size(); // set value to average total
        } else {
            value = 0;
        }

        Location newprev = locations.get((int)(Math.random()*locations.size()));
        // sets a random current location, required for randomize()

        advisories.add(new Advisory(name, value, newprev)); // create new Advisory
        lines.add(advisories.indexOf(getAdvByName(name)), name + " - " + value
            + " - " + locations.indexOf(newprev)); // adds this new Advisory to lines
    }

    /***********************************************
    * Changes the name of an Advisory. Pass in the *
    * current name and a name to change it to.     *
    ***********************************************/
    public void editAdvisory(String name, String changeTo) {
        Advisory adv = getAdvByName(name);
        if (advisories.indexOf(adv) == -1) return; // return if given advisory doesn't exist

        adv.name = changeTo;
        lines.set(advisories.indexOf(adv), adv.name + " - " + adv.total + " - "
            + locations.indexOf(adv.location)); // edits the correct line in lines
    }

    /***********************************
    * Removes an Advisory. Accepts the *
    * name of the Advisory to remove.  *
    ***********************************/
    public void removeAdvisory(String name) {
        Advisory adv = getAdvByName(name);
        if (advisories.indexOf(adv) == -1) return; // return if given advisory doesn't exist

        lines.remove(advisories.indexOf(adv));
        advisories.remove(adv);
    }

    /******************************************
    * Creates a Location, accepts the desired *
    * name and preference score.              *
    ******************************************/
    public void addLocation(String name, int score) {
        locations.add(new Location(name, score));
        lines.add(locations.indexOf(getLocByName(name))+advisories.size() + 1, 
            name + " - " + score); // adds new Location at the correct index
    }

    /**********************************************
    * Changes the name of a Location. Pass in the *
    * current name and a name to change it to.    *
    **********************************************/
    public void editLocationName(String name, String changeTo) {
        Location loc = getLocByName(name);
        if (locations.indexOf(loc) == -1) return; // return if given location doesn't exist

        loc.name = changeTo;
        lines.set(locations.indexOf(loc) + advisories.size() + 1, loc.name +
             " - " + loc.score); // edits the correct line in lines
    }

    /****************************************
    * Changes the score of a Location. Pass *
    * in the name and the desired score.    *
    ****************************************/
    public void editLocationScore(String name, int changeTo) {
        Location loc = getLocByName(name);
        if (locations.indexOf(loc) == -1) return; // return if given location doesn't exist

        loc.score = changeTo;
        lines.set(locations.indexOf(loc) + advisories.size() + 1, loc.name +
             " - " + loc.score); // edits the correct line in lines
    }

    /**********************************
    * Removes a Location. Accepts the *
    * name of the Location to remove. *
    **********************************/
    public void removeLocation(String name) {
        Location loc = getLocByName(name);
        if (locations.indexOf(loc) == -1) return; // return if given location doesn't exist

        lines.remove(locations.indexOf(loc) + advisories.size() + 1);
        locations.remove(loc);
    }

    /**************************************************************
    * Pre-assigns an Advisory to a given Location. Pass in the    *
    * name of the Advisory and the name of the Location to assign *
    * it to. Pre-assigned Advisories won't be included in the     *
    * randomization process.                                      *
    **************************************************************/
    public void setLocation(String a, String l) {
        presetMap.put(getAdvByName(a), getLocByName(l));
    }

    /***************************************************************
    * Shuffles the Advisories and Locations to produce the fairest *
    * possible outcome. This method populates the assignments      *
    * HashMap, where the keys are Advisories and the values are    *
    * their assigned Locations.                                    *
    ***************************************************************/
    public void randomize() {
        ArrayList<Advisory> sortedA = new ArrayList<>();               // sorted ArrayList
        ArrayList<Advisory> unsortedA = (ArrayList)advisories.clone(); // make copy of advisories

        for (Advisory a : advisories) {     // loop through advisories
            if (presetMap.containsKey(a)) { // make sure advisory hasn't been preset
                unsortedA.remove(a);       // if so, remove it from the shuffle
            }
        }

        for (int i = 0; i < advisories.size(); i++) { // sorts advisories from least to greatest total using selection sort
            Advisory least = unsortedA.get(0);       // set initial value
            
            for (int j = 1; j < unsortedA.size(); j++) { // find lowest total
                if (unsortedA.get(j).total < least.total) {
                    least = unsortedA.get(j);
                }
            }

            sortedA.add(least);      // add to sorted list
            unsortedA.remove(least); // remove from unsorted list
        }

        ArrayList<Location> sortedL = new ArrayList<>();              // sorted ArrayList
        ArrayList<Location> unsortedL = (ArrayList)locations.clone(); // make copy of locations

        for (Location l : locations) {      // loop through locations
            if (presetMap.containsKey(l)) { // make sure location hasn't been preset
                unsortedL.remove(l);       // if so, remove it from the shuffle
            }
        }

        for (int i = 0; i < locations.size(); i++) { // sorts locations from greatest to least total using selection sort
            Location greatest = unsortedL.get(0);   // set initial value

            for (int j = 1; j < unsortedL.size(); j++) { // find greatest score
                if (unsortedL.get(j).score > greatest.score) {
                    greatest = unsortedL.get(j);
                }
            }

            sortedL.add(greatest);      // add to sorted list
            unsortedL.remove(greatest); // remove from unsorted list
        }

        boolean swaps = true; // whether or not location swaps are needed

        while (swaps) { // make sure no advisories are assigned to the same location as previously
            swaps = false;

            for (int i = 0; i < sortedA.size(); i++) {
                if (sortedA.get(i).location.equals(sortedL.get(i))) { // if an advisory is reassigned the same location
                    swaps = true;
                    Location assigned = sortedL.get(i);              // assigned location
                    ArrayList<Integer> possible = new ArrayList<>(); // list of other possible locations

                    /**************************************************************
                    * This section searches for other Locations with the same     *
                    * score that could be matched with the Advisory. If there are *
                    * none with the same score, it moves on to a difference of 1, *
                    * 2, and so on until a match is found. If there are multiple, *
                    * they are all added to possible.                             *
                    **************************************************************/
                    for (int o = 0; possible.size() == 0; o++) { // increases difference until match is found
                        for (Location l : locations) {
                            if (!l.equals(assigned) && Math.abs(l.score - assigned.score) == o) {
                                possible.add(sortedL.indexOf(l)); // adds all locations with the given difference
                            }
                        }
                    }

                    Collections.swap(sortedL, i, possible.get((int)(Math.random()
                        * possible.size()))); // picks a random possible and swaps it
                }
            }
        }

        for (int i = 0; i < sortedA.size(); i++) { // combine the two sorted lists into assignments
            assignments.put(sortedA.get(i), sortedL.get(i));
        }
        assignments.putAll(presetMap); // add the preset assignments

        for (Advisory a : advisories) {
            a.total += assignments.get(a).score; // update Advisory totals
            a.location = assignments.get(a);     // update Advisory locations
            lines.set(advisories.indexOf(a), a.name + " - " + a.total + " - " +
                locations.indexOf(a.location));  // update lines
        }
    }

    /***************************************
    * Returns the assignments hashmap with *
    * the keys and values as strings.      *
    ***************************************/
    public HashMap<String,String> getAssignmentsAsString() {
        HashMap<String,String> ret = new HashMap<>(); // HashMap to return

        for (Advisory adv : assignments.keySet()) { // loop through Advisories in assignments
            ret.put(adv.name, assignmetns.get(adv).name); // create new key value pair with names
        }

        return ret;
    }

    private Advisory getAdvByName(String name) {
        for (Advisory a : advisories) {        // loop through Advisories
            if (a.name.equals(name)) return a; // return if one is found with a matching name
        }

        System.out.println("No advisory with name " + name); // error handling
        return null;
    }

    private Location getLocByName(String name) {
        for (Location l : locations) {         // loop through Locations
            if (l.name.equals(name)) return l; // return if one is found with a matching name
        }

        System.out.println("No location with name " + name); // error handling
        return null;
    }
}

// Spencer Lutz, 2020
