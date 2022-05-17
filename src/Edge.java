public class Edge {
    private String source;
    private String destination;
    private final int cost;

    public Edge(String source, String destination, int cost){
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public int getCost(){
        return this.cost;
    }

    public String getSource(){
        return this.source;
    }

    public String getDestination(){
        return this.destination;
    }
}
