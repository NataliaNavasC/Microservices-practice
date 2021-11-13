package com.microsystem.ExternalServices.Model;

import com.google.maps.model.DirectionsStep;
import org.jsoup.Jsoup;

public class Steps {
    private String instruccions;
    private long meters;
    private long duration;
    private Location startLocation;
    private Location endLocation;

    public Steps(DirectionsStep step){
        this.instruccions = Jsoup.parse(step.htmlInstructions).text();
        this.meters = step.distance.inMeters;
        this.duration = step.duration.inSeconds;
        this.startLocation = new Location(step.startLocation.lat,step.startLocation.lng);
        this.endLocation = new Location(step.endLocation.lat,step.endLocation.lng);
    }

    public String getInstruccions() {
        return instruccions;
    }

    public long getMeters() {
        return meters;
    }

    public long getDuration() {
        return duration;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    private static class Location{
        private double lat;
        private double lng;

        public Location(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public double getLng() {
            return lng;
        }
    }
}
