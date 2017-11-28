package task1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class PersonFactory {
    private List<String> firstNames = new LinkedList<>();
    private List<String> lastNames = new LinkedList<>();
    private String[] emails = {"@gmail.com", "@yahoo.com", "@company.fr", "@usembassy.eu"};

    public PersonFactory()
    {
        BufferedReader br = null;
        String name;

        try{
            br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("firstnames.txt")));
            while ((name = br.readLine()) != null) firstNames.add(name);

            br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("lastnames.txt")));
            while ((name = br.readLine()) != null) lastNames.add(name);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public Person createRandomPerson()
    {
        Random random = new Random();
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lasttName = lastNames.get(random.nextInt(lastNames.size()));
        return new Person(firstName, lasttName, generateEmail(firstName, lasttName));
    }

    public LinkedList<Person> createRandomPersonList(int n)
    {
        LinkedList<Person> persons = new LinkedList<>();
        for (int i = 0; i<n; i++) persons.add(createRandomPerson());
        return persons;
    }

    private String generateEmail(String firstName, String lastName)
    {

        int emailFormat = firstName.hashCode()*29 + lastName.hashCode()*13;
        switch (Math.abs(emailFormat)%4){
            case 0: return firstName.toLowerCase() + lastName.toLowerCase() + emails[(firstName.length()+lastName.length())%4];
            case 1: return lastName.toLowerCase() + "." + firstName.toLowerCase() + emails[(firstName.length()+lastName.length())%4];
            case 2: return firstName.substring(0,1).toLowerCase() + lastName.toLowerCase() + emails[(firstName.length()+lastName.length())%4];
            case 3: return lastName.toLowerCase() + Integer.toString((emailFormat)%100+100) + emails[(firstName.length()+lastName.length())%4];
        }
        return null;
    }
}
