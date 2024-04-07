package basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private BackgroundMusicModel musicModel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        musicModel = new BackgroundMusicModel();
        musicModel.playMusic();

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pokemon Application");
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxWidth(600);
        primaryStage.setMaxHeight(400);

        primaryStage.setOnCloseRequest(event -> {
            if (musicModel != null) {
                musicModel.stopMusic();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
