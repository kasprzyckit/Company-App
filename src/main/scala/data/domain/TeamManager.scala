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
                  val hiringLimit: Int)
  extends AbstractEmployee(firstName, lastName, role, email, gender, country, university, supervisor) with Manager {

  private val rnd = new Random

  private var employees_ : Set[Employee] = Set()

  override def employees: Set[Employee] = employees_

  override var hiringPredicate: Employee => Boolean = emp => true

  override def canHire: Boolean = employees_.size < hiringLimit

  override def fire(employee: Employee): Unit = {
    if (employees_.contains(employee)) employees_ = employees_ - employee
  }

  override def hire(employee: Employee): Unit = {
    if (canHire && hiringPredicate(employee)) employees_ = employees_ + employee
  }

  override def reportWork: Report = employees_.toList.foldLeft(new Report(List()))(_ + _.reportWork)

  override def assign(task: Task): Unit = employees_.toVector(rnd.nextInt(employees_.size)).assign(task)

  override def totalNumberOfEmployees: Int = employees_.size + employees_.filter(_.isInstanceOf[TeamManager]).foldLeft(0)(_ + _.asInstanceOf[TeamManager].totalNumberOfEmployees)
}
