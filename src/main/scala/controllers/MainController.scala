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

  val mainScene: String = "fxml/main.fxml"
  val companiesList: String = "src/main/resources/fxml/companiesList.fxml"

  var mainController: MainController = _

  def loadView (view: String): Unit = {
    try {
      mainController.setView(
        FXMLLoader.load(new File(companiesList).toURI.toURL)
      )
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}