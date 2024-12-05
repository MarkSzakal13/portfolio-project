import components.musicplayer.MusicPlayerOnQueue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A basic music player that allows the user to interact with a playlist by
 * adding songs, skipping the current track, viewing the playlist, or quitting
 * the program.
 */
public final class BasicMusicPlayer {

    /**
     * Private constructor to prevent instantiation.
     */
    private BasicMusicPlayer() {
    }

    /**
     * Main method to run the program.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        MusicPlayerOnQueue player = new MusicPlayerOnQueue();
        boolean running = true;

        while (running) {
            out.println("1: Add a song");
            out.println("2: Skip current track");
            out.println("3: View playlist");
            out.println("4: Quit");
            out.print("Choose an option: ");
            int choice = in.nextInteger();
            out.println();

            if (choice == 1) {
                out.print("Enter a song: ");
                in.nextLine();
                String song = in.nextLine();
                player.addSong(song);
                out.println("Added: " + song + " to your playlist!");
            } else if (choice == 2) {
                String currentTrack = player.getTrack();
                if (currentTrack != null) {
                    out.println("Now playing: " + currentTrack);
                    player.skip();
                } else {
                    out.println("Your player is empty!");
                }
            } else if (choice == 3) {
                if (player.getPlaylistLength() > 0) {
                    out.println("Playlist:");
                    int length = player.getPlaylistLength();
                    for (int i = 0; i < length; i++) {
                        String track = player.getTrack();
                        out.println("- " + track);
                        player.skip();
                        player.addSong(track);
                    }
                } else {
                    out.println("Your playlist is empty!");
                }
            } else if (choice == 4) {
                running = false;
                out.println("Goodbye!");
            } else {
                out.println("Please choose a valid option.");
            }
            out.println();
        }

        in.close();
        out.close();
    }
}
