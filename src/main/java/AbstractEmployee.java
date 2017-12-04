public abstract class AbstractEmployee implements Employee{
    String name;
    String role;
    private Manager superior = null;

    public AbstractEmployee(String name, String role)
    {
        if (name.matches("\\w[\\w ]+")) this.name = name;
        else throw new IllegalArgumentException("Invalid name:" + name);
        if (role.matches("\\w[\\w ]+")) this.role = role;
        else throw new IllegalArgumentException("Invalid role:" + role);
    }
    public AbstractEmployee(String name, String role, Manager superior)
    {
        this(name, role);
        this.superior = superior;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.matches("\\w[\\w ]+")) this.role = role;
        else throw new IllegalArgumentException("Invalid role:" + role);
    }

    public Manager getSuperior() {
        return superior;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }
}
