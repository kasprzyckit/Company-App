import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorNameTest(){
        Task task = new Task("111", 4);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructorUOWTest(){
        Task task = new Task("Debugging", -54);
    }
    @Test
    public void toStringTest()
    {
        assertEquals("Debugging: 5 units of work",new Task("Debugging", 5).toString());
        assertEquals("De bug: 0 units of work",new Task("De bug", 0).toString());
        Task task = new Task ("Debugging", 5);
        task.setPerformer(new Developer("John Smith", "Dev"));
        assertEquals("Debugging: 5 units of work done by John Smith", task.toString());
    }
}
