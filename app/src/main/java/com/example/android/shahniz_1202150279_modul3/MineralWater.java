package com.example.android.shahniz_1202150279_modul3;

/**
 * Created by Shahniz on 25/02/2018.
 */

public class MineralWater {
    //Member variables representing the title and information about the mineral water
    private String title;
    private String info;
    private final int imageResource;

    /**
     * Constructor for the Mineral data model
     * @param title The name of the mineral water.
     * @param info Information about the mineral water.
     */
    MineralWater(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    /**
     * Gets the title of the mineral water
     * @return The title of the mineral water.
     */
    String getTitle() {
        return title;
    }
    /**
     * Gets the info about the mineral water
     * @return The info about the mineral water.
     */
    String getInfo() {
        return info;
    }

    public int getImageResource() { return imageResource; }
}
