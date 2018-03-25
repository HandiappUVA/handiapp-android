package com.handiapp.handiapp;

/**
 * Created by Jason Ashley on 3/24/2018.
 */

class ServerMarker {
    private double lat;
    private double lng;
    private int typeMark;
    public ServerMarker(double lat, double lng, int typeMark){
        this.lat = lat;
        this.lng = lng;
        this.typeMark = typeMark;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getTypeMark() {
        return typeMark;
    }

    public void setTypeMark(int typeMark) {
        this.typeMark = typeMark;
    }
}
