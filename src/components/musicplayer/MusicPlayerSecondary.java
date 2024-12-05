package components.musicplayer;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Abstract class to implement MusicPlayer. Includes methods such as skip,
 * shuffle, adjustOrder, equals, and toString.
 */
public abstract class MusicPlayerSecondary implements MusicPlayer {

    /**
     * Skips current song and set the next song as current.
     */
    @Override
    public void skip() {
        if (this.getPlaylistLength() > 0) {
            this.removeSong(this.getTrack());
        }
    }

    /**
     * Randomly shuffles the order of songs in the playlist.
     */
    @Override
    public void shuffle() {
        String[] sortingArray = new String[this.getPlaylistLength()];

        int shuffleIndex = 0;
        while (this.getPlaylistLength() > 0) {
            sortingArray[shuffleIndex] = this.getTrack();
            this.removeSong(this.getTrack());
            shuffleIndex++;
        }

        for (int i = 0; i < sortingArray.length; i++) {
            int randomIndex = (int) (Math.random() * sortingArray.length);

            String tempString = sortingArray[i];
            sortingArray[i] = sortingArray[randomIndex];
            sortingArray[randomIndex] = tempString;
        }

        for (String song : sortingArray) {
            this.addSong(song);
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
        if (index <= this.getPlaylistLength()) {
            Queue<String> temp = new Queue1L<>();
            boolean found = false;

            while (this.getPlaylistLength() > 0) {
                String currentSong = this.getTrack();
                this.removeSong(currentSong);

                if (!found && currentSong.equals(song)) {
                    found = true;
                } else {
                    temp.enqueue(currentSong);
                }
            }

            int currentIndex = 0;
            while (temp.length() > 0 || currentIndex == index) {
                if (currentIndex == index) {
                    this.addSong(song);
                }
                this.addSong(temp.dequeue());
                currentIndex++;
            }

            if (currentIndex == index) {
                this.addSong(song);
            }
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

        if (this.play() != other.play()) {
            return false;
        }

        Queue<String> thisTemp = new Queue1L<>();
        Queue<String> otherTemp = new Queue1L<>();
        boolean isEqual = true;

        while (this.getPlaylistLength() > 0 && other.getPlaylistLength() > 0) {
            String song1 = this.getTrack();
            this.removeSong(song1);
            String song2 = other.getTrack();
            this.removeSong(song2);
            if (!song1.equals(song2)) {
                isEqual = false;
            }

            thisTemp.enqueue(song1);
            otherTemp.enqueue(song2);
        }

        while (thisTemp.length() > 0) {
            this.addSong(thisTemp.dequeue());
        }
        while (otherTemp.length() > 0) {
            other.addSong(otherTemp.dequeue());
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
        Queue<String> temp = new Queue1L<>();
        while (this.getPlaylistLength() > 0) {
            String song = this.getTrack();
            this.removeSong(song);
            stringBuilt.append(song);
            temp.enqueue(song);
            if (this.getPlaylistLength() > 0) {
                stringBuilt.append(", ");
            }
        }

        while (temp.length() > 0) {
            this.addSong(temp.dequeue());
        }

        stringBuilt.append("}");
        return stringBuilt.toString();
    }
}
