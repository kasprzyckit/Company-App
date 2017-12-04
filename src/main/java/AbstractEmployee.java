public abstract class AbstractEmployee implements Employee{
    String name;
    String role;
    public AbstractEmployee(String name, String role)
    {
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return role;
    }
}
