import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Class to represent MusicPlayer kernel methods including addSong, removeSong,
 * play, pause, and getTrack.
 */
public class MusicPlayer {

    /**
     * Initializes empty playlist.
     */
    private Queue<String> playlist;
    /**
     * Initializes empty currentTrack.
     */
    private String currentTrack;
    /**
     * Initializes isPlaying as paused.
     */
    private boolean isPlaying;

    /**
     * Constructs an empty playlist, sets currentTrack to null, and starts
     * isPlaying as paused.
     */
    public MusicPlayer() {
        this.playlist = new Queue1L<>();
        this.currentTrack = null;
        this.isPlaying = false;
    }

    /**
     * Adds a song to the playlist.
     *
     * @param song
     *            The song being added.
     */
    public void addSong(String song) {
        this.playlist.enqueue(song);
    }

    /**
     * Removes song from the playlist.
     *
     * @param song
     *            The song being removed.
     */
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

    /**
     * Plays the current song.
     *
     * @return isPlaying as true if the song starts playing.
     */
    public boolean play() {
        boolean isPlaying = false;
        if (this.playlist.length() > 0) {
            isPlaying = true;
        }
        return isPlaying;
    }

    /**
     * Pauses the current song.
     *
     * @return isPlaying as false if the song stops playing.
     */
    public boolean pause() {
        if (this.isPlaying) {
            this.isPlaying = false;
        }
        return this.isPlaying;
    }

    /**
     * Gets the current track.
     *
     * @return Returns the current track.
     */
    public String getTrack() {
        return this.currentTrack;
    }

    /**
     * Gets the length of the playlist.
     *
     * @return Returns the playlist length.
     */
    public int getPlaylistLength() {
        return this.playlist.length();
    }

    /**
     * Main methods for MusicPlayer.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        MusicPlayer player1 = new MusicPlayer();
        player1.addSong("Heartless");
        player1.removeSong("Father Stretch My Hands Pt. 1");
        player1.getTrack();
        player1.play();
        player1.pause();
        player1.removeSong("Heartless");
        player1.play();
    }
}
