package com.example.taller_6.Entities;

import android.content.res.TypedArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Serie implements Serializable {

    private int serieImage;
    private String serieName;

    public Serie(int serieImage, String serieName) {
        this.serieImage = serieImage;
        this.serieName = serieName;
    }

    public static List<Serie> prepareSeries(TypedArray seriesImages, String[] seriesNames){

        List<Serie> series = new ArrayList<>(seriesImages.length());

        for(int i = 0; i < seriesImages.length(); i++){
            Serie serie = new Serie(seriesImages.getResourceId(i, -1), seriesNames[i]);
            series.add(serie);
        }

        return series;
    }

    public int getSerieImage() {
        return serieImage;
    }

    public void setSerieImage(int serieImage) {
        this.serieImage = serieImage;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }
}
