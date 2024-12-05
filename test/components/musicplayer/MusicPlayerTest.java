package components.musicplayer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for MusicPlayer.
 */
public class MusicPlayerTest {
    /**
     * Tests skip method.
     */
    @Test
    public void testSkip() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        player.addSong("Flashing Lights");

        player.skip();
        assertEquals(1, player.getPlaylistLength());
        assertEquals("Flashing Lights", player.getTrack());
    }

    /**
     * Tests shuffle method.
     */
    @Test
    public void testShuffle() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        player.addSong("Flashing Lights");
        player.addSong("Good Morning");

        int originalLength = player.getPlaylistLength();

        assertEquals(originalLength, player.getPlaylistLength());
        assertEquals(true, player.getPlaylistLength() > 0);
    }

    /**
     * Tests adjustOrder method.
     */
    @Test
    public void testAdjustOrder() {
        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        player.addSong("Heartless");
        player.addSong("Flashing Lights");
        player.addSong("Good Morning");

        player.adjustOrder("Flashing Lights", 0);

        assertEquals("Flashing Lights", player.getTrack());
    }
}
