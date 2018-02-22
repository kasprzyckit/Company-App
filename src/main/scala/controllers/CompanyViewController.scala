package controllers

import java.net.URL
import java.util.ResourceBundle
import javafx.beans.value.{ChangeListener, ObservableValue}
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}
import javafx.scene.control.{Button, Label, ListView, SelectionMode}
import javafx.scene.layout.Pane

import data.domain.{Employee, Manager}

class CompanyViewController extends Initializable{
  private val listModel = MainController.companiesListModel
  private val companyModel = MainController.companyViewModel
  private val employeeModel = MainController.employeeViewModel

  @FXML private var createButton: Button = _
  @FXML private var editButton: Button = _
  @FXML private var deleteButton: Button = _
  @FXML private var employeeList: ListView[Employee] = _
  @FXML private var infoPane: Pane = _
  @FXML private var supervisorInfo: Pane = _
  @FXML private var managerInfo: Pane = _
  @FXML private var employeeType: Label = _

  @FXML var companyName: Label = _
  @FXML var eName: Label = _
  @FXML var eRole: Label = _
  @FXML var eEmail: Label = _
  @FXML var eCountry: Label = _
  @FXML var eUniversity: Label = _
  @FXML var eSupervisor: Label = _
  @FXML var managerEmployees: Label = _

  override def initialize(url: URL, resourceBundle: ResourceBundle): Unit = {
    employeeList.getSelectionModel.setSelectionMode(SelectionMode.SINGLE)
    employeeList.itemsProperty().bindBidirectional(companyModel.employeesListProperty)

    if (companyModel.employeesListProperty.isEmpty) createButton.setDisable(false)
    else createButton.setDisable(true)

    companyName.setText(companyModel.currentCompany.name)

    val infoPane_ = infoPane
    val editButton_ = editButton
    val deleteButton_ = deleteButton
    val createButton_ = createButton
    val supervisorInfo_ = supervisorInfo
    val managerInfo_ = managerInfo
    val employeeType_ = employeeType
    val eName_ = eName
    val eRole_ = eRole
    val eEmail_ = eEmail
    val eCountry_ = eCountry
    val eUniversity_ = eUniversity
    val eSupervisor_ = eSupervisor
    val managerEmployees_ = managerEmployees

    employeeList.getSelectionModel.selectedItemProperty().addListener(new ChangeListener[Employee] {
      override def changed(observableValue: ObservableValue[_ <: Employee], t: Employee, t1: Employee): Unit = {
        if (t1 != null) {
          infoPane_.setVisible(true)
          editButton_.setDisable(false)
          deleteButton_.setDisable(false)

          companyModel.currentlySelected = t1

          eName_.setText(t1.name)
          eRole_.setText(t1.role)
          eEmail_.setText(t1.email.toString)
          eCountry_.setText(t1.country)
          eUniversity_.setText(t1.university)

          t1 match {
            case manager: Manager =>
              employeeType_.setText("Manager")
              managerEmployees_.setText(manager.employees.size + "/" + manager.hiringLimit)
              managerInfo_.setVisible(true)
              if (manager.canHire) createButton_.setDisable(false)
              else createButton_.setDisable(true)
            case regular: Employee =>
              employeeType_.setText("Developer")
              managerInfo_.setVisible(false)
              createButton_.setDisable(true)
            case _ =>
          }

          if (t1 != companyModel.currentCompany.director)
          {
            eSupervisor_.setText(t1.supervisor.name)
            supervisorInfo_.setDisable(false)
          }
          else
          {
            eSupervisor_.setText("-")
            supervisorInfo_.setDisable(true)
            employeeType_.setText("Director")
          }
        }
        else {
          infoPane_.setVisible(false)
          editButton_.setDisable(true)
          deleteButton_.setDisable(true)
          createButton_.setDisable(false)
        }
      }
    })
  }

  @FXML
  private def returnAction (event: ActionEvent): Unit = {
    companyModel.returnToList()
    MainController.loadView(MainController.COMPANIESLIST)
  }

  @FXML
  private def editAction (event: ActionEvent): Unit = {
    employeeModel.editEmployee(companyModel.currentlySelected)
    MainController.loadView(MainController.EMPLOYEEVIEW)
  }

  @FXML
  private def deleteAction (event: ActionEvent): Unit = {
    companyModel.deleteEmployee()
  }

  @FXML
  private def importAction (event: ActionEvent): Unit = ???

  @FXML
  private def addNewEmployeeAction (event: ActionEvent): Unit = {
    employeeModel.createEmployee()
    MainController.loadView(MainController.EMPLOYEEVIEW)
  }

  @FXML
  private  def editCompanyNameAction (event: ActionEvent): Unit = ???
}
