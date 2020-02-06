public class Advisory {
    String name;
    int total;
    Advisory(String name, int score){
        this.name = name;
        this.total = total;
    }
    void addToTotal(Location l){
        total += l.score;
    }
}
