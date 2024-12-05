import components.musicplayer.MusicPlayerOnQueue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * An advanced music player that allows the user to interact with a playlist by
 * adding songs, removing songs, pausing, playing, skipping tracks, shuffling,
 * adjusting song order, viewing the playlist, or quitting the program.
 */
public final class AdvancedMusicPlayer {

    /**
     * Private constructor to prevent instantiation.
     */
    private AdvancedMusicPlayer() {
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
            // Display menu
            out.println("1: Add a song");
            out.println("2: Remove a song");
            out.println("3: Pause");
            out.println("4: Play");
            out.println("5: Skip current track");
            out.println("6: Shuffle playlist");
            out.println("7: Adjust song order");
            out.println("8: View playlist");
            out.println("9: Quit");
            out.print("Choose an option: ");
            int choice = in.nextInteger();
            out.println();

            switch (choice) {
                case 1: {
                    out.print("Enter a song: ");
                    in.nextLine();
                    String song = in.nextLine();
                    player.addSong(song);
                    out.println("Added: " + song + " to your playlist!");
                    break;
                }
                case 2: {
                    out.print("Enter a song to remove: ");
                    in.nextLine();
                    String songToRemove = in.nextLine();
                    player.removeSong(songToRemove);
                    out.println("Removed: " + songToRemove
                            + " from your playlist!");
                    break;
                }
                case 3: {
                    if (!player.pause()) {
                        out.println("Player paused.");
                    } else {
                        out.println("No song playing.");
                    }
                    break;
                }
                case 4: {
                    if (player.play()) {
                        out.println("Now playing: " + player.getTrack());
                    } else {
                        out.println("No songs in player.");
                    }
                    break;
                }
                case 5: {
                    String currentTrack = player.getTrack();
                    player.skip();
                    if (currentTrack != null) {
                        out.println("Skipped: " + currentTrack);
                    } else {
                        out.println("No songs to skip.");
                    }
                    break;
                }
                case 6: {
                    player.shuffle();
                    out.println("Playlist shuffled!");
                    break;
                }
                case 7: {
                    out.print("Enter the song to move: ");
                    in.nextLine();
                    String songToMove = in.nextLine();
                    out.print("Enter the new position: ");
                    int newPosition = in.nextInteger();
                    player.adjustOrder(songToMove, newPosition);
                    out.println("Moved " + songToMove + " to position "
                            + newPosition + ".");
                    break;
                }
                case 8: {
                    out.println("Playlist:");
                    int length = player.getPlaylistLength();
                    if (length == 0) {
                        out.println("Your playlist is empty!");
                    } else {
                        for (int i = 0; i < length; i++) {
                            String track = player.getTrack();
                            out.println("- " + track);
                            player.skip();
                            player.addSong(track);
                        }
                    }
                    break;
                }
                case 9: {
                    running = false;
                    out.println("Goodbye!");
                    break;
                }
                default: {
                    out.println("Please choose a valid option.");
                    break;
                }
            }
            out.println();
        }
        in.close();
        out.close();
    }
}