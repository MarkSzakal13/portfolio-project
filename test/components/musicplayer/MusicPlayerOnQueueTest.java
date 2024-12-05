package components.musicplayer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for MusicPlayerOnQueue.
 */
public class MusicPlayerOnQueueTest {

    /**
     * Tests addSong method.
     */
    @Test
    public void addSongTest() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        assertEquals(1, player.getPlaylistLength());
        assertEquals("Heartless", player.getTrack());
    }

    /**
     * Tests removeSong method.
     */
    @Test
    public void removeSongTest() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        player.addSong("Flashing Lights");
        player.removeSong("Heartless");
        assertEquals(1, player.getPlaylistLength());
        assertEquals("Flashing Lights", player.getTrack());
    }

    /**
     * Tests play method.
     */
    @Test
    public void playTest() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        assertEquals(true, player.play());
    }

    /**
     * Tests pause method.
     */
    @Test
    public void pauseTest() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        player.play();
        assertEquals(false, player.pause());
    }

    /**
     * Tests getTrack method.
     */
    @Test
    public void getTrackTest() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        assertEquals("Heartless", player.getTrack());
    }

    /**
     * Tests getPlaylistLength method.
     */
    @Test
    public void getPlaylistLengthTest() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        assertEquals(0, player.getPlaylistLength());
        player.addSong("Heartless");
        assertEquals(1, player.getPlaylistLength());
    }

    /**
     * Tests clear method.
     */
    @Test
    public void clearTest() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        player.clear();
        assertEquals(0, player.getPlaylistLength());
    }

    /**
     * Tests transferFrom method.
     */
    @Test
    public void transferFromTest() {
        MusicPlayerOnQueue player1 = new MusicPlayerOnQueue();
        player1.addSong("Heartless");
        player1.addSong("Flashing Lights");

        MusicPlayerOnQueue player2 = new MusicPlayerOnQueue();
        player2.addSong("Good Morning");
        player1.transferFrom(player2);

        assertEquals(1, player1.getPlaylistLength());
        assertEquals("Good Morning", player1.getTrack());
        assertEquals(0, player2.getPlaylistLength());
    }
}
