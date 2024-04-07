package basic;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PokemonController {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private void handleButton1Action() {
        openFXML("Arceus.fxml");
    }

    @FXML
    private void handleButton2Action() {
        openFXML("Pikachu.fxml");
    }

    private void openFXML(String fxmlResource) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlResource));

        try {
            Parent root = fxmlLoader.load();

            // Set text from file
            Text text1 = (Text) root.lookup("#text1");
            if (text1 != null) {
                text1.setText(readTextFromFile("text1.txt"));
            }

            Text text2 = (Text) root.lookup("#text2");
            if (text2 != null) {
                text2.setText(readTextFromFile("text2.txt"));
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readTextFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (InputStream inputStream = getClass().getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
