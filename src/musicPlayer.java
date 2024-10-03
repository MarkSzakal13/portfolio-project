import components.queue.Queue;
import components.queue.Queue1L;

/** */
public class musicPlayer {
    /** */

    private Queue<String> playlist;

    /** */
    public musicPlayer() {
        this.playlist = new Queue1L<>();
    }

    /** */
    public void queue(String song) {
        this.playlist.enqueue(song);
    }

    public void remove(String song) {
        Queue<String> temp = new Queue1L<>();

        while (this.playlist.length() > 0) {
            String currentSong = this.playlist.dequeue();

            if (!currentSong.equals(song)) {
                temp.enqueue(currentSong);
            }
            this.playlist = temp;
        }
    }

    /** */
    public static void main(String[] args) {
        String song = null;
    }
}