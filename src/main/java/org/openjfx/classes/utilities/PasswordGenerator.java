package org.openjfx.classes.utilities;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class PasswordGenerator {

    private static final char[] chars = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~").toCharArray();

    public static char[] generatePassword() {

        Random randomNumber = new Random();
        char[] newPassword = new char[16];

        //Do iterations
        do{

            for(int i = 0; i < 16; i++) {

            	newPassword[i] = chars[randomNumber.nextInt(chars.length)];

            }

        }while(!isPasswordSecure(newPassword));

        return newPassword; 

    }

    //set of rules to check password security
    private static boolean isPasswordSecure(char[] password) {

        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{8,}$", new String(password));

    }

    public static ArrayList<String> verifyPassword(char[] password) {
	//Add verifications
	ArrayList<String> verificationMessages = new ArrayList<String>();
	String pass = new String(password);

	if(!Pattern.matches(".*[a-z].*", pass))
	    verificationMessages.add("At least one lowercase");

	if(!Pattern.matches(".*[A-Z].*", pass))
	    verificationMessages.add("At least one uppercase");

	if(!Pattern.matches(".*\\d.*", pass))
	    verificationMessages.add("At least one number");

	if(!Pattern.matches(".*[^\\w\\s].*", pass))
	    verificationMessages.add("At least one special character");

	if(!Pattern.matches(".{8,}", pass))
	    verificationMessages.add("password must be at least 8 characters");
	
	return verificationMessages;
    }

}
