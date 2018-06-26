public class DrinksStall extends Stall implements ISecurity, ITickted{

    private double price;

    public DrinksStall(String name, String owner, int parkingSpot){
        super(name, owner, parkingSpot);
        this.price = 6.60;
    }

    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() < 18){
            return false;
        } else {
            return true;
        }
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        return defaultPrice();
    }

}
