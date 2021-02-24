package gkumar_hw4.person;
/* 

* Grey Kumar 

* CPSC 5002, Seattle University 

* This is free and unencumbered software released into the public domain. 

*/
import gkumar_hw4.enums.PersonStatus;

/**
 * Parent class for both the Student and the Faculty classes. Generates the 
 * SUID and provides a toString base method.
 * 
 * @author Grey Kumar
 * @version 1.0
 */
public class Person {

	/**
	 * Constructs the parent object person
	 * 
	 * @param firstName the first name of the individual
	 * @param lastName the last name of the individual
	 * @param email the email of the individual
	 */
	public Person(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.SUID = idCounter++;
		status = initial;
	}

	/**
	 * returns a base toString for the two sub classes to use
	 * 
	 * @return the string to print
	 */
	public String toString() {
		return"Name=" + firstName + " " + lastName + ", SUID=" + SUID 
				+ ", Email=" + email + ", Status=" + status;
	}
	
   private String firstName;// - first name
   private String lastName;// - last name
   private int SUID; //SUId
   private static int idCounter = 100000; //Counter
   private String email; //email
   private PersonStatus status; //status
   private final PersonStatus initial = PersonStatus.ACTIVE;// - status (see PersonStatus)
}
