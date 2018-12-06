package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Alejandro Baro
 *	@version 0.1
 *	@see Main.java
 *	@
 */


public class Main extends Application {
	Stage stage;

	@Override
	public void start(Stage primeraPantalla) throws Exception {
		
		stage = primeraPantalla;
		
		MainPrincipal();
	}
	
	
	private void MainPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("carga1.fxml"));
			AnchorPane pane = loader.load();

			Scene scene = new Scene(pane);

			// añadiendo las fuetnes:
			Font.loadFont(getClass().getResourceAsStream("fuente/IndieFlower.ttf"), 20);

			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
	public void cerrarStage() {
		stage.close();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

	

}
