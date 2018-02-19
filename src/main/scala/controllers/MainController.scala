package controllers

import java.io.{File, IOException}
import java.net.URL
import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.Node
import javafx.scene.layout.StackPane

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

  var mainController: MainController = _

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