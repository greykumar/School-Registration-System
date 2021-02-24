package gkumar_hw4.person;
/* 

* Grey Kumar 

* CPSC 5002, Seattle University 

* This is free and unencumbered software released into the public domain. 

*/
import gkumar_hw4.enums.Building;
import gkumar_hw4.enums.FacultyType;

/**
 * <p>
 * The <strong>Faculty</strong> class holds information about a faculty member.
 * </p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus
 * enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType
 * enum)</li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number
 * (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>
 * For example, faculty <strong>Sheila Oh</strong>
 * </p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 * 
 * @author Grey Kumar
 * @version 1.0
 */
public class Faculty extends Person {

	/**
	 * Constructs the faculty object using the parent class person
	 * 
	 * @param firstName the first name of the faculty
	 * @param lastName the last name of the faculty
	 * @param type the type of faculty
	 * @param bldg the building their office is in
	 * @param room the room their office is in
	 * @param email their email
	 */
	public Faculty(String firstName, String lastName, String email) {

		super(firstName, lastName, email);
		this.firstName = firstName;
		this.lastName = lastName;

	}

	/**
	 * sets the faculty type
	 * 
	 * @param type the faculty type enum
	 */
	public void setType(FacultyType type) {
		this.type = type;
	}
	
	/**
	 * sets the office building
	 * 
	 * @param bldg the building enum
	 */
	public void setBuilding(Building bldg) {
		this.bldg = bldg;
	}
	
	/**
	 * sets the office room
	 * 
	 * @param room the room enum
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	
	
	/**
	 * overrides the parent class toString and adds the rest of the required string
	 * 
	 * @return the string to be printed
	 */
	@Override
	public String toString() {
		return "Faculty: " + super.toString() + ", Type=" + type + ", Office="
				+ bldg + " " + room;
	}

	/**
	 * gets the name of the faculty member
	 * 
	 * @return the combined first and last name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	private String firstName;// - first name
	private String lastName;// - last name
	private FacultyType type;// - faculty type (see FacultyType)
	private Building bldg;// - office (see Building)
	private int room; //room

}
