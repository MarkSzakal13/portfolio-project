import java.util.Iterator;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Abstract class to implement MusicPlayer. Includes methods such as skip,
 * shuffle, adjustOrder, equals, and toString.
 */
public abstract class MusicPlayerSecondary implements MusicPlayerInterface {

    /**
     * Initializes playlist.
     */
    private Queue<String> playlist;
    /**
     * Initializes currentTrack.
     */
    private String currentTrack;
    /**
     * Initializes isPlaying.
     */
    private boolean isPlaying;

    /**
     * Constructs a new music player with empty playlist and track and isPaused.
     */
    public MusicPlayerSecondary() {
        this.playlist = new Queue1L<>();
        this.currentTrack = null;
        this.isPlaying = false;
    }

    /**
     * Skips current song and set the next song as current.
     */
    @Override
    public void skip() {
        if (this.playlist.length() > 1) {
            this.playlist.dequeue();
            this.currentTrack = this.playlist.front();
        } else {
            this.playlist.dequeue();
            this.currentTrack = null;
        }

    }

    /**
     * Randomly shuffles the order of songs in the playlist.
     */
    @Override
    public void shuffle() {
        if (this.playlist.length() > 1) {
            String[] sortingArray = new String[this.playlist.length()];

            int shuffleIndex = 0;
            while (this.playlist.length() > 0) {
                sortingArray[shuffleIndex] = this.playlist.dequeue();
                shuffleIndex++;
            }

            for (int i = 0; i < sortingArray.length; i++) {
                int randomIndex = (int) (Math.random() * sortingArray.length);

                String tempString = sortingArray[i];
                sortingArray[i] = sortingArray[randomIndex];
                sortingArray[randomIndex] = tempString;
            }
        }
    }

    /**
     * Adjusts the order of the playlist based on the index inputted by the
     * user.
     *
     * @param song
     *            The song being moved.
     * @param index
     *            The index to which the song will be moved.
     */
    @Override
    public void adjustOrder(String song, int index) {
        if (index <= this.playlist.length()) {
            Queue<String> temp = new Queue1L<>();
            boolean found = false;

            while (this.playlist.length() > 0) {
                String currentSong = this.playlist.dequeue();
                if (!found && currentSong.equals(song)) {
                    found = true;
                } else {
                    temp.enqueue(currentSong);
                }
            }

            int currentIndex = 0;
            while (temp.length() > 0) {
                if (currentIndex == index) {
                    this.playlist.enqueue(song);
                }
                this.playlist.enqueue(temp.dequeue());
                currentIndex++;
            }

            if (currentIndex == index) {
                this.playlist.enqueue(song);
            }
            this.currentTrack = this.playlist.front();
        }
    }

    /**
     * Compares the current object with another object.
     *
     * @param o
     *            object being compared.
     * @return isEqual Return if the objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof MusicPlayerSecondary)) {
            return false;
        }
        MusicPlayerSecondary other = (MusicPlayerSecondary) o;

        if (this.isPlaying != other.isPlaying) {
            return false;
        }

        Queue<String> thisTemp = new Queue1L<>();
        Queue<String> otherTemp = new Queue1L<>();
        boolean isEqual = true;

        while (this.playlist.length() > 0 && other.playlist.length() > 0) {
            String song1 = this.playlist.dequeue();
            String song2 = other.playlist.dequeue();
            if (!song1.equals(song2)) {
                isEqual = false;
            }

            thisTemp.enqueue(song1);
            otherTemp.enqueue(song2);
        }

        while (thisTemp.length() > 0) {
            this.playlist.enqueue(thisTemp.dequeue());
        }
        while (otherTemp.length() > 0) {
            other.playlist.enqueue(otherTemp.dequeue());
        }
        return isEqual;

    }

    /**
     * Converts MusicPlayerSecondary to a string.
     *
     * @return the string version of MusicPlayerSecondary.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilt = new StringBuilder("{");
        Iterator<String> iterator1 = this.playlist.iterator();

        while (iterator1.hasNext()) {
            stringBuilt.append(iterator1.next());
            if (iterator1.hasNext()) {
                stringBuilt.append(", ");
            }
        }
        stringBuilt.append("}");
        return stringBuilt.toString();
    }
}
