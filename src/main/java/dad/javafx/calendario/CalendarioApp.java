package dad.javafx.calendario;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalendarioApp extends Application {

	private CalendarioController controller = new CalendarioController();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene verScene = new Scene(controller.getRoot());
		primaryStage.setTitle("Calendario");
		primaryStage.getIcons().add(new Image(getClass().getResource("/Images/calendar-64x64.png").toString()));
		primaryStage.setScene(verScene);
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}

}
