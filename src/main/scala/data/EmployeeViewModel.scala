package data

import java.util

import controllers.MainController
import data.domain.Gender.Gender
import data.domain._

import collection.JavaConverters._

class EmployeeViewModel {
  var currentEmployee: Employee = _

  var managers: util.Collection[Manager] = _

  def createEmployee(): Unit = {
    val supervisor:Manager = if (MainController.companyViewModel.currentlySelected != null)
      MainController.companyViewModel.currentlySelected.asInstanceOf[Manager] else null

    currentEmployee = new Developer ("", "", "", "", Gender.M, "", "", supervisor, MainController.companyViewModel.currentCompany)
    initManagers()
  }

  def editEmployee(employee: Employee): Unit = {
    currentEmployee = employee
    initManagers()
  }

  def initManagers(): Unit = currentEmployee match {
    case manager: Manager => managers = (currentEmployee.company.director.allManagers - manager).asJavaCollection
    case employee: Employee => managers = currentEmployee.company.director.allManagers.asJavaCollection
  }

  def save(firstName: String,
           lastName: String,
           role: String,
           email:String,
           university: String,
           country: String,
           gender: Gender,
           employeeType: String,
           supervisor: Manager): String = {
    if (List[String](firstName, lastName, role, email, university, country, employeeType).foldLeft[Boolean](false)(_ || _.isEmpty) || gender == null)
      return "All attributes must be specified!"
    
    var newEmail: Email = null
    try {
      newEmail = Email(email)
    } catch {
      case e: IllegalArgumentException => return "Wrong email format"
      case _ =>
    }

    val newEmployee: Employee = employeeType match {
      case "Manager" => new TeamManager(firstName, lastName, role, newEmail, gender, country, university, supervisor, MainController.companyViewModel.currentCompany, 7)
      case "Developer" => new Developer(firstName, lastName, role, newEmail, gender, country, university, supervisor, MainController.companyViewModel.currentCompany)
    }
    if (supervisor == null) {
      currentEmployee.clone(newEmployee)
      return ""
    }
    if ((supervisor != currentEmployee.supervisor && !supervisor.canHire) || ! supervisor.hiringPredicate(newEmployee))
      return "The supervisor cannot hire this employee"

    currentEmployee match {
      case manager: Manager => newEmployee match {
        case managerN: Manager => managerN.employees = manager.employees
        case employee: Employee if manager.employees.nonEmpty =>
          return "The employee is a supervisor of one or more employees and cannot be changed to a developer"
      }
    }
    currentEmployee.supervisor.fire(currentEmployee)
    supervisor.hire(newEmployee)
    
    ""
  }

}