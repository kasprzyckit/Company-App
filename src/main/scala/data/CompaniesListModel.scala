package data

import javafx.beans.property.SimpleListProperty
import javafx.collections.{FXCollections, ObservableList}

import data.domain.{Company, Gender, TeamManager}

class CompaniesListModel {

  private var companiesListData: ObservableList[Company] = FXCollections.observableArrayList[Company]
  val companiesListProperty: SimpleListProperty[Company] = new SimpleListProperty[Company](companiesListData)

  def addCompany(company: Company): Unit = companiesListData.add(company)

  def deleteCompany(): Unit = companiesListData.remove(currentlySelected)

  var currentlySelected: Company = _

  def numberOfCompanies: Int = companiesListData.size()

}