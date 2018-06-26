import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IceCreamStallTest {

    IceCreamStall iceCreamStall;

    @Before
    public void setUp(){
        iceCreamStall = new IceCreamStall("The Ice Spot", "Bob", 3);
    }

    @Test
    public void stallHasName(){
        assertEquals("The Ice Spot", iceCreamStall.getName());
    }

    @Test
    public void stallHasOwner(){
        assertEquals("Bob", iceCreamStall.getOwner());
    }

    @Test
    public void stallHasSpot(){
        assertEquals(3, iceCreamStall.getSpot());
    }

    @Test
    public void stallHasRating(){
        assertEquals(0, iceCreamStall.getRating());
    }

    @Test
    public void stallCanChangeRating(){
        iceCreamStall.setRating(10);
        assertEquals(10, iceCreamStall.getRating());
    }
}
