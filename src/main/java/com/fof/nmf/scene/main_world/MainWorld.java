package com.fof.nmf.scene.main_world;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.fof.nmf.sprite.GameSprite;

import java.util.ArrayList;

/**
 * Container for MainWorld information
 */
public class MainWorld {

    /**
     * Tilemap
     */
    private static TiledMap map;

    public static void setMap(TiledMap map) {
        MainWorld.map = map;
    }

    public static TiledMap getMap() {
        return map;
    }
}
