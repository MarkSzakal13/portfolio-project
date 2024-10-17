/**
 * Music Player Interface.
 */
public interface MusicPlayerInterface extends MusicPlayerKernel {
    /**
     * Plays the current track.
     *
     * @return whether or not the song is playing
     * @updates this
     * @requires playlist.length() > 0
     * @ensures currentTrack != null
     */
    boolean play();

    /**
     * Pauses the current track.
     *
     * @return whether or not the song is paused
     * @updates this
     * @requires playlist.length() > 0
     * @ensures currentTrack != null
     */
    boolean pause();

    /**
     * Returns the current track.
     *
     * @return the current track
     * @requires playlist.length() > 0
     * @ensures getTrack = currentTrack
     */
    String getTrack();
}
