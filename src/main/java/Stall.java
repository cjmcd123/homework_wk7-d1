public abstract class Stall extends Attraction{

    private String owner;
    private int parkingSpot;


    public Stall(String name, String owner, int parkingSpot){
        super(name);
        this.owner = owner;
        this.parkingSpot = parkingSpot;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getSpot() {
        return this.parkingSpot;
    }
}
