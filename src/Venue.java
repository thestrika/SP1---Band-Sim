public class Venue {
    private String name;
    private int capacity;
    private double payAmount;

    public Venue(String name, int capacity, double payAmount){
        this.name = name;
        this.capacity = capacity;
        this.payAmount = payAmount;
    }

    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public double getPayAmount(){
        return payAmount;
    }

    public String toString(){
        return " - Venue name: " + name + " | Capacity: " + capacity + " | Earn pr. show: " + payAmount;
    }


}
