package view;

import constant.ConsoleColor;
import model.Menu;
import service.TourManage;

public class Main {
    private static TourManage tm = new TourManage();

    public static void main(String[] args) {
        Menu menu = new Menu(ConsoleColor.GREEN + "Welcome to HoaTravel " + ConsoleColor.RESET);
        Menu tourMenu = new Menu(ConsoleColor.GREEN + "Tour Management" + ConsoleColor.RESET);
        initMenu(menu, tourMenu);

        int choice;
        do {
            menu.print();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    tourMenu(tourMenu);

                    break;

                default:
                    break;
            }
        } while (choice != menu.optionList.size());

    }

    private static void initMenu(Menu mm, Menu tm) {
        mm.addOption("Tour Management");
        mm.addOption("Hotel Management");
        mm.addOption("Booking Management");
        mm.addOption("Reporting and Analytics");

        tm.addOption("Create new Tour");
        tm.addOption("Update Tour");
        tm.addOption("Delete Tour");
        tm.addOption("Show Tour");

    }

    private static void tourMenu(Menu menu) {

        int option;
        do {
            menu.print();
            option = menu.getChoice();
            switch (option) {
                case 1:
                    tm.createTour();
                    break;
                case 2:
                    tm.updateTour();
                    break;
                case 3:
                    tm.deleteTour();
                    break;
                case 4:
                    tm.showAllTour();
                    break;
                default:
                    break;
            }
        } while (option != menu.optionList.size());

    }

}
