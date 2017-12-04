import java.util.Hashtable;

public class TeamManager extends AbstractEmployee implements Manager{
    private Hashtable<Employee, Boolean> employees = new Hashtable<>();
    public TeamManager(String name, String role)
    {
        super(name, role);
    }

    @Override
    public boolean canHire() {
        return false;
    }

    @Override
    public void fire(Employee employee) {

    }

    @Override
    public void hire(Employee employee) {

    }
}
