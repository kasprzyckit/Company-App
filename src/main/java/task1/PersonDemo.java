package task1;

import java.util.ListIterator;

import static java.lang.System.*;

public class PersonDemo {
    public static void main(String[] args)
    {
        try {
            Person person = new Person("John", "Smith", "smith.john@gmail.com");
            out.println(person);
            PersonFactory factory = new PersonFactory();
            ListIterator<Person> it = factory.createRandomPersonList(30).listIterator();
            while (it.hasNext()) out.println(it.next());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
