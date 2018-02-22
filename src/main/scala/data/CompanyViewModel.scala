package data

import javafx.beans.property.{ListProperty, SimpleListProperty}
import javafx.collections.{FXCollections, ObservableList}

import collection.JavaConverters._
import controllers.MainController
import data.domain._

class CompanyViewModel {

  var currentCompany: Company = _

  var currentlySelected: Employee = _

  private var employeesListData: ObservableList[Employee] = FXCollections.observableArrayList[Employee]
  val employeesListProperty: ListProperty[Employee] = new SimpleListProperty[Employee](employeesListData)

  def createNewCompany(): Unit = {
    val c = new Company("NewCompany" + MainController.companiesListModel.numberOfCompanies, null)

    val p1 = new TeamManager("H", "Ockham", "CEO", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c, 6)
    val p2 = new TeamManager("H2", "Ockham", "Man", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c, 6)
    val p3 = new TeamManager("H3", "Ockham", "Man", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c, 6)
    val p4 = new TeamManager("H4", "Ockham", "Man", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c, 6)
    val p5 = new TeamManager("H5", "Ockham", "Man", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c, 6)

    val r1 = new Developer("d1", "Ockham", "Dev", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c)
    val r2 = new Developer("d2", "Ockham", "Dev", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c)
    val r3 = new Developer("d3", "Ockham", "Dev", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c)
    val r4 = new Developer("d4", "Ockham", "Dev", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c)
    val r5 = new Developer("d5", "Ockham", "Dev", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c)
    val r6 = new Developer("d6", "Ockham", "Dev", "aa@wp.pl", Gender.M, "Oc", "UJ", null, c)

    c.director = p1

    p1.hire(p2)
    p1.hire(p3)
    p2.hire(p4)
    p4.hire(p5)
    p1.hire(r1)
    p2.hire(r2)
    p3.hire(r3)
    p4.hire(r4)
    p5.hire(r5)
    p3.hire(r6)


    currentCompany = c
    currentlySelected = null

    employeesListData.add(p1)

    MainController.companiesListModel.addCompany(currentCompany)
  }
  
  def editCompany(company: Company): Unit = {
    currentCompany = company
    currentlySelected = null
    employeesListData.clear()
    employeesListData.addAll((Set(company.director) ++ company.director.allEmployees).asJavaCollection)
  }

  def deleteEmployee(): Unit = {
    currentlySelected match {
      case manager: Manager =>
        if (manager.supervisor != null) manager.supervisor.fire(manager)
        else manager.company = null
        for (employee <- Set(manager) ++ manager.allEmployees) employeesListData.remove(employee)
      case employee: Employee =>
        employee.supervisor.fire(employee)
        employeesListData.remove(employee)
    }
  }

  def returnToList(): Unit = {
    currentCompany = null
    currentlySelected = null
    employeesListData.clear()
  }
}
