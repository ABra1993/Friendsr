package example.promo.friendsr;

import java.io.Serializable;

/**
 * This function creates a Friend object and returns the name, bio (i.e. quote), episode and
 * resource ID of corresponding image.
 */
public class Friend implements Serializable {

    // properties of the class...
    private String name, bio, episode;
    private int drawableId;

    // constructor of the class...
    public Friend(String name, String bio, String episode, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.episode = episode;
        this.drawableId = drawableId;
    }

    // methods of the class...
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getEpisode() {
        return episode;
    }

    public int getDrawableId() {
        return drawableId;
    }
}
