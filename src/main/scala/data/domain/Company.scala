package data.domain

class Company (var name: String, var director: Manager) {
  override def toString: String = name
}
