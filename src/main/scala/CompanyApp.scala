import javafx.application.Application
import javafx.event.ActionEvent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.{Font, Text}
import javafx.stage.Stage

object CompanyApp {
  def main(args: Array[String]): Unit = {

    Application.launch(classOf[CompanyApp], args: _*)
  }
}

class CompanyApp extends Application
{
  override def start(primaryStage: Stage): Unit =
  {
    primaryStage.setTitle("Hello World!")

    val root1 = new VBox
    val root2 = new VBox

    val scene1 = new Scene(root1, 300, 250)
    val scene2 = new Scene(root2, 200, 300)

    val text1 = new Text("Test")
    text1.setFont(new Font(15))
    text1.setFill(Color.CHOCOLATE)

    val btn11 = new Button
    val p = "asdasdsad"
    btn11.setText(p)
    btn11.setOnAction((e: ActionEvent) => {
      text1.setFill(Color.BLUE)
    })

    val btn12 = new Button
    btn12.setText("Change the root node'")
    btn12.setOnAction((e: ActionEvent) => {
      primaryStage.setScene(scene2)
    })

    root1.getChildren.addAll(text1, btn11, btn12)

    val text2 = new Text("Test")
    text2.setFont(new Font(15))
    text2.setFill(Color.GOLD)

    val btn21 = new Button
    btn21.setText("Change the color'")
    btn21.setOnAction((e: ActionEvent) => {
      text2.setFill(Color.LAWNGREEN)
    })

    val btn22 = new Button
    btn22.setText("Change the root node'")
    btn22.setOnAction((e: ActionEvent) => {
      primaryStage.setScene(scene1)
    })

    root2.getChildren.addAll(text2, btn21, btn22)

    primaryStage.setScene(scene1)
    primaryStage show
  }
}
