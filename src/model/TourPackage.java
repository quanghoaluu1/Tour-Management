/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.Regex;

/**
 *
 * @author quang
 */
public class TourPackage {
    private String tourID;
    private String tourName;
    private String tourDestination;
    private int tourDuration;
    private String tourDescription;
    private int tourPrice;

    public TourPackage() {
    }

    public TourPackage(String tourID, String tourName, String tourDestination, int tourDuration, String tourDescription,
            int tourPrice) {
        this.tourID = tourID;
        this.tourName = tourName;
        this.tourDestination = tourDestination;
        this.tourDuration = tourDuration;
        this.tourDescription = tourDescription;
        this.tourPrice = tourPrice;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDestination() {
        return tourDestination;
    }

    public void setTourDestination(String tourDestination) {
        this.tourDestination = tourDestination;
    }

    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public int getTourPrice() {
        return tourPrice;
    }

    public void setPrice(int price) {
        this.tourPrice = price;
    }

    @Override
    public String toString() {
        return String.format(Regex.TOUR_FORMAT.getPattern(), tourID, tourName, tourDestination, tourDuration,
                tourDescription, tourPrice);
    }

}
