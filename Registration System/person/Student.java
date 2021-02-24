package gkumar_hw4.person;
/* 

* Grey Kumar 

* CPSC 5002, Seattle University 

* This is free and unencumbered software released into the public domain. 

*/
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import gkumar_hw4.enums.Quarter;
import gkumar_hw4.enums.StudentProgram;
import gkumar_hw4.enums.StudentType;
import gkumar_hw4.enums.StudentYear;
import gkumar_hw4.system.RegistrationSystem;

/**
 * <p>The <strong>Student</strong> class holds information about a student.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the student</li>
 * <li><strong>last name:</strong> last name of the student</li>
 * <li><strong>suid:</strong> Seattle U identification number</li>
 * <li><strong>status:</strong> the status of the student (see PersonStatus enum)</li>
 * <li><strong>student type:</strong> a student can only be assigned a single student type
 *   (see StudentType enum)</li>
 * <li><strong>student program:</strong> a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)</li>
 * <li><strong>student year:</strong> only relevant for undergraduates (see StudentYear enum)</li>
 * <li><strong>start term:</strong> associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)</li>
 * <li><strong>faculty advisor:</strong> students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, student <strong>Ada Lovelace</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Ada</li>
 * <li><strong>last name:</strong> Lovelace</li>
 * <li><strong>suid:</strong> 100027</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> GRAD</li>
 * <li><strong>student program:</strong> CERT</li>
 * <li><strong>student year:</strong> </li>
 * <li><strong>start term:</strong> FQ 2018</li>
 * <li><strong>faculty advisor:</strong> Lin Li</li>
 * <li><strong>email:</strong> adalovelace@seattleu.edu</li>
 * </ul>
 * <p>And student <strong>Buster Bluth</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Buster</li>
 * <li><strong>last name:</strong> Bluth</li>
 * <li><strong>suid:</strong> 100020</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> UNDERGRAD</li>
 * <li><strong>student program:</strong> BSCS</li>
 * <li><strong>student year:</strong> SOPHOMORE</li>
 * <li><strong>start term:</strong> WQ 2018</li>
 * <li><strong>faculty advisor:</strong> Roshanak Roshandel</li>
 * <li><strong>email:</strong> busterbluth@seattleu.edu</li>
 * </ul>
 * 
 * @author Grey Kumar
 * @version 1.0
 */
public class Student extends Person{

 
	/**
	 * constructs the student object using the parent class person
	 * 
	 * @param firstName the first name of the student	
	 * @param lastName the last name of the student
	 */
    public Student(String firstName, String lastName) {
   	 
   	 super(firstName, lastName, genEmail(firstName, lastName));
    }
    
    /**
     * Sets the student type
     * 
     * @param type the type enum
     */
    public void setType(StudentType type) {
   	 this.type = type;
    }
    
    /**
     * sets the student program
     * 
     * @param program the program enum
     */
    public void setProgram(StudentProgram program) {
   	 this.program = program;
    }
    
    /**
     * sets the student term
     * 
     * @param quarter the quarter enum
     */
    public void setTerm(Quarter quarter) {
   	 this.term = quarter;
    }
    
    /**
     * sets the student year
     * 
     * @param year the int year
     */
    public void setYear(int year) {
   	 this.year = year;
   	 calcYear(year);
    }
    
    /**
     * Prints each field of the student object
     * 
     */
    @Override
    public String toString() {
   	 if (type.equals(StudentType.GRAD)) {
   		 return "Student: " + super.toString() + ", Type=" + type 
   				 + ", Program=" + program + ", Term=" + term + " " + year 
   				 + ", Advisor=" + advisor;
   	 } else
   		 return "Student: " + super.toString() + ", Type=" + type 
   				 + ", Program=" + program + ", Term=" + term + " " + year
   				 + ", Advisor=" + advisor + ", Year=" + studentYear;
    }
    
    /**
     * generates the email for the student using a combination of the first 
     * and last name
     * 
     * @param first the first name of the student
     * @param last the last name of the student
     * @return the email of the student 
     */
    private static String genEmail(String first, String last) {
   	 String email = first + last + "@seattleu.edu";
   	 String emailLower = email.toLowerCase();
   	 return emailLower;
    }
    
    /**
     * randomly generates an advisor based off the faculty in the system
     * 
     */
    public void genAdv() {
   	 Random rand = new Random();
   	 ArrayList<Faculty> arr = new ArrayList<>();
   	 for (String key : RegistrationSystem.getFaculty().keySet()) {
   		 arr.add(RegistrationSystem.getFaculty().get(key));
   	 }
   	 this.advisor = arr.get(rand.nextInt(arr.size())).getName();
    }

    /**
     * calculates the current year of the student based off the current calendar 
     * year and the year the student started
     * 
     * @param startYear the year the student started
     */
    private void calcYear (int startYear) {
   	 int year = Calendar.getInstance().get(Calendar.YEAR);
   	 studentYear = StudentYear.values()[year - startYear];
    }
    
    
    private StudentType type;// - student type (see StudentType)
    private StudentProgram program;// - student program (see StudentProgram)
    private StudentYear studentYear;// - student year (see StudentYear; only if undergrad––default to freshman)
    private Quarter term;// - start term (see Quarter)
    private int year; //year
    private String advisor;//faculty advisor


}
