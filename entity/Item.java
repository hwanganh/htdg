package entity;

public abstract class Item extends Entity{
    protected String id;
    protected String name;
    protected double startingPrice;

    public Item(String id, String name, double startingPrice) {
        this.id = id;
        this.name = name;
        this.startingPrice = startingPrice;
    }

    public abstract String getDetails(); 

    public String getID() { return this.id; }
    public String getName() { return this.name; }
    public double getStartingPrice() { return this.startingPrice; }

    void setID(String id) { this.id = id; }
    void setName(String name) { this.name = name; }
    void setStartingPrice(double startingPrice) { this.startingPrice = startingPrice; }
}