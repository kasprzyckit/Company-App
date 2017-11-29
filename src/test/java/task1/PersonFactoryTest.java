package task1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonFactoryTest {

    @Test
    public void factoryTest()
    {
        PersonFactory factory = new PersonFactory();
        Person person = factory.createRandomPerson();
        assertEquals("FirstName LastName", person.getName() + " " + person.getSurname());
    }
}
