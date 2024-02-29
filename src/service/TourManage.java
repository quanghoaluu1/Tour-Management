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
    private List<TourPackage> tour;
    private DataValid dv;

    public TourManage() {
        input = new Input();
        tour = new ArrayList<>();
        dv = new DataValid();

    }

    public void createTour() {
        String tourID = "";
        String tourName = "";
        String tourDestination = "";
        int tourDuration = 0;
        String tourDescription = "";
        int tourPrice = 0;
        boolean check = true;
        while (check) {
            addTourToSystem(tourID, tourName, tourDestination, tourDuration, tourDescription, tourPrice);
            tour.add(new TourPackage(tourID, tourName, tourDestination, tourDuration, tourDescription, tourPrice));
            System.out.println("Create Tour success");
            check = input.inputYorN(Message.WANT_TO_CONTINUE.getPattern());
        }

    }

    public void addTourToSystem(String id, String name, String destination, int duration, String description,
            int price) {
        // add a tour package to list of tours
        id = dv.inputTourId(Message.INPUT_TOUR_ID.getPattern());
        if (dv.isExistedTour(tour, id)) {
            System.out.println("This ID is existed!");
            return;
        } else {
            name = dv.inputTourName(Message.INPUT_TOUR_NAME.getPattern());
            destination = dv.inputTourDestination(Message.INPUT_TOUR_DESTINATION.getPattern());
            duration = dv.inputTourDuration(Message.INPUT_TOUR_DURATION.getPattern());
            description = dv.inputTourDescription(Message.INPUT_TOUR_DESCRIPTION.getPattern());
            price = dv.inputTourPrice(Message.INPUT_TOUR_PRICE.getPattern());
        }
    }

}
