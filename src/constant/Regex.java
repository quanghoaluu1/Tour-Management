/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 *
 * @author quang
 */
public enum Regex {
    // Tour
    TOUR_ID("^[Tt]\\d{2}$"),
    TOUR_NAME("^[a-zA-Z]+[a-zA-z0-9\\s]*$"),
    TOUR_NUMBER("^[1-9][0-9]*$"),
    TOUR_FORMAT("| %-10s | %-20s | %-20s | %-10d | %-40s | %-10d |"),
    TOUR_DESTINATION("^[a-zA-Z]+[a-zA-z0-9\\s]*$"),
    TOUR_DESCRIPTION("^[a-zA-Z]+[a-zA-z0-9\\s]*$"),

    // Hotel
    HOTEL_ID("^[Hh]\\d{2}$"),
    HOTEL_NAME("^[a-zA-Z]+[a-zA-z0-9\\s]*$"),
    HOTEL_NUMBER("^[1-9][0-9]*$"),
    HOTEL_LOCATION("^[a-zA-Z]+[a-zA-z0-9\\s]*$"),
    HOTEL_AMENITIES("^[a-zA-Z]+[a-zA-z0-9\\s]*$");

    private final String pattern;

    Regex(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

}
