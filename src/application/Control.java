package application;

import java.io.IOException;



import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Alejandro Baro
 * @version 0.1
 * @see Control.java
 *
 */
public class Control {

	@FXML
	ImageView logoLabel;

	@FXML
	GridPane spnCargando;

	@FXML
	AnchorPane rootPane;

	@FXML
	Label cargandoLabel;

	public void Home() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("ven2.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Menu Principal");
			Scene scene = new Scene(page);
			homeStage.setScene(scene);
			homeStage.setMaximized(false);
			homeStage.show();
			System.out.println("etapa 2 OK.");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Etapa 2 KO.");
		}
	}

	public void initialize() {
		TranslateTransition translate = new TranslateTransition(Duration.seconds(0.1), logoLabel);
		translate.setByY(700);
		translate.play();

		TranslateTransition translate0 = new TranslateTransition(Duration.seconds(0.1), cargandoLabel);
		translate.setByY(700);
		translate.play();

		TranslateTransition translate00 = new TranslateTransition(Duration.seconds(0.1), spnCargando);
		translate.setByY(700);
		translate.play();

		translate.setOnFinished(event -> {

			TranslateTransition translate1 = new TranslateTransition(Duration.seconds(1), logoLabel);
			translate1.setByY(-700);

			translate1.play();

			translate1.setOnFinished(event1 -> {

				cargandoLabel.setVisible(true);
				TranslateTransition translate11 = new TranslateTransition(Duration.seconds(1), cargandoLabel);
				translate11.setByY(0);
				translate11.play();

				translate11.setOnFinished(event2 -> {

					spnCargando.setVisible(true);
					TranslateTransition translate111 = new TranslateTransition(Duration.seconds(1),
							spnCargando);
					translate111.setByY(0);
					translate111.play();

					FadeTransition fade0 = new FadeTransition(Duration.seconds(3), spnCargando);
					fade0.setFromValue(0);
					fade0.setToValue(1);
					fade0.play();

					fade0.setOnFinished(event4 -> {

						FadeTransition fade1 = new FadeTransition(Duration.seconds(2), rootPane);
						fade1.setFromValue(1);
						fade1.setToValue(0.1);
						fade1.play();

						fade1.setOnFinished(event5 -> {
							// main.closeStage();
							Stage thisStage = (Stage) rootPane.getScene().getWindow();
							thisStage.close();
							Home();
							System.out.println("------- splash screen se esta cerrando.. --------");
						});
					});
				});
			});
		});

	}

}
