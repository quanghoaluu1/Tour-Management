/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;

import constant.Message;
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
            if (this.checkTourByID(tourID) != null) {
                System.out.println("This ID is existed!");
                return;
            } else {
                tourName = dv.inputTourName(Message.INPUT_TOUR_NAME.getPattern());
                tourDestination = dv.inputTourDestination(Message.INPUT_TOUR_DESTINATION.getPattern());
                tourDuration = dv.inputTourDuration(Message.INPUT_TOUR_DURATION.getPattern());
                tourDescription = dv.inputTourDescription(Message.INPUT_TOUR_DESCRIPTION.getPattern());
                tourPrice = dv.inputTourPrice(Message.INPUT_TOUR_PRICE.getPattern());
            }
            tourCatalog
                    .add(new TourPackage(tourID, tourName, tourDestination, tourDuration, tourDescription, tourPrice));
            System.out.println("Create Tour success");
            check = input.inputYorN(Message.WANT_TO_CONTINUE.getPattern());
        } while (check);

    }

    public TourPackage checkTourByID(String id) {
        for (TourPackage arr : tourCatalog) {
            if (id.equalsIgnoreCase(arr.getTourID())) {
                return arr;
            }
        }
        return null;
    }

    public void showTour() {
        tour.toString();
    }
}
