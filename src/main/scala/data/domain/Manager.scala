package data.domain

trait Manager{
  def hire (employee: Employee): Unit
  def fire (employee: Employee): Unit
  def canHire: Boolean
  def employees: Set[Employee]
  def totalNumberOfEmployees: Int
  var hiringPredicate: Employee => Boolean
}
