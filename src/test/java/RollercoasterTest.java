import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    Rollercoster rollercoster;

    @Before
    public void setUp(){
        rollercoster = new Rollercoster("Codeclan Rollercoaster");
    }

    @Test
    public void rollercosterHasName(){
        assertEquals("Codeclan Rollercoaster", rollercoster.getName());
    }

    @Test
    public void stallHasRating(){
        assertEquals(0, rollercoster.getRating());
    }

    @Test
    public void stallCanChangeRating(){
        rollercoster.setRating(10);
        assertEquals(10, rollercoster.getRating());
    }
}
