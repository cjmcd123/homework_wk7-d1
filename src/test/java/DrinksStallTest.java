import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinksStallTest {

    DrinksStall drinksStall;

    @Before
    public void setUp(){
        drinksStall = new DrinksStall("The Drinks Spot", "Bob", 3);
    }

    @Test
    public void stallHasName(){
        assertEquals("The Drinks Spot", drinksStall.getName());
    }

    @Test
    public void stallHasOwner(){
        assertEquals("Bob", drinksStall.getOwner());
    }

    @Test
    public void stallHasSpot(){
        assertEquals(3, drinksStall.getSpot());
    }

    @Test
    public void stallHasRating(){
        assertEquals(0, drinksStall.getRating());
    }

    @Test
    public void stallCanChangeRating(){
        drinksStall.setRating(10);
        assertEquals(10, drinksStall.getRating());
    }
}
