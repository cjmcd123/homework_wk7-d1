import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DodgemsTest {

    Dodgems dodgems;

    @Before
    public void setUp(){
        dodgems = new Dodgems("Codeclan Dodgems");
    }

    @Test
    public void dodgemsHasName(){
        assertEquals("Codeclan Dodgems", dodgems.getName());
    }

    @Test
    public void stallHasRating(){
        assertEquals(0, dodgems.getRating());
    }

    @Test
    public void stallCanChangeRating(){
        dodgems.setRating(10);
        assertEquals(10, dodgems.getRating());
    }

}
