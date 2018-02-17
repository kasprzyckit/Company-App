package backend

trait Manager{
  def hire (employee: Employee): Unit
  def fire (employee: Employee): Unit
  def canHire: Boolean
  var hiringPredicate: Employee => Boolean
}
