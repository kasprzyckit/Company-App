package data

import javafx.beans.property.{Property, SimpleListProperty, SimpleObjectProperty}
import javafx.collections.{FXCollections, ObservableList}

import data.domain.{Company, Gender, TeamManager}

class CompaniesListModel {

  private var companiesListData: ObservableList[Company] = FXCollections.observableArrayList[Company]
  val companiesListProperty: SimpleListProperty[Company] = new SimpleListProperty[Company](companiesListData)


  companiesListData.add(new Company("Test Company", new TeamManager("Harold", "Ockham", "CEO", "aa@wp.pl", Gender.M, "Oc", "UJ", 6)))
  companiesListData.add(new Company("Coodod", new TeamManager("All", "Ber", "CEO", "sadsa@wp.pl", Gender.W, "Oc", "UJ", 6)))

  var currentlySelected: Company = _

  def numberOfCompanies: Int = companiesListData.size()

}