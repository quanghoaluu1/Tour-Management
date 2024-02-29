package model;

import java.util.ArrayList;

import utility.Input;

public class Menu {
    public ArrayList<String> optionList = new ArrayList<>();
    public String title;
    Input input;

    public Menu(String title) {
        this.title = title;
        this.input = new Input();
    }

    public void addOption(String option) {
        optionList.add(option);
    }

    public void print() {
        int count = 1;
        System.out.println("----------------------------------------------" + title
                + "-----------------------------------------------");
        for (String item : optionList) {
            System.out.println(count + ". " + item);
            count++;
        }
    }

    public int getChoice() {

        int choice = input.inputInt("Input choice: ", 1);
        return choice;
    }
}
