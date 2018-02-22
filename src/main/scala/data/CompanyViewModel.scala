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
    currentCompany = new Company("NewCompany" + MainController.companiesListModel.numberOfCompanies, null)
    currentlySelected = null

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
