import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;

    @Before
    public void setUp(){
        park = new Park("Codeclan Park");
    }

    @Test
    public void parkHasName(){
        assertEquals("Codeclan Park", park.getName());
    }

    @Test
    public void stallHasRating(){
        assertEquals(0, park.getRating());
    }

    @Test
    public void stallCanChangeRating(){
        park.setRating(10);
        assertEquals(10, park.getRating());
    }
}
