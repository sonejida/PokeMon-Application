package basic;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackgroundMusicModel {

    private MediaPlayer mediaPlayer;

    public BackgroundMusicModel() {

        Media media = new Media(getClass().getResource("img/Pokemon.mp3").toExternalForm());

        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void playMusic() {
        mediaPlayer.play();
    }

    public void stopMusic() {
        mediaPlayer.stop();
        mediaPlayer.dispose();
    }
}
