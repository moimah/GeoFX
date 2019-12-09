package app_main;


import controller.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RootApp extends Application {
	
	private RootController controller; 
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new RootController();		
		
		Scene scene = new Scene(controller.getRoot(), 450, 350);				
		
		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(350);
		primaryStage.setMinWidth(450);
		primaryStage.show();
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
