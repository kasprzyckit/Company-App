import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage

import controllers.MainController

class CompanyApp extends Application
{
  override def start(primaryStage: Stage): Unit =
  {
    primaryStage setTitle "MainView"

    primaryStage setScene createScene(loadMainPane)

    MainController.primaryStage = primaryStage

    primaryStage.show()
  }

  private def createScene(mainPane: Pane): Scene = {
    val scene: Scene = new Scene(mainPane)
    //TODO CSS
    scene
  }

  private def loadMainPane: Pane = {

    val loader: FXMLLoader = new FXMLLoader

    val mainPane: Pane = loader.load(getClass.getResourceAsStream(MainController.MAINSCENE))

    val mainController: MainController = loader.getController.asInstanceOf[MainController]
    MainController.mainController = mainController

    MainController.loadView(MainController.COMPANIESLIST)

    mainPane
  }

}

object CompanyApp {
  def main(args: Array[String]): Unit = {

    Application.launch(classOf[CompanyApp], args: _*)
    }
}