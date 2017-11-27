package task1;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;

import static java.lang.System.*;

public class PersonDemo {
    public static void main(String[] args)
    {
        try {
            PersonFactory factory = new PersonFactory();
            LinkedList<Person> randomPeople = factory.createRandomPersonList(30);
            Collections.sort(randomPeople, (p1, p2) -> p1.compareTo(p2));

            ListIterator<Person> it = randomPeople.listIterator();
            while (it.hasNext()) out.println(it.next());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

