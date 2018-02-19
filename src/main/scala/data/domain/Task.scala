package data.domain

class Task (val name: String, val units: UnitsOfWork, val employee: Employee){

  def this(name: String, units: UnitsOfWork) = this(name, units, null)

  def setEmployee(employee: Employee) = new Task(name, units, employee)

  override def toString: String = "\"" + name + "\" done by " + employee + " [" + units + " uow]"
}