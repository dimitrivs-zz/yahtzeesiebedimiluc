/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class provides non-reversible string encryption for security purposes.
 * An instance of this class is accessed through the getInstance method.
 */
public final class Security {
    private static Security instance;

    private Security() {
    }

    /**
     * Method for getting an instance of the Security class.
     *
     * @return Security object
     */
    public static synchronized Security getInstance() {
        if (instance == null) {
            instance = new Security();
        }
        return instance;
    }

    /**
     * This method provides the encryption algorythm.
     *
     * @param plaintext String containing the text to be encrypted.
     * @return String containing the encrypted text.
     */
    public synchronized String encrypt(String plaintext) /*throws SystemUnavailableException*/ {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("gaat niet");
        }

        try {
            md.update(plaintext.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("gaat niet");
        }

        byte raw[] = md.digest();
        String hash = (new BASE64Encoder()).encode(raw);
        return hash;
    }
}