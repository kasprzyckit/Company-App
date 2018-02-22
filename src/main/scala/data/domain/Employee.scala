package data.domain

import data.domain.Gender.Gender

trait Employee{
  var firstName: String
  var lastName: String
  var role: String
  var email: Email
  var gender: Gender
  var country: String
  var university: String
  var supervisor: Manager
  var company: Company

  def assign(task: Task): Unit
  def reportWork: Report
  def name: String
  def clone(employee: Employee): Unit
}
