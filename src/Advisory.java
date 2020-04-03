public class Advisory {

    public String name; // name of advisory
    int total;          // sum of past location values
    int locationIndex;  // index of current location
    Location location;  // current location

    Advisory(String name, int total, Location location) {
        this.name = name;
        this.total = total;
        this.location = location;
    }

    Advisory(String name, int total, int locationIndex) {
        this.name = name;
        this.total = total;
        this.locationIndex = locationIndex;
    }

    void addToTotal(Location l) { // update total with the current location
        total += l.score;
    }
}

// Spencer Lutz, 2020