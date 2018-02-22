package data

import javafx.beans.property.SimpleListProperty
import javafx.collections.{FXCollections, ObservableList}

import data.domain.{Company, Gender, TeamManager}

class CompaniesListModel {

  private var companiesListData: ObservableList[Company] = FXCollections.observableArrayList[Company]
  val companiesListProperty: SimpleListProperty[Company] = new SimpleListProperty[Company](companiesListData)

  def addCompany(company: Company): Unit = companiesListData.add(company)

  def deleteCompany(): Unit = companiesListData.remove(currentlySelected)

  companiesListData.add(new Company("Test Company", new TeamManager("Harold", "Ockham", "CEO", "aa@wp.pl", Gender.M, "Oc", "UJ", null, null, 6)))
  companiesListData.add(new Company("Coodod", new TeamManager("All", "Ber", "CEO", "sadsa@wp.pl", Gender.W, "Oc", "UJ", null, null, 6)))

  var currentlySelected: Company = _

  def numberOfCompanies: Int = companiesListData.size()

}