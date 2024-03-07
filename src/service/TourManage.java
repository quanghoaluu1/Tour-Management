/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import constant.Message;
import constant.Regex;
import model.TourPackage;
import utility.DataValid;
import utility.Input;

/**
 *
 * @author quang
 */
public class TourManage {
    private Input input;
    private List<TourPackage> tourCatalog;
    private TourPackage tour;
    private DataValid dv;

    public TourManage() {
        input = new Input();
        tourCatalog = new ArrayList<>();
        dv = new DataValid();
        tour = new TourPackage();

    }

    /**
     * A method to show a tour package.
     *
     * @param tour the tour package to be shown
     */
    private void showTour(TourPackage tour) {
        System.out.println(tour.toString() + "\n");
    }

    public void createTour() {
        String tourID = "";
        String tourName = "";
        String tourDestination = "";
        int tourDuration = 0;
        String tourDescription = "";
        int tourPrice = 0;
        boolean check = true;
        do {
            tourID = dv.inputTourId(Message.INPUT_TOUR_ID.getPattern());
            if (this.searchTourById(tourID) != null) {
                System.out.println("This ID is existed!");
                return;
            } else {
                // tourName = dv.inputTourName(Message.INPUT_TOUR_NAME.getPattern());
                // tourDestination =
                // dv.inputTourDestination(Message.INPUT_TOUR_DESTINATION.getPattern());
                // tourDuration =
                // dv.inputTourDuration(Message.INPUT_TOUR_DURATION.getPattern());
                // tourDescription =
                // dv.inputTourDescription(Message.INPUT_TOUR_DESCRIPTION.getPattern());
                // tourPrice = dv.inputTourPrice(Message.INPUT_TOUR_PRICE.getPattern());
                tourName = input.inputNotNull("Input name", String.class, Regex.TOUR_NAME.getPattern());
                tourDestination = input.inputNotNull("Input des", String.class, Regex.TOUR_DESTINATION.getPattern());
                tourDuration = input.inputNotNull("Input dur", Integer.class, Regex.TOUR_NUMBER.getPattern());
                tourDescription = input.inputNotNull("Input desc", String.class, Regex.TOUR_DESCRIPTION.getPattern());
                tourPrice = input.inputNotNull("Input price", Integer.class, Regex.TOUR_NUMBER.getPattern());

            }
            tourCatalog
                    .add(new TourPackage(tourID, tourName, tourDestination, tourDuration, tourDescription, tourPrice));
            System.out.println("Create Tour success");
            check = input.inputYorN(Message.WANT_TO_CONTINUE.getPattern());
        } while (check);

    }

    /**
     * A method to search for a tour package by ID.
     *
     * @param id the ID of the tour package to search for
     * @return the tour package with the specified ID, or null if not found
     */
    public TourPackage searchTourById(String id) {
        for (TourPackage arr : tourCatalog) {
            if (id.equalsIgnoreCase(arr.getTourID())) {
                return arr;
            }
        }
        return null;
    }

    /**
     * A method to display all tours in the tour catalog.
     */
    public void showAllTour() {
        if (tourCatalog.isEmpty()) {
            System.out.println("No tour found");
            return;
        }
        for (TourPackage tour : tourCatalog) {
            System.out.println(tour.toString() + "\n");
        }
    }

    /**
     * A method to update a tour package.
     */
    public void updateTour() {
        String id = "";
        id = input.inputStringRegex(Message.INPUT_TOUR_ID.getPattern(), Regex.TOUR_ID.getPattern());

        TourPackage targetTour = searchTourById(id);
        if (targetTour == null) {
            System.out.println("Tour not found");
            return;
        } else {
            System.out.println("Before update: ");
            showTour(targetTour);
            String newName = input.input(
                    Message.INPUT_TOUR_NAME.getPattern() + " or " + Message.ENTER_TO_KEEP_OLD.getPattern(),
                    String.class,
                    Regex.TOUR_NAME.getPattern());
            String newDes = input.input(
                    Message.INPUT_TOUR_DESTINATION.getPattern() + " or " + Message.ENTER_TO_KEEP_OLD.getPattern(),
                    String.class, Regex.TOUR_DESTINATION.getPattern());
            Integer newDur = input.input(
                    Message.INPUT_TOUR_DURATION.getPattern() + " or " + Message.ENTER_TO_KEEP_OLD.getPattern(),
                    Integer.class, Regex.TOUR_NUMBER.getPattern());
            String newDesc = input.input(
                    Message.INPUT_TOUR_DESCRIPTION.getPattern() + " or " + Message.ENTER_TO_KEEP_OLD.getPattern(),
                    String.class, Regex.TOUR_DESCRIPTION.getPattern());
            Integer newPrice = input.input(
                    Message.INPUT_TOUR_PRICE.getPattern() + " or " + Message.ENTER_TO_KEEP_OLD.getPattern(),
                    Integer.class,
                    Regex.TOUR_NUMBER.getPattern());
            this.updateAttribute(newName, newDes, newDur, newDesc, newPrice);
            System.out.println("After update: ");
            showTour(targetTour);
        }

    }

    private void updateAttribute(String name, String destination, Integer duration, String description, Integer price) {
        if (name != null) {
            tour.setTourName(name);
        }
        if (destination != null) {
            tour.setTourDestination(destination);
        }
        if (duration != null) {
            tour.setTourDuration(duration);
        }
        if (description != null) {
            tour.setTourDescription(description);
        }
        if (price != null) {
            tour.setTourPrice(price);
        }
    }

    /**
     * A method to delete a tour package.
     */
    public void deleteTour() {
        String id = "";
        id = input.inputStringRegex(Message.INPUT_TOUR_ID.getPattern(), Regex.TOUR_ID.getPattern());
        TourPackage targetTour = searchTourById(id);
        if (targetTour == null) {
            System.out.println("Tour not found");
            return;
        } else {
            System.out.println("Before delete: ");
            showTour(targetTour);
            if (input.inputYorN(Message.WANT_TO_DELETE.getPattern())) {
                tourCatalog.remove(targetTour);
                System.out.println("Delete success");
            }
        }

    }
}
