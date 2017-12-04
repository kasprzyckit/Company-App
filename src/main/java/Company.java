import java.util.List;
import java.util.LinkedList;

public class Company {
    private String name;
    private Manager boss;

    public Company(String name, Manager boss)
    {
        if (name.matches("\\w[\\w ]+\\w")) this.name = name;
        else throw new IllegalArgumentException("Invalid company name: " + name);
        if (boss != null) this.boss = boss;
        else throw new NullPointerException();
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder(name + "\n");
        int indentation = 0;
        recursiveHierarchy(boss, str, indentation);
        return str.toString();
    }

    private void recursiveHierarchy(Employee emp, StringBuilder str, int indentation)
    {
        str.append("\n");
        for (int i=0; i<indentation;i++) str.append("--");
        str.append(emp.toString());
        if (emp instanceof Manager)
        {
            Manager man = (Manager) emp;
            for (Employee empl: man.getEmployees()) recursiveHierarchy(empl, str, indentation+1);
        }
    }
}
