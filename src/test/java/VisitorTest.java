import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;

    @Before
    public void setUp(){
        visitor = new Visitor("Bob", 12, 154, 20);
    }

    @Test
    public void visitorHasName(){
        assertEquals("Bob", visitor.getName());
    }

    @Test
    public void visitorHasAge(){
        assertEquals(12, visitor.getAge());
    }

    @Test
    public void visitorHasHeight(){
        assertEquals(154, visitor.getHeight());
    }

    @Test
    public void visitorHasMoney(){
        assertEquals(20, visitor.getMoney(), 0.02);
    }


}
