package com.fof.nmf.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Dungeon Game");
        cfg.setWindowedMode(480, 320);

        new Lwjgl3Application(new DungeonGame(), cfg);
    }
}