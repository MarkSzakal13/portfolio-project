package components.musicplayer;

/**
 * Music Player Interface.
 */
public interface MusicPlayer extends MusicPlayerKernel {

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
