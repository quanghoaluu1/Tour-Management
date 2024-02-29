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

    TOUR_ID("^[Tt]\\d{2}$"),
    TOUR_NAME("^[a-zA-Z]+[a-zA-z0-9\\s]*$"),
    TOUR_PRICE("^[1-9][0-9]*$"),
    TOUR_FORMAT("| %-10s | %-20s | %-20s | %-10d | %-40s | %-10d |");
    
    private final String pattern;

    Regex(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }


}

