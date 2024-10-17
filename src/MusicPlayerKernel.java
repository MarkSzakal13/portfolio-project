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

    /**
     * Plays the current track. If the music is already playing, it continues to
     * play. If no track is currently playing, it sets the first track in the
     * playlist as the current track and starts playing.
     *
     * @return true if the song is playing, false otherwise.
     * @updates this
     * @requires playlist.length() > 0
     * @ensures play = (playlist.length() > 0) && currentTrack != null
     */
    boolean play();

    /**
     * Pauses the current track if it is playing. If no track is currently
     * playing, this method does nothing.
     *
     * @return true if the song was successfully paused, false otherwise.
     * @updates this
     * @ensures pause = !#isPlaying
     */
    boolean pause();

    /**
     * Returns the name of the current track.
     *
     * @return The name of the current track, or null if no track is playing.
     * @requires playlist.length() > 0
     * @ensures getTrack = currentTrack
     */
    String getTrack();
}
