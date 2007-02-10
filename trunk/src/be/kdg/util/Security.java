package be.kdg.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public final class Security
{
    private static Security instance;

    private Security()
    {
    }

    public synchronized String encrypt(String plaintext) /*throws SystemUnavailableException*/
    {
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("SHA"); //step 2
        }catch(NoSuchAlgorithmException e){
            System.out.println("gaat niet");
        }

        try {
            md.update(plaintext.getBytes("UTF-8")); //step 3
        }catch(UnsupportedEncodingException e)
        {
            System.out.println("gaat niet");
        }

        byte raw[] = md.digest(); //step 4
        String hash = (new BASE64Encoder()).encode(raw); //step 5
        return hash; //step 6
    }

    public static synchronized Security getInstance() //step 1
    {
        if(instance == null)
        {
            instance = new Security();
        }
        return instance;
    }
}