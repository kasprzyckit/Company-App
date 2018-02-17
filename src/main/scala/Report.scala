class Report (val tasks: List[Task]) {

  def addTaskAll (otherTasks: List[Task]): Report =
    new Report ((otherTasks ++ tasks).sortBy(t =>
    (t.employee.lastName, t.employee.firstName, t.employee.role, t.units.units)))

  def addTask (task: Task): Report = addTaskAll(List(task))

  def +(other: Report): Report = addTaskAll(other.tasks)
}