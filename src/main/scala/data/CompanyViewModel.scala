package data

import javafx.beans.property.SimpleListProperty
import javafx.collections.{FXCollections, ObservableList}

import controllers.MainController
import data.domain.{AbstractEmployee, Company}

class CompanyViewModel {

  var currentCompany: Company = _

  var currentlySelected: AbstractEmployee = _

  private var employeesListData: ObservableList[AbstractEmployee] = _
  val employeesListProperty: SimpleListProperty[AbstractEmployee] = new SimpleListProperty[AbstractEmployee](employeesListData)

  def createNewCompany(): Unit = {
    currentCompany = new Company("NewCompany" + MainController.companiesListModel.numberOfCompanies, null)
    currentlySelected = _
    employeesListData = FXCollections.observableArrayList[AbstractEmployee]
  }
}
