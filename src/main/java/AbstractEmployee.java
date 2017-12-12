public abstract class AbstractEmployee implements Employee{
    private String name;
    private String role;
    private Manager superior;
    public AbstractEmployee(String name, String role) throws IllegalArgumentException
    {
        if (name.matches("[A-Z][a-zA-Z -]+")) this.name = name;
        else throw new IllegalArgumentException("Invalid name:" + name);
        if (role.matches("[A-Z][a-zA-Z -]+")) this.role = role;
        else throw new IllegalArgumentException("Invalid role:" + role);
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
    public void setSuperior(Manager superior)
    {
        this.superior = superior;
    }
    public Manager getSuperior()
    {
        return superior;
    }

    public String toString()
    {
        return name + " (" + role + ")";
    }
}
