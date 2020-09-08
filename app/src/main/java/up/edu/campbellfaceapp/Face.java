package up.edu.campbellfaceapp;
import java.util.*;

/**
 * Face class for building a cute face app!
 * @ChloeCampbell
 * Version 1.0 for homework part A
 * 9-8-2020
 */

public class Face {
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    public Face() {
        randomize();
    }
    public void randomize() {
        this.skinColor = (int)(Math.random());
        this.eyeColor = (int)(Math.random());
        this.hairColor = (int)(Math.random());
        this.hairStyle = (int)(Math.random());
    }
}
