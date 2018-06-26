import java.util.ArrayList;

public class ThemePark {

    private String name;
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(String name, ArrayList<Attraction> attractions, ArrayList<Stall> stalls){
        this.name = name;
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public void addStall(Stall stall){
        this.stalls.add(stall);
    }

    public int attractionCount(){
        return this.attractions.size();
    }

    public int stallCount(){
        return this.stalls.size();
    }

    public String visit(Visitor visitor, IReviewed attraction) {
        if (attraction instanceof ISecurity ){
            if (((ISecurity) attraction).isAllowedTo(visitor) == true){
                if (attraction instanceof ITickted) {
                    double price = ((ITickted) attraction).priceFor(visitor);
                    visitor.pay(price);
                    return visitor.getName() + " visits the " + attraction.getName();
                }
                return visitor.getName() + " visits the " + attraction.getName();
            }
            return visitor.getName() + " is not eligible for the " + attraction.getName();
        }
        double price = ((ITickted) attraction).priceFor(visitor);
        visitor.pay(price);
        return visitor.getName() + " visits the " + attraction.getName();
    }

//    public String visitStall(Visitor visitor, Stall stall){
//        if (stall instanceof ISecurity){
//            if (((ISecurity) stall).isAllowedTo(visitor) == true){
//                double price = ((ITickted) stall).priceFor(visitor);
//                visitor.pay(price);
//                return visitor.getName() + " visits " + stall.getName();
//            }
//            return visitor.getName() + " is not eligible for " + stall.getName();
//        }
//        double price = ((ITickted) stall).priceFor(visitor);
//        visitor.pay(price);
//        return visitor.getName() + " visits " + stall.getName();
//    }

    public ArrayList<Integer> getAllReviewed(){
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (Attraction attraction : getAttractions()){
            results.add(attraction.getRating());
        }
        for (Attraction stall : getStalls()){
            results.add(stall.getRating());
        }
        return results;
    }

    public ArrayList<ITickted> getAllAllowedFor(Visitor visitor) {
        ArrayList<ITickted> results = new ArrayList<ITickted>();
        for (Attraction attraction : getAttractions()) {
            if (attraction instanceof ITickted) {
                if (attraction instanceof ISecurity) {
                    if (((ISecurity) attraction).isAllowedTo(visitor)) {
                        results.add((ITickted) attraction);
                    }
                } else {
                    results.add((ITickted) attraction);
                }
            }
        }
        return results;
    }

    public String ratingString() {
        String result = "";
        for (Attraction attraction : getAttractions()){
            result = result + attraction.getName() + ": " + attraction.getRating() + ", ";
        }
        for (Attraction stall : getStalls()){
            result = result + stall.getName() + ": " + stall.getRating() + ", ";
        }
        return result;
    }
}
