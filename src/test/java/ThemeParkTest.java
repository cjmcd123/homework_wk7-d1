import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class ThemeParkTest {

    ThemePark themePark;
    Rollercoster rollercoster;
    Dodgems dodgems;
    Park park;
    Playground playground;
    CandyFlossStall candyFlossStall;
    DrinksStall drinksStall;
    IceCreamStall iceCreamStall;
    Visitor visitor;

    @Before
    public void setUp(){
        candyFlossStall = new CandyFlossStall("Candy Spot", "Bob", 1);
        dodgems = new Dodgems("Codeclan Dodgems");
        drinksStall = new DrinksStall("Drinks Spot", "Rob", 2);
        iceCreamStall = new IceCreamStall("Ice Spot", "Bobbie", 3);
        park = new Park("Codeclan Park");
        playground = new Playground("Codeclan Playground");
        rollercoster = new Rollercoster("Codeclan Rollercoaster");
        ArrayList<Stall> stalls = new ArrayList<Stall>();
        ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        stalls.add(candyFlossStall);
        stalls.add(drinksStall);
        attractions.add(dodgems);
        attractions.add(park);
        attractions.add(playground);
        themePark = new ThemePark("Codeclan Theme Park", attractions, stalls);
        visitor = new Visitor("Steve", 18, 190, 100);
    }

    @Test
    public void themeParkHasName(){
        assertEquals("Codeclan Theme Park", themePark.getName());
    }

    @Test
    public void themeParkHasAttractions(){
        assertEquals("Codeclan Dodgems", themePark.getAttractions().get(0).getName());
    }

    @Test
    public void themeParkCountAttractions(){
        assertEquals(3, themePark.attractionCount());
    }

    @Test
    public void themeParkHasStalls(){
        assertEquals("Candy Spot", themePark.getStalls().get(0).getName());
    }

    @Test
    public void themeParkCountStalls(){
        assertEquals(2, themePark.stallCount());
    }

    @Test
    public void canAddAttraction(){
        themePark.addAttraction(rollercoster);
        assertEquals(4, themePark.attractionCount());
    }

    @Test
    public void canAddStall(){
        themePark.addStall(iceCreamStall);
        assertEquals(3, themePark.stallCount());
    }

    @Test
    public void visitorCanVisitAttraction(){
        String result = themePark.visit(visitor, dodgems);
        assertEquals("Steve visits the Codeclan Dodgems", result);
        assertEquals(95.5, visitor.getMoney(), 0.02);
    }

    @Test
    public void canNotVisitPlayground(){
        String result = themePark.visit(visitor, playground);
        assertEquals("Steve is not eligible for the Codeclan Playground", result);
    }

    @Test
    public void canVisitPlayground(){
        Visitor tempVisitor = new Visitor("Jenny", 11, 149, 50);
        String result = themePark.visit(tempVisitor, playground);
        assertEquals("Jenny visits the Codeclan Playground", result);
    }

    @Test
    public void canBuyDrink(){
        String result = themePark.visit(visitor, drinksStall);
        assertEquals("Steve visits the Drinks Spot", result);
        assertEquals(93.4, visitor.getMoney(), 0.02);
    }

    @Test
    public void canNotBuyDrink(){
        Visitor tempVisitor = new Visitor("Jenny", 11, 149, 50);
        String result = themePark.visit(tempVisitor, drinksStall);
        assertEquals("Jenny is not eligible for the Drinks Spot", result);
    }

    @Test
    public void canRideRollercoaster(){
        themePark.addAttraction(rollercoster);
        String result = themePark.visit(visitor, rollercoster);
        assertEquals("Steve visits the Codeclan Rollercoaster", result);
        assertEquals(91.6, visitor.getMoney(), 0.02);
    }

    @Test
    public void canNotRideRollercoasterAge(){
        Visitor tempVisitor = new Visitor("Jenny", 11, 159, 50);
        themePark.addAttraction(rollercoster);
        String result = themePark.visit(tempVisitor, rollercoster);
        assertEquals("Jenny is not eligible for the Codeclan Rollercoaster", result);
    }

    @Test
    public void canNotRideRollercoasterHeight(){
        Visitor tempVisitor = new Visitor("Jenny", 13, 139, 50);
        themePark.addAttraction(rollercoster);
        String result = themePark.visit(tempVisitor, rollercoster);
        assertEquals("Jenny is not eligible for the Codeclan Rollercoaster", result);
    }

    @Test
    public void extraCostRollercoaster(){
        Visitor tempVisitor = new Visitor("Rob", 21, 201, 50);
        themePark.addAttraction(rollercoster);
        String result = themePark.visit(tempVisitor, rollercoster);
        assertEquals("Rob visits the Codeclan Rollercoaster", result);
        assertEquals(33.2, tempVisitor.getMoney(), 0.02);
    }

    @Test
    public void halfCostDodgems(){
        Visitor tempVisitor = new Visitor("Marie", 10, 143, 50);
        String result = themePark.visit(tempVisitor, dodgems);
        assertEquals("Marie visits the Codeclan Dodgems", result);
        assertEquals(47.75, tempVisitor.getMoney(), 0.02);
    }

    @Test
    public void canBuyCandyFloss(){
        String result = themePark.visit(visitor, candyFlossStall);
        assertEquals("Steve visits the Candy Spot", result);
        assertEquals(95.8, visitor.getMoney(), 0.02);
    }

    @Test
    public void canBuyIceCream(){
        themePark.addStall(iceCreamStall);
        String result = themePark.visit(visitor, iceCreamStall);
        assertEquals("Steve visits the Ice Spot", result);
        assertEquals(97.2, visitor.getMoney(), 0.02);
    }

    @Test
    public void arrayOfRatings(){
        ArrayList<Integer> results = themePark.getAllReviewed();
        assertEquals(5, results.size());
        int answer = results.get(0);
        assertEquals(0, answer);
    }

    @Test
    public void listOfAllowed(){
        themePark.addAttraction(rollercoster);
        ArrayList<ITickted> results = themePark.getAllAllowedFor(visitor);
        assertEquals(2, results.size());
        String answer = results.get(0).getName();
        assertEquals("Codeclan Dodgems", answer);
    }

    @Test
    public void StringOfRatings(){
        String expected = "Codeclan Dodgems: 0, Codeclan Park: 0, Codeclan Playground: 0, Candy Spot: 0, Drinks Spot: 0, ";
        String result = themePark.ratingString();
        assertEquals(expected, result);
    }
}
