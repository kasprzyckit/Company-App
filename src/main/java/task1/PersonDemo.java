package task1;

import static java.lang.System.*;

public class PersonDemo {
    public static void main(String[] args)
    {
        try {
            Person person = new Person("John", "Smith", "smith.john@gmail.com");
            out.println(person);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
