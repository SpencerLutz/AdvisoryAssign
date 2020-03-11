public class Advisory {
    public String name;
    int total;
    int ptemp;
    Location previous;
    Advisory(String name, int total, Location previous){
        this.name = name;
        this.total = total;
        this.previous = previous;
    }
    Advisory(String name, int total, int ptemp){
        this.name = name;
        this.total = total;
        this.ptemp = ptemp;
    }
    void addToTotal(Location l){
        total += l.score;
    }
}
