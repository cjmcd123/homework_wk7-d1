public class IceCreamStall extends Stall implements ITickted{

    private double price;

    public IceCreamStall(String name, String owner, int parkingSpot){
        super(name, owner, parkingSpot);
        this.price = 2.80;
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        return defaultPrice();
    }

}
