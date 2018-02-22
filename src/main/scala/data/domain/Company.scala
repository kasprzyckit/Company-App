package data.domain

class Company (var name: String, var director: Manager) {
  override def toString: String = name
  def managers: Set[Manager] = if (director == null) Set() else director.allManagers
}
