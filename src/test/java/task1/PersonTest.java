package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void toStringTest()
    {
        Person p1 = new Person ("John", "Smith", "smith@gmail.com");

        assertEquals("John Smith (smith@gmail.com)", p1.toString());
    }

    @Test
    public void compareToTest(){
        Person p1 = new Person ("John", "Smith", "smith@gmail.com");

        assertEquals(0, p1.compareTo(new Person("John", "Smith", "smith@gmail.com")));

        assertEquals(1, p1.compareTo(new Person("John", "Smith", "asmith@gmail.com")));

        assertEquals(-1, p1.compareTo(new Person("John", "Zen", "smith@gmail.com")));

        assertEquals(1, p1.compareTo(new Person("Albert", "Smith", "smith@gmail.com")));
    }
}
