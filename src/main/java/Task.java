public class Task {
    private String taskName;
    private Integer unitsOfWork;
    private Employee performer;

    public Task(String name, int unitsOfWork) throws IllegalArgumentException {
        if (name.matches("[A-Z][A-Za-z ]+\\w"))this.taskName = name;
        else throw new IllegalArgumentException("Invalid task name.");
        if (unitsOfWork >= 0) this.unitsOfWork = unitsOfWork;
        else throw new IllegalArgumentException("Invalid amount of units of work.");
    }

    public String getTaskName() {
        return taskName;
    }

    public Integer getUnitsOfWork() {
        return unitsOfWork;
    }

    public void setPerformer(Employee performer)
    {
        this.performer = performer;
    }

    public String toString()
    {
        String ret =  taskName + ": " + unitsOfWork + " units of work";
        if (performer != null) return ret + " done by " + performer.getName();
        else return ret;
    }
}