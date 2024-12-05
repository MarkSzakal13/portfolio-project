package components.musicplayer;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Class to represent MusicPlayer kernel methods including addSong, removeSong,
 * play, pause, and getTrack.
 */
public class MusicPlayerOnQueue extends MusicPlayerSecondary {

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
    public MusicPlayerOnQueue() {
        this.createNewRep();
    }

    /**
     * Creates new rep of MusicPlayerOnQueue.
     */
    private void createNewRep() {
        this.playlist = new Queue1L<>();
        this.currentTrack = null;
        this.isPlaying = false;
    }

    /**
     * Creates a new instance of MusicPlayerOnQueue.
     */
    @Override
    public MusicPlayerOnQueue newInstance() {
        return new MusicPlayerOnQueue();
    }

    /**
     * Clears MusicPlayerOnQueue.
     */
    @Override
    public void clear() {
        this.createNewRep();
    }

    /**
     * Transfers MusicPlayerOnQueues instance to the current state.
     */
    @Override
    public void transferFrom(MusicPlayer source) {
        MusicPlayerOnQueue localSource = (MusicPlayerOnQueue) source;
        this.playlist = localSource.playlist;
        this.currentTrack = localSource.currentTrack;
        this.isPlaying = localSource.isPlaying;
        localSource.createNewRep();
    }

    /**
     * Adds a song to the playlist.
     *
     * @param song
     *            The song being added.
     */
    @Override
    public void addSong(String song) {
        this.playlist.enqueue(song);
        if (this.currentTrack == null) {
            this.currentTrack = song;
        }
    }

    /**
     * Removes song from the playlist.
     *
     * @param song
     *            The song being removed.
     */
    @Override
    public void removeSong(String song) {
        Queue<String> temp = new Queue1L<>();
        boolean found = false;

        while (this.playlist.length() > 0) {
            String currentSong = this.playlist.dequeue();

            if (!found && currentSong.equals(song)) {
                found = true;
            } else {
                temp.enqueue(currentSong);
            }
        }

        this.playlist = temp;

        if (this.currentTrack != null && this.currentTrack.equals(song)) {
            if (this.playlist.length() != 0) {
                this.currentTrack = null;
            }
            this.currentTrack = this.playlist.front();
        }
    }

    /**
     * Plays the current song.
     *
     * @return isPlaying as true if the song starts playing.
     */
    @Override
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
    @Override
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
    @Override
    public String getTrack() {
        return this.currentTrack;
    }

    /**
     * Gets the length of the playlist.
     *
     * @return Returns the playlist length.
     */
    @Override
    public int getPlaylistLength() {
        return this.playlist.length();
    }
}
