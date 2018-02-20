package data.domain

class Company (val name: String, val director: TeamManager) {
  override def toString: String = name
}
