package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root); //sahne oluşturuyor
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene); // bu kısma kadar sahne tasarımı yapılır.
			primaryStage.show(); // sahne gösterilir.
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		launch(args); // gelen argümanlara göre start fonksiyonunu tetikler.
	}
}
