package com.fof.nmf.tilemaps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.generators.SimplexNoise;

public class TiledMapGenerator {

    private final int width;
    private final int height;

    public TiledMapGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public TiledMap generateMap()
    {
        TiledMap map = new TiledMap();
        MapLayers layers = map.getLayers();

        Texture tileTextures = new Texture(
                Gdx.files.internal("src/main/resources/sprites/Ground/Grass.png")
        );

        TextureRegion[][] splitTiles = TextureRegion.split(tileTextures, 16, 16);

        TiledMapTileLayer layer = new TiledMapTileLayer(width, height, 16, 16);

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                double val = SimplexNoise.noise(i, j);
                TextureRegion texture = splitTiles[0][1];
                if (val > .3f) {
                    texture = splitTiles[0][0];
                }

                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                cell.setTile(
                        new StaticTiledMapTile(
                            texture
                        )
                );
                layer.setCell(i, j, cell);
            }
        }

        layers.add(layer);

        return map;
    }
}
