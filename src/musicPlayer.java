import components.queue.Queue;
import components.queue.Queue1L;

public class musicPlayer {

    private Queue<String> playlist;
    private String currentTrack;
    private boolean isPlaying;

    public musicPlayer() {
        this.playlist = new Queue1L<>();
        this.currentTrack = null;
        this.isPlaying = false;
    }

    public void addSong(String song) {
        this.playlist.enqueue(song);
    }

    public void removeSong(String song) {
        Queue<String> temp = new Queue1L<>();

        while (this.playlist.length() > 0) {
            String currentSong = this.playlist.dequeue();

            if (!currentSong.equals(song)) {
                temp.enqueue(currentSong);
            }
            this.playlist = temp;
        }
    }

    public boolean play() {
        boolean isPlaying = false;
        if (this.playlist.length() > 0) {
            isPlaying = true;
        }
        return isPlaying;
    }

    public boolean pause() {
        if (this.isPlaying) {
            this.isPlaying = false;
        }
        return this.isPlaying;
    }

    public String getTrack() {
        return this.currentTrack;
    }

    /** */
    public static void main(String[] args) {
        musicPlayer player1 = new musicPlayer();
        String song = null;
        player1.addSong("Heartless");
        player1.removeSong("Father Stretch My Hands Pt. 1");
        player1.getTrack();
        player1.play();
        player1.pause();
        player1.removeSong("Heartless");
        player1.play();
    }
}