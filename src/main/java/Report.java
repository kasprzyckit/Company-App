import java.util.List;
import java.util.LinkedList;

public class Report {
    private List<Task> tasks;

    public Report(List<Task> tasks)
    {
        this.tasks = tasks;
    }

    public String toString()
    {
        int total = 0;
        String report = "Work reported:";
        for (Task task : tasks)
        {
            report = report.concat("\n" + task);
            total += task.getUnitsOfWork();
        }
        report = report.concat("\nIn total: " + total + " units of work");
        return report;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Report concatenate(Report report)
    {
        List<Task> conTasks = new LinkedList<>(tasks);
        conTasks.addAll(report.getTasks());
        return new Report(conTasks);
    }
}
