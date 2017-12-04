
public interface Employee {
    public String getName();
    public String getRole();
    public void setRole(String role);
    public Manager getSuperior();
    public void setSuperior(Manager superior);
    public void assaign(Task task);
    public Report reportWork();
}
