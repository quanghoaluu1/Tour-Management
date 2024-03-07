package utility;

import java.util.InputMismatchException;
import java.util.Scanner;

import constant.ConsoleColor;
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
    public String inputStringRegex(String msg, String regex) {

        System.out.println(msg);
        boolean check = true;
        String strInput = "";
        do {
            strInput = sc.next();
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
     * Method to input a string from user can be blank, if not blank then it should
     * match the given regex
     * 
     * @param msg
     * @return
     */
    public String inputStringRegexBlank(String msg, String regex) {
        System.out.println(msg);
        String strInput = "";
        boolean check = true;
        do {
            strInput = sc.nextLine();
            if (!strInput.isEmpty() && !isValidRegex(strInput, regex)) {
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

        do {
            try {
                System.out.println(msg);
                input = sc.nextInt();
                if (isValidInt(input, min)) {
                    check = false;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println(e.getMessage());
                sc.next();

            }

        } while (check);

        return input;
    }

    /**
     * 
     * @param input integer number that needs to be checked
     * @param min   minimum limit of the integer
     * @return true if input > min , else false
     */
    public boolean isValidInt(int input, int min) {
        boolean check = true;
        if (input < min || input == -1) {
            System.out.printf("Error: Input should be > %d and not null ", min);
            check = false;
        }
        return check;
    }

    /**
     * 
     */
    public int inputBlankInt(String msg) {
        int result = -1;
        boolean check = true;
        try {
            do {
                System.out.println(msg);
                String number = sc.nextLine();
                if (number.equals("")) {

                    result = -1;
                    check = false;

                }
                result = Integer.parseInt(number.trim());
                check = false;
            } while (check);

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    /**
     * A method to check if a string is empty
     * 
     * @param str string to be checked for empty
     * @return true if string is empty otherwise false
     */
    public boolean isEmpty(String str) {
        return str.trim().isEmpty();
    }

    public boolean inputYorN(String msg) {
        System.out.println(msg);
        String choice;
        choice = sc.next();
        return choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("yes");
    }

    /**
     * This method prompts the user with a message and expects an input of a
     * specific type.
     * It supports Integer, Double, and String types. If the input is not of the
     * expected type,
     * it will print an error message and prompt the user again.
     *
     * @param <T> The type of the expected input.
     * @param msg The message to display to the user.
     * @param t   The Class object of the expected input type.
     * @return The user's input cast to the expected type.
     * @throws IllegalArgumentException if the Class object does not represent
     *                                  Integer, Double, or String.
     * @throws InputMismatchException   if the user's input cannot be converted to
     *                                  the expected type.
     */
    public <T> T input(String msg, Class<T> t, String regex) {
        System.out.println(msg);
        T result = null;
        boolean check = true;

        do {
            try {

                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    result = null;
                    check = false;
                } else if (t == Integer.class) {
                    result = t.cast(Integer.parseInt(input));
                    check = false;
                } else if (t == Double.class) {
                    result = t.cast(Double.parseDouble(input));
                    check = false;
                } else if (t == String.class) {
                    result = t.cast(input);
                    check = false;
                } else {
                    throw new IllegalArgumentException("No support data type");
                }
            } catch (NumberFormatException e) {
                System.err.println(errInvalid);
            }

        } while (check || (result != null && !result.toString().matches(regex)));
        sc.nextLine();
        return result;
    }

    /**
     * This method prompts the user with a message and expects an input of a
     * specific type.
     * It supports Integer, Double, and String types. If the input is not of the
     * expected type,
     * it will print an error message and prompt the user again.
     *
     * @param <T> The type of the expected input.
     * @param msg The message to display to the user.
     * @param t   The Class object of the expected input type.
     * @return The user's input cast to the expected type.
     * @throws IllegalArgumentException if the Class object does not represent
     *                                  Integer, Double, or String.
     * @throws InputMismatchException   if the user's input cannot be converted to
     *                                  the expected type.
     */

    public <T> T inputNotNull(String msg, Class<T> t, String regex) {
        System.out.println(msg);
        T result = null;
        do {
            try {

                if (t == Integer.class) {
                    result = t.cast(sc.nextInt());
                    if (!result.toString().matches(regex)) {
                        result = null;
                    }
                } else if (t == Double.class) {
                    result = t.cast(sc.nextDouble());
                    if (!result.toString().matches(regex)) {
                        result = null;
                    }
                } else if (t == String.class) {
                    result = t.cast(sc.next());
                    if (!result.toString().matches(regex)) {
                        result = null;
                    }
                } else {
                    throw new IllegalArgumentException("No support data type");
                }
            } catch (InputMismatchException e) {
                System.err.println(errInvalid);
                sc.next();
            }
            if (result == null) {
                System.out.println(ConsoleColor.RED + errInvalid + ConsoleColor.RESET);
            }
        } while (result == null);
        return result;
    }
}
