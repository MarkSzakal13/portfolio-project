package components.musicplayer;

import components.standard.Standard;

/**
 * Kernel interface for a music player.
 */
public interface MusicPlayerKernel extends Standard<MusicPlayer> {

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
     * Returns the current track.
     *
     * @return the playlists length
     * @requires playlist.length() > 0
     * @ensures getPlaylistLength = number of tracks in the playlist
     */
    int getPlaylistLength();
}
