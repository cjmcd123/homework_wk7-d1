import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {

    Playground playground;

    @Before
    public void setUp(){
        playground = new Playground("Codeclan Playground");
    }

    @Test
    public void playgroundHasName(){
        assertEquals("Codeclan Playground", playground.getName());
    }

    @Test
    public void stallHasRating(){
        assertEquals(0, playground.getRating());
    }

    @Test
    public void stallCanChangeRating(){
        playground.setRating(10);
        assertEquals(10, playground.getRating());
    }
}
