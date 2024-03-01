package view;

import model.Menu;
import service.TourManage;

public class Main {
    private TourManage tm = new TourManage();

    public static void main(String[] args) {
        Menu menu = new Menu("Welcome to HoaTravel ");
        Menu tourMenu = new Menu("Tour Management");
        initMenu(menu, tourMenu);
    }

    private static void initMenu(Menu mm, Menu tm) {
        tm.addOption("Create new Tour");
        tm.addOption("Update Tour");
        tm.addOption("Delete Tour");
        tm.addOption("Show Tour");
    }

}
