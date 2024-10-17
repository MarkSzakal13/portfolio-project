/**
 * Music Player Interface.
 */
public interface MusicPlayerInterface extends MusicPlayerKernel {
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
    @Override
    boolean play();

    /**
     * Pauses the current track if it is playing. If no track is currently
     * playing, this method does nothing.
     *
     * @return true if the song was successfully paused, false otherwise.
     * @updates this
     * @ensures pause = !#isPlaying
     */
    @Override
    boolean pause();

    /**
     * Returns the name of the current track.
     *
     * @return The name of the current track, or null if no track is playing.
     * @requires playlist.length() > 0
     * @ensures getTrack = currentTrack
     */
    @Override
    String getTrack();
}
