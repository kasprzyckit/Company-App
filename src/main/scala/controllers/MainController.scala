package controllers

import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.Node
import javafx.scene.layout.StackPane
import javafx.stage.Stage

import data.{CompaniesListModel, CompanyViewModel}

class MainController {

  @FXML
  private var viewHolder: StackPane = _

  def setView (view: Node): Unit = viewHolder.getChildren.setAll(view)

}

object MainController {

  val MAINSCENE: String = "fxml/main.fxml"
  val COMPANIESLIST: String = "fxml/companiesList.fxml"
  val COMPANYVIEW: String = "fxml/companyView.fxml"
  val EMPLOYEEVIEW: String = "fxml/employeeView.fxml"
  val HIRINGPREDICATE: String = "fxml/hiringPredicate.fxml"

  val companiesListModel: CompaniesListModel = new CompaniesListModel
  val companyViewModel: CompanyViewModel = new CompanyViewModel

  var mainController: MainController = _

  var primaryStage: Stage = _

  def loadView (view: String): Unit = {
    try {
      mainController.setView(
        FXMLLoader.load(MainController.getClass.getClassLoader.getResource(view))
      )
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}