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

    /**
     * Skips current track.
     *
     * @updates this
     * @requires song != null
     * @ensures playlist = #playlist - {song}
     */
    void skip();

    /**
     * Songs shuffled in random order.
     *
     * @updates this
     * @requires playlist.length > 0
     * @ensures |playlist| = |#playlist|
     */
    void shuffle();

    /**
     * Song is moved to index in order.
     *
     * @param song
     *            The song being moved.
     * @param index
     *            Location to where the song is being moved.
     * @updates this
     * @requires playlist.length() > 1 && song != null
     * @ensures playlist.contains(song) && playlist.indexOf(song) == index
     */
    void adjustOrder(String song, int index);
}
