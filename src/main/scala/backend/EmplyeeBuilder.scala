package backend

import backend.Gender.Gender

class EmplyeeBuilder(f: String, l: String) {
  private var firstName: String = f
  private var lastName: String = l
  private var role: String = _
  private var email: Email = _
  private var gender: Gender = _
  private var country: String = _
  private var university: String = _
  private var hiringLimit: Int = _

  def setFirstName(n: String) {firstName = n}
  def setLastName(n: String) {lastName = n}
  def setRole(n: String) {role = n}
  def setEmail(n: Email) {email = n}
  def setGender(n: Gender) {gender = n}
  def setCountry(n: String) {country = n}
  def setUniversity(n: String) {university = n}
  def setHiringLimit(n: Int) {hiringLimit = n}

  def createDeveloper = new Developer(firstName, lastName, role, email, gender, country, university)
  def createTeamMenager = new TeamManager(firstName, lastName, role, email, gender, country, university, hiringLimit)
}
