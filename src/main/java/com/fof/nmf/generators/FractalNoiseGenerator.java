package com.fof.nmf.generators;

import com.badlogic.gdx.math.MathUtils;

public class FractalNoiseGenerator {

    private double octaves;
    private double lacunarity;
    private double persistence;

    private double heightMax;
    private double heightMin;
    private double frequencyMax;

    private double amplitudeMax;

    private double offsetX;
    private double offsetY;

    public FractalNoiseGenerator(double amplitude, double frequency, double octaves,
                                 double lacunarity, double persistence, double heightMin,
                                 double heightMax) {
        this.octaves = octaves;
        this.lacunarity = lacunarity;
        this.persistence = persistence;
        this.heightMax = heightMax;
        this.heightMin = heightMin;
        this.frequencyMax = frequency;
        this.amplitudeMax = amplitude;

        offsetX = MathUtils.random(-42069f, 42069f);
        offsetY = MathUtils.random(-42069f, 42069f);

    }

    /**
     * Returns a random double
     * @param x x sample coordinate
     * @param y y xample coordinate
     * @return random double within heightMin and heightMax
     */
    public double fractal_noise(int x, int y) {
        double noise = heightMax / 2;
        double frequency = frequencyMax;
        double amplitude = amplitudeMax;
        for (int i = 0; i < octaves; i++) {
            double sampleX = x * frequency + offsetX;
            double sampleY = y * frequency + offsetY;
            noise = noise + SimplexNoise.noise(sampleX, sampleY) * amplitude;
            frequency *= lacunarity;
            amplitude *= persistence;
        }

        noise = MathUtils.clamp(noise, heightMin, heightMax);

        return noise;
    }
}
