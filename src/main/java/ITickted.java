public interface ITickted {

    public double defaultPrice();
    public double priceFor(Visitor visitor);
    public String getName();
}
