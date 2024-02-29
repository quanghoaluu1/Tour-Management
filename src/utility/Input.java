package utility;

import java.util.Scanner;

import constant.Message;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    private String errNull = Message.ENTER_NOT_NULL.getPattern();
    private String errInvalid = Message.INVALID_DATA.getPattern();

    /**
     * 
     * @param msg   prompt message to show user when asking for input
     * @param regex regular expression pattern that the input must match
     * @return a string of valid input according to given regex
     * @throws IllegalArgumentException if no valid input is provided or EOF is
     *                                  reached before valid input
     */
    public String inputStringRegex(String msg, String regex) throws IllegalArgumentException {
        if (msg == null || regex == null)
            throw new IllegalArgumentException("Message or Regex cannot be Null");
        System.out.println(msg);
        boolean check = true;
        String strInput;
        do {
            strInput = sc.nextLine();
            if (!isValidRegex(strInput, regex)) {
                System.out.println(errInvalid);
            } else if (isEmpty(strInput)) {
                System.out.println(errNull);
            } else {
                check = false;
            }
        } while (check);
        return strInput;
    }

    /**
     * 
     * @param input input string to be checked against the regular expression
     * @param regex regular expression that needs to be matched
     * @return true if matches otherwise false
     */
    public boolean isValidRegex(String input, String regex) {
        return input.matches(regex);
    }

    /**
     * 
     * @param msg   message to be displayed before getting integer input from
     * @param regex Regular Expression for checking the validity of the
     * @return String can be empty or if not empty should matches regex
     * @throws IllegalArgumentException If Message or Regex is Null
     *                                  If Integer Value is Not Valid According To
     *                                  The Given Regex
     */
    public String inputStringBlankRegex(String msg, String regex) throws IllegalArgumentException {
        this.checkIllegalArgument(msg, regex);
        System.out.println(msg);
        boolean check = true;
        String strInput;
        do {
            strInput = sc.nextLine();
            if (!isValidRegex(strInput, regex)) {
                System.out.println(errInvalid);
            } else {
                check = false;
            }
        } while (check);
        return strInput;
    }

    /**
     * 
     * @param msg message to be displayed before getting integer input
     * @return a String not blank
     */
    public String inputStringNotBlank(String msg) {
        System.out.println(msg);

        String strInput = "";
        do {
            strInput = sc.nextLine();
        } while (strInput.isEmpty());
        return strInput;
    }

    /**
     * 
     * @param msg message to be displayed before getting double input from
     * @param min minimum value which a number can have
     * @return Integer Number which is greater than or equal to min
     */
    public int inputInt(String msg, int min) {
        int input = 0;
        boolean check = true;
        try {
            do {
                System.out.println(msg);
                input = sc.nextInt();
                if (isValidInt(input, min)) {
                    check = false;
                }

            } while (check);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return input;
    }

    /**
     * check if objects is null
     * 
     * @param objects array of Objects that need to be printed in the console
     */
    public void checkIllegalArgument(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                throw new IllegalArgumentException("Argument cannot be null");
            }
        }
    }

    /**
     * 
     * @param input integer number that needs to be checked
     * @param min   minimum limit of the integer
     * @return true if input > min , else false
     */
    public boolean isValidInt(int input, int min) {
        boolean check = true;
        if (input <= min || input == -1) {
            System.out.printf("Error: Input should be > %d and not null ", min);
            check = false;
        }
        return check;
    }

    public int inputBlankInt(String msg, int min) {
        int result = -1;
        boolean check = true;
        try {
            do {
                System.out.println(msg);
                String number = sc.nextLine();
                if (number.equals("")) {
                    check = false;
                    result = -1;

                }
                result = Integer.parseInt(number.trim());

            } while (check);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public boolean isEmpty(String str) {
        return str.trim().isEmpty();
    }

    public boolean inputYorN(String msg) {
        System.out.println(msg);
        String choice;
        choice = sc.next();
        return choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("yes");
    }
}
