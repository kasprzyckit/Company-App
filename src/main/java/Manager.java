import java.util.List;
public interface Manager extends Employee {
    public void hire(Employee employee);
    public void fire(Employee employee);
    public boolean canHire();
    public List<Employee> getEmployees();
}
