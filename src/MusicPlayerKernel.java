import components.standard.Standard;

/**
 * Kernel interface for a music player.
 */
public interface MusicPlayerKernel extends Standard<musicPlayer> {

    /**
     * Adds a song to the playlist.
     *
     * @param song
     *            The name of the song being added.
     * @updates this
     * @requires song != null
     * @ensures playlist = #playlist * {song}
     */
    void addSong(String song);

    /**
     * Removes a song from the playlist.
     *
     * @param song
     *            The name of the song being removed.
     * @updates this
     * @requires playlist.length() > 0 && song != null
     * @ensures playlist = #playlist - {song}
     */
    void removeSong(String song);
}
