import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TeamManager extends AbstractEmployee implements Manager{
    private final List<Employee> employeeList = new ArrayList<>();
    private final Integer subordinateNumber;
    private final Random gen = new Random();

    public TeamManager(String name, String role, int subordinateNumber)
    {
        super(name, role);
        if (subordinateNumber > 0) this.subordinateNumber = subordinateNumber;
        else throw new IllegalArgumentException("Invalid number of subordinates: " + subordinateNumber);
    }

    @Override
    public boolean canHire() {
        return subordinateNumber > employeeList.size();
    }

    @Override
    public void fire(Employee employee) {
        employeeList.remove(employee);
        employee.setSuperior(null);
    }

    @Override
    public void hire(Employee employee) {
        employeeList.add(employee);
        employee.setSuperior(this);
    }

    public void assaign(Task task)
    {
        if (!employeeList.isEmpty()) employeeList.get(gen.nextInt(employeeList.size())).assaign(task);
        else System.out.println("Cannot assign task " + task.getTaskName());
    }

    public Report reportWork()
    {
        Report report = new Report(new LinkedList<>());
        for (Employee employee : employeeList) report = report.concatenate(employee.reportWork());
        return report;
    }
}
