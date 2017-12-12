import org.junit.Test;

import static org.junit.Assert.*;

public class DeveloperTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorNameTest()
    {
        Employee dev = new Developer("a123", "Developer");
        System.out.println(dev);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructorRoleTest()
    {
        Employee dev = new Developer("John Smith", "3Developer");
    }
}
