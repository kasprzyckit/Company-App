import java.util.Random;
import java.util.List;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CompanyFactory {
    private Random gen = new Random();
    private List<String> firstNames = new LinkedList<>();
    private List<String> lastNames = new LinkedList<>();
    private List<String> workDomain = new LinkedList<String>(){{add("Development");add("Back-end");add("Front-end");add("Testing");}};
    private List<String> prefixes = new LinkedList<String>(){{add("Junior");add("Middle");add("Senior");}};

    public CompanyFactory()
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

    public Company createRandomCompany(int levels)
    {
        if (levels < 1) throw new IllegalArgumentException("Level number too low");
        Manager boss = new TeamManager(randomName(),"CEO", gen.nextInt(levels-1)+2);
        recursiveHierachyCreator(boss, levels - 1);
        return new Company("Comp", boss);
    }

    private void recursiveHierachyCreator(Manager man, int level)
    {
        if (level <= 1)
        {
            while (man.canHire()) man.hire(new Developer(randomName(),randomDeveloperRole()));
            return;
        }
        while (man.canHire() && gen.nextInt(10)>0)
        {
            Manager newManager = new TeamManager(randomName(), randomManagerRole(), gen.nextInt(level)+2);
            recursiveHierachyCreator(newManager, level-1);
            man.hire(newManager);
        }
    }

    private String randomName()
    {
        return firstNames.get(gen.nextInt(firstNames.size()))+" "+lastNames.get(gen.nextInt(lastNames.size()));
    }

    private String randomManagerRole()
    {
        return workDomain.get(gen.nextInt(workDomain.size())) + " Team Manager";
    }
    private String randomDeveloperRole()
    {
        return prefixes.get(gen.nextInt(prefixes.size())) + " " +
                workDomain.get(gen.nextInt(workDomain.size())) + " Developer";
    }
}
