package data.domain

trait Manager extends Employee{
  def hire (employee: Employee): Unit
  def fire (employee: Employee): Unit
  def canHire: Boolean
  var employees: Set[Employee]
  def totalNumberOfEmployees: Int
  def allEmployees: Set[Employee]
  def allManagers: Set[Manager]
  var hiringPredicate: Employee => Boolean
  var hiringLimit: Int
}
