package Processors;

import Entities.Controllers;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class Player {

    /**
     * Plays the video file in the GUI pane
     * @param videoFile The file to be played
     * @return True if success, False otherwise
     */
    public static boolean playVideo(File videoFile)
    {
        try {
            String uri = videoFile.toURI().toString();
            Media media = new Media(uri);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            Controllers.getMainController().videoPane.getChildren().add(mediaView);
            mediaView.fitHeightProperty().bind(Controllers.getMainController().videoPane.heightProperty());
            mediaView.fitWidthProperty().bind(Controllers.getMainController().videoPane.widthProperty());
            mediaPlayer.play();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
