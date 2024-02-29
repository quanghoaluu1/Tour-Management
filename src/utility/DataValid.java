package utility;

import java.util.ArrayList;
import java.util.List;

import constant.Message;
import constant.Regex;
import model.TourPackage;

public class DataValid {
    private Input input;
    private String regex;

    public DataValid() {
        this.input = new Input();
    }

    /**
     * 
     * @param msg : message to show
     * @return ID of the tour
     */
    public String inputTourId(String msg) {
        regex = Regex.TOUR_ID.getPattern();
        msg = Message.INPUT_TOUR_ID.getPattern();
        String str;
        str = input.inputStringRegex(msg, regex).toUpperCase();
        return str;
    }

    public boolean isExistedTour(List<TourPackage> tour, String id) {
        for (TourPackage arr : tour) {
            if (arr.getTourID().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }

    /**
     * 
     * @param msg : message to show
     * @return Name of the tour
     */
    public String inputTourName(String msg) {
        regex = Regex.TOUR_NAME.getPattern();
        msg = Message.INPUT_TOUR_NAME.getPattern();
        String str;
        str = input.inputStringRegex(msg, regex).toUpperCase();
        return str;
    }

    /**
     * 
     * @param msg : message to show
     * @return Destination of the tour
     */
    public String inputTourDestination(String msg) {
        msg = Message.INPUT_TOUR_DESTINATION.getPattern();
        String str;
        str = input.inputStringNotBlank(msg);
        return str;
    }

    /**
     * 
     * @param msg : message to show
     * @return duration of the tour
     */
    public int inputTourDuration(String msg) {
        msg = Message.INPUT_TOUR_DURATION.getPattern();
        int duration = input.inputInt(msg, 0);
        return duration;
    }

    /**
     * 
     * @param msg : message to show
     * @return Description of the tour
     */
    public String inputTourDescription(String msg) {
        msg = Message.INPUT_TOUR_DESCRIPTION.getPattern();
        String str = input.inputStringNotBlank(msg);
        return str;
    }

    /**
     * 
     * @param msg : message to show
     * @return Price of the tour
     */
    public int inputTourPrice(String msg) {
        msg = Message.INPUT_TOUR_PRICE.getPattern();
        int price = input.inputInt(msg, 0);
        return price;
    }
}
