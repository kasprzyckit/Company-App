package data.domain

import data.domain.Gender.Gender

trait Employee{
  val firstName: String
  val lastName: String
  val role: String
  var email: Email
  val gender: Gender
  val country: String
  val university: String

  def assign(task: Task): Unit
  def reportWork: Report
}
