public class Dodgems extends Attraction implements ITickted{

    private double price;

    public Dodgems(String name){
        super(name);
        this.price = 4.50;
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getAge() <= 12) {
            return this.price / 2;
        } else {
            return defaultPrice();
        }
    }

}
