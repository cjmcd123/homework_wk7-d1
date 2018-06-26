public class CandyFlossStall extends Stall implements ITickted{

    private double price;

    public CandyFlossStall(String name, String owner, int parkingSpot){
        super(name, owner, parkingSpot);
        this.price = 4.20;
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        return defaultPrice();
    }

}
