package com.bridgelabz.oops.programs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.functionalprogramming.util.Utility;
import com.bridgelabz.oops.classes.User;

/** TO GENERATE USER SPECIFIC MESSAGES
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */

public class ConfirmationMessage {

    /**
     * @param args
     * 
     */

    private static StringBuffer template = new StringBuffer("Hello <<name>>, We have your full"
	    + "name as <<full name>> in our system. your contact number is +91­xxxxxxxxxx."
	    + "Please,let us know in case of any clarification Thank you BridgeLabz XX/XX/XXXX.");

    public static void main(String[] args) {
	// CREATE A USER OBJECT AND STORE AND REPLACE WITH THE EXISTING MESSAGE

	User user = new User();
	System.out.println("Enter first name");
	String name=Utility.getUserStringValue();
	user.setFirstName(name);
	System.out.println("Enter last Name");
	user.setLastName(Utility.getUserStringValue());
	System.out.println("Enter mobile number");
	user.setNumber(Utility.getUserStringValue());
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date today = new Date();
	String todayDate = dateFormat.format(today);
	userDefinedMessage(todayDate, user);
	System.out.println(template);
    }

    /**
     * CONVERT THE TEMNPLATE MESSAGE TO THE USER SPECIFIC MESSAGES
     * 
     */
    private static void userDefinedMessage(String todayDate, User user) {
	Pattern pattern = null;

	CharSequence replaceMessage = template;
	pattern = Pattern.compile("[X]{2}/[X]{2}/[X]{4}");
	Matcher m = pattern.matcher(replaceMessage);
	String result = m.replaceAll(todayDate);
	template = new StringBuffer(result);
	replaceMessage = template;
	pattern = Pattern.compile("x{10}");
	m = pattern.matcher(replaceMessage);
	result = m.replaceAll(user.getNumber());
	template = new StringBuffer(result);

	replaceMessage = template;
	pattern = Pattern.compile("<<name>>");
	m = pattern.matcher(replaceMessage);
	result = m.replaceAll(user.getFirstName());
	template = new StringBuffer(result);

	replaceMessage = template;
	pattern = Pattern.compile("<<full name>>");
	m = pattern.matcher(replaceMessage);
	result = m.replaceAll(user.getFirstName().concat(" "+user.getLastName()));
	template = new StringBuffer(result);

    }

}
