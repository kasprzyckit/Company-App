
public interface Employee {
    public String getName();
    public String getRole();
    public void setSuperior(Manager superior);
    public Manager getSuperior();
    public void assaign(Task task);
    public Report reportWork();
}