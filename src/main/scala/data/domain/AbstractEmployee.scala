package data.domain

import Gender.Gender

abstract class AbstractEmployee(var firstName: String,
                                var lastName: String,
                                var role: String,
                                var email: Email,
                                var gender: Gender,
                                var country: String,
                                var university: String,
                                var supervisor: Manager,
                                var company: Company) extends Employee {

  override def toString: String = firstName + " " + lastName + " (" + role +")"

  override def clone(employee: Employee): Unit = {
    firstName = employee.firstName
    lastName = employee.lastName
    role = employee.role
    email = employee.email
    gender = employee.gender
    country = employee.country
    university = employee.university
    supervisor = employee.supervisor
  }

  def name: String = firstName + " " + lastName
}
