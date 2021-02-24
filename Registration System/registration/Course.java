package gkumar_hw4.registration;
/* 

* Grey Kumar 

* CPSC 5002, Seattle University 

* This is free and unencumbered software released into the public domain. 

*/
import java.util.ArrayList;

import gkumar_hw4.enums.SubjectCode;

/**
 * <p>
 * The <strong>Course</strong> class holds information about a course.
 * </p>
 * <ul>
 * <li><strong>subject code:</strong> subject code of the course (see
 * SubjectCode enum)</li>
 * <li><strong>course number:</strong> course number</li>
 * <li><strong>course name:</strong> course name</li>
 * <li><strong>credit number:</strong> number of credits associated with the
 * course</li>
 * <li><strong>prerequisites:</strong> courses that are prerequisites of this
 * course; may have multiple or none</li>
 * </ul>
 * <p>
 * For example, <strong>CPSC 5011: Object-Oriented Concepts</strong>
 * </p>
 * <ul>
 * <li><strong>subject code:</strong> CPSC</li>
 * <li><strong>course number:</strong> 5011</li>
 * <li><strong>course name:</strong> Object-Oriented Concepts</li>
 * <li><strong>credit number:</strong> 3</li>
 * <li><strong>prerequisite(s):</strong> CPSC 5003</li>
 * </ul>
 * 
 * @author Grey Kumar
 * @version 1.0
 */
public class Course {

	/**
	 * constructs the course object
	 * 
	 * @param code      The subject code of the course
	 * @param courseNum The course number of the course
	 * @param name      The course name
	 * @param creditNum The number of the credits of the course
	 */
	public Course(SubjectCode code, int courseNum, String name, int creditNum) {
		this.code = code;
		this.courseNumber = courseNum;
		this.courseName = name;
		this.creditNumber = creditNum;

	}

	/**
	 * returns the prerequisite for the course
	 * 
	 * @return the prereq for the course
	 */
	public ArrayList<String> getPrereq() {
		return prereq;
	}

	/**
	 * returns the course name
	 * 
	 * @return the name of the course
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * returns the subject code for the course
	 * 
	 * @return the subject code for the course
	 */
	public SubjectCode getCode() {
		return code;
	}
	
	/**
	 * returns the course number for the course
	 * 
	 * @return the course number for the course
	 */
	public int getNum () {
		return courseNumber;
	}

	/**
	 * returns the string that consists of the variables to be printed
	 * 
	 * @return the string to be printed
	 */
	public String toString() {
		return "Course: Name=" + code + "-" + courseNumber + ": " + courseName 
				+ ", Credits=" + creditNumber + ", Prerequisites=" 
				+ prereq.toString(); 
	}
	
	private SubjectCode code;// - subject code (see SubjectCode)
	private int courseNumber;// - course number
	private String courseName;// - course name
	private int creditNumber;// - credit number
	private ArrayList<String> prereq = new ArrayList<>();// - a collection of
																			// prerequisite
																			// course(s)

}
