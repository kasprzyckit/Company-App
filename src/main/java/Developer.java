import java.util.List;
import java.util.LinkedList;

public class Developer extends AbstractEmployee {
    private List<Task> tasks = new LinkedList<>();
    public Developer(String name, String role) throws IllegalArgumentException
    {
        super(name, role);
    }

    public void assaign(Task task)
    {
        tasks.add(task);
        System.out.println(task);
        task.setPerformer(this);
    }

    public Report reportWork()
    {
        return new Report(tasks);
    }
}
