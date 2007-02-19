package be.kdg.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 14:54:43
 * To change this template use File | Settings | File Templates.
 */
public final class InputValidation {
    private static InputValidation instance;

    private InputValidation() {
    }


    private boolean isSafeField(String field) {
        if (field.length() == 0) {
            return false;
        }

        Pattern pattern = Pattern.compile("[a-zA-Z0-9@.]");
        Matcher matcher = pattern.matcher(field);

        return matcher.find();
    }

    public boolean isInputValid(String... fields) {
        for (String field : fields) {
            if (!isSafeField(field)) {
                return false;
            }
        }
        return true;
    }

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

    public static InputValidation getInstance() {
        if (instance == null) {
            instance = new InputValidation();
        }
        return instance;
    }
}
