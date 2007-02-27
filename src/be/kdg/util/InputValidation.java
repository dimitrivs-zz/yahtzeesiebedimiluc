/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This input validation class provides the functionality of checking
 * the entered data for SQL-injction.
 * An instance of this class is accessed through the getInstance method.
 */
public final class InputValidation {
    private static InputValidation instance;

    private InputValidation() {
    }

    /**
     * Method for getting an instance of the InputValidation class.
     *
     * @return InputValidation object
     */
    public static InputValidation getInstance() {
        if (instance == null) {
            instance = new InputValidation();
        }
        return instance;
    }

    /**
     * Method for checking for valid input
     *
     * @param fields array of String fields to be checked
     * @return boolean value
     *         true if all fields are safe
     *         false if one of the fields is not safe
     */
    public boolean isInputValid(String... fields) {
        for (String field : fields) {
            if (!isSafeField(field)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method for checking fields with numbers allowed
     *
     * @param fields array of String fields to be checked
     * @return boolean value
     *         true if field contains only integers
     *         false if one field contains a non-integer value
     */
    public boolean isNumberValid(String... fields) {
        int number;
        try {
            for (String field : fields) {
                number = Integer.parseInt(field);
            }
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Method for checking field value against regular expression.
     *
     * @param field String containing field value
     * @return boolean value
     *         true if field is safe
     *         false if field is not safe
     */
    private boolean isSafeField(String field) {
        if (field.length() == 0) {
            return false;
        }

        Pattern pattern = Pattern.compile("[a-zA-Z0-9@.]");
        Matcher matcher = pattern.matcher(field);

        return matcher.find();
    }
}
