package com.fof.nmf.tilemaps;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.MathUtils;
import com.fof.nmf.generators.FractalNoiseGenerator;
import com.fof.nmf.generators.SimplexNoise;

public class TiledMapGenerator {


    private static FractalNoiseGenerator generator;


    public static TiledMap generateWorldMap(TextureRegion[][] textureRegion,
                                            int worldWidth, int worldHeight, int tileWidth, int tileHeight) {


        if (generator == null) {
            generator = new FractalNoiseGenerator(
                    8,
                    0.05,
                    2,
                    2,
                    0.5,
                    0,
                    16
            );
        }

        TiledMap map = new TiledMap();
        TiledMapTileLayer layer = new TiledMapTileLayer(worldWidth, worldHeight, tileWidth, tileHeight);

        MapLayers layers = map.getLayers();

        for (int i = 0; i < worldWidth; i++)
        {
            for (int j = 0; j < worldHeight; j++)
            {
                double val = generator.fractal_noise(i, j);

                double fraction = val / textureRegion[0].length;
                int index = (int) Math.floor(fraction * (textureRegion[0].length - 1));

                index = MathUtils.clamp(index, 0, textureRegion[0].length - 1);

                TextureRegion texture = textureRegion[0][index];

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
