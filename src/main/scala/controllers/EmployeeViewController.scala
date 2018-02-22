package controllers

import java.net.URL
import java.util.ResourceBundle
import javafx.beans.value.{ChangeListener, ObservableValue}
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}
import javafx.scene.control._

import data.domain.Gender.Gender
import data.domain.{Employee, Gender, Manager}

class EmployeeViewController extends Initializable {

  private val companyModel = MainController.companyViewModel
  private val employeeModel = MainController.employeeViewModel
  private val emp = MainController.employeeViewModel.currentEmployee

  @FXML private var firstNameField: TextField = _
  @FXML private var lastNameField: TextField = _
  @FXML private var roleField: TextField = _
  @FXML private var emailField: TextField = _
  @FXML private var countryField: TextField = _
  @FXML private var universityField: TextField = _
  @FXML private var genderBox: ChoiceBox[Gender] = _
  @FXML private var supervisorBox: ComboBox[Manager] = _
  @FXML private var employeeTypeBox: ChoiceBox[String] = _
  @FXML private var hiringButton: Button = _
  @FXML private var saveButton: Button = _
  @FXML private var cancelButton:Button = _
  @FXML private var errorText: Label = _

  override def initialize(url: URL, resourceBundle: ResourceBundle): Unit = {

    firstNameField.setText(emp.firstName)
    lastNameField.setText(emp.lastName)
    roleField.setText(emp.role)
    emailField.setText(emp.email.toString)
    countryField.setText(emp.country)
    universityField.setText(emp.university)

    genderBox.getItems.setAll(Gender.M, Gender.W)
    genderBox.getSelectionModel.select(emp.gender)

    if (emp == emp.company.director) {
      supervisorBox.getItems.clear()
      supervisorBox.setDisable(true)

      employeeTypeBox.getItems.addAll("Manager")
      employeeTypeBox.getSelectionModel.select("Manager")
      employeeTypeBox.setDisable(true)
    }
    else {
      supervisorBox.getItems.setAll(employeeModel.managers)
      supervisorBox.setDisable(false)
      supervisorBox.getSelectionModel.select(emp.supervisor)

      employeeTypeBox.getItems.addAll("Developer", "Manager")
      employeeTypeBox.setDisable(false)
      emp match {
        case manager: Manager => employeeTypeBox.getSelectionModel.select("Manager")
        case employee: Employee => employeeTypeBox.getSelectionModel.select("Developer")
      }
    }

    emp match {
      case manager: Manager => hiringButton.setVisible(true)
      case employee: Employee => hiringButton.setVisible(false)
    }

    errorText.setVisible(false)

    val hiringButton_ = hiringButton

    employeeTypeBox.getSelectionModel.selectedItemProperty().addListener(new ChangeListener[String] {
      override def changed(observableValue: ObservableValue[_ <: String], t: String, t1: String): Unit = {
        t1 match {
          case "Manager" => hiringButton_.setVisible(true)
          case _ => hiringButton_.setVisible(false)
        }
      }
    })
  }

  @FXML
  private def saveAction (e: ActionEvent): Unit = {
    val error = employeeModel.save(firstNameField.getText,
      lastNameField.getText(),
      roleField.getText(),
      emailField.getText(),
      universityField.getText(),
      countryField.getText,
      genderBox.getValue,
      employeeTypeBox.getValue,
      supervisorBox.getValue)
    if (error.isEmpty) {
      companyModel.editCompany(companyModel.currentCompany)
      MainController.loadView(MainController.COMPANYVIEW)
    }
    else errorText.setText(error)
  }

  @FXML
  private def cancelAction (e: ActionEvent): Unit = ???

  def setError(msg: String): Unit = {
    errorText.setText(msg)
    errorText.setVisible(true)
  }

}
