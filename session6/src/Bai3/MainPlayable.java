package Bai3;

public class MainPlayable {
    public static void main(String[] args) {
        AudioPlayer musicPlayer = new AudioPlayer();
        VideoPlayer videoPlayer = new VideoPlayer();

        Playable[] playables = {musicPlayer, videoPlayer};

        for (Playable playable : playables) {
            playable.play();
        }
    }
}
