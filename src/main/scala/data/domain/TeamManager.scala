package data.domain

import data.domain.Gender.Gender

import scala.util.Random

class TeamManager(firstName: String,
                  lastName: String,
                  role: String,
                  email: Email,
                  gender: Gender,
                  country: String,
                  university: String,
                  supervisor: Manager,
                  company: Company,
                  var hiringLimit: Int)
  extends AbstractEmployee(firstName, lastName, role, email, gender, country, university, supervisor, company) with Manager {

  private val rnd = new Random

  var employees : Set[Employee] = Set()

  override var hiringPredicate: Employee => Boolean = emp => true

  override def canHire: Boolean = employees.size < hiringLimit

  override def fire(employee: Employee): Unit = {
    if (employees.contains(employee)) employees = employees - employee
  }

  override def hire(employee: Employee): Unit = {
    if (canHire && hiringPredicate(employee)) {
      employees = employees + employee
      employee.supervisor = this
      employee.company = company
    }
  }

  override def reportWork: Report = employees.toList.foldLeft(new Report(List()))(_ + _.reportWork)

  override def assign(task: Task): Unit = employees.toVector(rnd.nextInt(employees.size)).assign(task)

  override def totalNumberOfEmployees: Int = employees.size + employees.filter(_.isInstanceOf[Manager]).foldLeft(0)(_ + _.asInstanceOf[Manager].totalNumberOfEmployees)

  override def allEmployees: Set[Employee] = employees ++ employees.filter(_.isInstanceOf[Manager]).foldLeft(Set[Employee]())(_ ++ _.asInstanceOf[Manager].allEmployees)

  override def allManagers: Set[Manager] = Set(this) ++ employees.filter(_.isInstanceOf[Manager]).foldLeft(Set[Manager]())(_ ++ _.asInstanceOf[Manager].allManagers)

  override def clone(employee: Employee): Unit = {
    super.clone(employee)
    hiringPredicate = employee.asInstanceOf[Manager].hiringPredicate
    hiringLimit = employee.asInstanceOf[Manager].hiringLimit
    employees = employee.asInstanceOf[Manager].employees
  }
}
