public class Rollercoster extends Attraction implements ISecurity, ITickted{

    private double price;

    public Rollercoster(String name){
        super(name);
        this.price = 8.40;
    }

    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() < 12 || visitor.getHeight() < 145){
            return false;
        } else {
            return true;
        }
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() > 200){
            return this.price * 2;
        } else {
            return defaultPrice();
        }
    }

}
