package controllers

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.{Button, Label}
import javafx.scene.layout.{Pane, VBox}
import javax.swing.text.html.ListView

class CompanyViewController {
  private val listModel = MainController.companiesListModel
  private val companyModel = MainController.companyViewModel

  @FXML private val editButton: Button = _
  @FXML private val deleteButton: Button = _
  @FXML private val employeeList: ListView = _
  @FXML private val infoPane: Pane = _
  @FXML private val supervisorInfo: VBox = _
  @FXML private val managerInfo: VBox = _
  @FXML private val employeeType: Label = _

  @FXML val companyName: Label = _
  @FXML val eName: Label = _
  @FXML val eRole: Label = _
  @FXML val eEmail: Label = _
  @FXML val eCountry: Label = _
  @FXML val eUniversity: Label = _
  @FXML val eSupervisor: Label = _
  @FXML val managerEmployees: Label = _



  @FXML
  private def returnAction (event: ActionEvent): Unit = ???

  @FXML
  private def editAction (event: ActionEvent): Unit = ???

  @FXML
  private def deleteAction (event: ActionEvent): Unit = ???

  @FXML
  private def importAction (event: ActionEvent): Unit = ???

  @FXML
  private def addNewEmployeeAction (event: ActionEvent): Unit = ???

  @FXML
  private  def editCompanyNameAction (event: ActionEvent): Unit = ???
}
