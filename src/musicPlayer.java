import components.queue.Queue;
import components.queue.Queue1L;

/** */
public class proofOfConcept {
    /** */

    private Queue<String> playlist;

    /** */
    public proofOfConcept() {
        this.playlist = new Queue1L<>();
    }

    /** */
    public void queue(String song) {
        this.playlist.add(song);
    }

    public void dequeue(String song) {
        this.playlist.remove(song);
    }

    /** */
    public static void main(String[] args) {
        ArrayList<String> song = new ArrayList<>();
    }
}
