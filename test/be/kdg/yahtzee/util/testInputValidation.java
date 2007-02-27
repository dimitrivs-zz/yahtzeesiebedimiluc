package be.kdg.yahtzee.util;

import be.kdg.util.InputValidation;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 15:28:11
 * To change this template use File | Settings | File Templates.
 */
public class testInputValidation extends TestCase {
    private InputValidation inputValidation;

    @Before
    public void setUp() {
        inputValidation = InputValidation.getInstance();
    }

    @After
    protected void tearDown() throws Exception {
        inputValidation = null;
    }

    @Test
    public void testInputValidation() throws Exception {
        String test1 = "";
        String test2 = "qsdf";

        assertFalse("Dit mag niet lukken", inputValidation.isInputValid(test1, test2));

        test1 = "qsdf";
        test2 = "qsdf";
        String test3 = "&יי{[^";

        assertFalse("Dit mag niet lukken", inputValidation.isInputValid(test1, test2, test3));

        test1 = "qsdf";
        test2 = "qsdf";
        test3 = "qsdf@.";

        assertTrue("Dit lukt wel", inputValidation.isInputValid(test1, test2, test3));

        test1 = "122";
        test2 = "111";
        test3 = "qsdf";

        assertFalse("Dit lukt niet", inputValidation.isNumberValid(test1, test2, test3));

        test1 = "122";
        test2 = "111";
        test3 = "111";

        assertTrue("Dit lukt wel", inputValidation.isNumberValid(test1, test2, test3));
    }
}
