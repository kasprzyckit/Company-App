package controllers

import java.net.URL
import java.util.ResourceBundle
import javafx.beans.value.{ChangeListener, ObservableValue}
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}
import javafx.scene.control.{Button, Label, ListView, SelectionMode}
import javafx.scene.layout.BorderPane

import data.domain.Company

class CompaniesListController extends Initializable{
  
  private val listModel = MainController.companiesListModel
  private val companyModel = MainController.companyViewModel

  @FXML
  private var companiesList: ListView[Company] = _
  @FXML
  private var editButton: Button = _
  @FXML
  private var deleteButton: Button = _
  @FXML
  private var infoPane: BorderPane = _
  @FXML
  private var companyNameLabel: Label = _
  @FXML
  private var directorNameLabel: Label = _
  @FXML
  private var employeeNumberLabel: Label = _

  override def initialize(url: URL, resourceBundle: ResourceBundle): Unit = {

    companiesList.getSelectionModel.setSelectionMode(SelectionMode.SINGLE)
    companiesList.itemsProperty.bindBidirectional(listModel.companiesListProperty)

    val infoPane_ = infoPane
    val companyNameLabel_ = companyNameLabel
    val directorNameLabel_ = directorNameLabel
    val employeeNumberLabel_ = employeeNumberLabel
    val editButton_ = editButton
    val deleteButton_ = deleteButton

    companiesList.getSelectionModel.selectedItemProperty().addListener(new ChangeListener[Company] {
      override def changed(observableValue: ObservableValue[_ <: Company], t: Company, t1: Company): Unit = {

        if (t1 != null) {
          infoPane_.setVisible(true)
          editButton_.setDisable(false)
          deleteButton_.setDisable(false)

          listModel.currentlySelected = t1

          companyNameLabel_.setText(t1.name)
          directorNameLabel_.setText(t1.director.name)
          employeeNumberLabel_.setText("Number of employees: " + (t1.director.totalNumberOfEmployees + 1))
        }
        else {
          infoPane_.setVisible(false)
          editButton_.setDisable(true)
          deleteButton_.setDisable(true)
        }
      }
    })
  }

  @FXML
  private def quitButtonAction(event: ActionEvent): Unit = {
    MainController.primaryStage.hide()
  }

  @FXML
  private def createCompanyAction(event: ActionEvent): Unit = {
    companyModel.createNewCompany()
    MainController.loadView(MainController.COMPANYVIEW)
  }

  @FXML
  private def editAction(event: ActionEvent): Unit = ???

  @FXML
  private def deleteAction(event: ActionEvent): Unit = ???

}