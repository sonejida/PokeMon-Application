package basic;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button clickButton;

    private boolean buttonClicked = false;

    @FXML
    private void initialize() {
        clickButton.setOnAction(event -> {
            if (!buttonClicked) {
                clickButton.setText("Button Clicked!");
                buttonClicked = true;

                openNewPage();
            }
        });
    }

    private void openNewPage() {
        Alert.AlertType alertType = Alert.AlertType.INFORMATION;
        String alertContentText = "Thank you for confirming, please click exit to close all the windows.";

        Alert chooseAlert = new Alert(Alert.AlertType.CONFIRMATION);
        chooseAlert.setTitle("User Confirmation Box");
        chooseAlert.setContentText("Do you want to continue?");

        ButtonType yesButtonType = new ButtonType("yes");
        ButtonType noButtonType = new ButtonType("no");

        chooseAlert.getButtonTypes().setAll(yesButtonType, noButtonType);

        chooseAlert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == yesButtonType) {

                try {
                    // Load the new page FXML
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("PokemonList.fxml"));
                    AnchorPane newPageRoot = loader.load();

                    // Create a new stage for the new page
                    Stage newStage = new Stage();
                    newStage.setTitle("List of most famous Pokemon");

                    // Set the new scene with the new page content
                    Scene newScene = new Scene(newPageRoot, 600, 400);
                    newStage.setScene(newScene);

                    // Show the new stage
                    newStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (buttonType == noButtonType) {

                Alert alert = new Alert(alertType);
                alert.setTitle("Exit All Windows");
                alert.setContentText(alertContentText);
                ButtonType exitButton = new ButtonType("exit");
                alert.getButtonTypes().set(0, exitButton);

                alert.showAndWait().ifPresent(click -> {
                    if (click == exitButton) {
                        Platform.exit();
                    }
                });

            }

        });

    }
}
