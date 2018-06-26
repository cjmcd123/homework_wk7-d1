import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandyFlossStallTest {

    CandyFlossStall candyFlossStall;

    @Before
    public void setUp(){
        candyFlossStall = new CandyFlossStall("The Candy Spot", "Bob", 3);
    }

    @Test
    public void stallHasName(){
        assertEquals("The Candy Spot", candyFlossStall.getName());
    }

    @Test
    public void stallHasOwner(){
        assertEquals("Bob", candyFlossStall.getOwner());
    }

    @Test
    public void stallHasSpot(){
        assertEquals(3, candyFlossStall.getSpot());
    }

    @Test
    public void stallHasRating(){
        assertEquals(0, candyFlossStall.getRating());
    }

    @Test
    public void stallCanChangeRating(){
        candyFlossStall.setRating(10);
        assertEquals(10, candyFlossStall.getRating());
    }
}
