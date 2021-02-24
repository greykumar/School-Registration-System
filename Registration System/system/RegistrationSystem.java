package gkumar_hw4.system;

import java.util.HashMap;

import gkumar_hw4.enums.Building;
import gkumar_hw4.enums.FacultyType;
import gkumar_hw4.enums.Quarter;
import gkumar_hw4.enums.StudentProgram;
import gkumar_hw4.enums.StudentType;
import gkumar_hw4.enums.SubjectCode;
import gkumar_hw4.exception.CourseNotFoundException;
import gkumar_hw4.exception.DuplicateCourseException;
import gkumar_hw4.exception.DuplicatePersonException;
import gkumar_hw4.exception.DuplicateSectionException;
import gkumar_hw4.exception.DuplicateSubjectException;
import gkumar_hw4.exception.PersonNotFoundException;
import gkumar_hw4.person.Faculty;
import gkumar_hw4.person.Student;
import gkumar_hw4.registration.Course;
import gkumar_hw4.registration.Section;

/**
 * <p>
 * The <strong>RegistrationSystem</strong> class stores information about the
 * school, including the ability to add students, add faculty, add courses, and
 * add prerequisite(s).
 * </p>
 * 
 * @author ohsh
 */
public class RegistrationSystem {

	/**
	 * 
	 */
	public RegistrationSystem() {

		student = new HashMap<>();
		faculty = new HashMap<>();
		subject = new HashMap<>();
		course = new HashMap<>();
		section = new HashMap<>();
	}

	/**
	 * Add a student to the student list collection.
	 * 
	 * @param firstName The first name of the student
	 * @param lastName  The last name of the student
	 * @param type      The student type
	 * @param program   The student program
	 * @param quarter   The start quarter of the student
	 * @param year      The start year of the student
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addStudent(String firstName, String lastName, StudentType type,
			StudentProgram program, Quarter quarter, int year)
			throws DuplicatePersonException {
		
		if (student.containsKey(firstName + lastName)) {
			throw new DuplicatePersonException();
		}
		Student stu = new Student(firstName, lastName);
		stu.setType(type);
		stu.setProgram(program);
		stu.setTerm(quarter);
		stu.setYear(year);
		stu.genAdv();
		student.put(firstName + lastName, stu);


	}

	/**
	 * Add a faculty to the faculty list collection.
	 * 
	 * @param firstName The first name of the faculty
	 * @param lastName  The last name of the faculty
	 * @param type      The faculty type
	 * @param bldg      The building of the faculty office
	 * @param room      The (building) room of the faculty office
	 * @param email     The email of the faculty
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addFaculty(String firstName, String lastName, FacultyType type,
			Building bldg, int room, String email)
			throws DuplicatePersonException {
		
		if (getFaculty().containsKey(firstName + lastName)) {
			throw new DuplicatePersonException();
		}
		Faculty fac = new Faculty(firstName, lastName, email);
		fac.setType(type);
		fac.setBuilding(bldg);
		fac.setRoom(room);
		getFaculty().put(firstName + lastName, fac);

	}

	/**
	 * Adds a subject to the subject list collection. (hint: use a Map instead of
	 * creating a class)
	 * 
	 * @param code The subject code
	 * @param desc The subject description
	 * 
	 * @throws DuplicateSubjectException The subject is already in the system
	 */
	public void addSubject(SubjectCode code, String desc)
			throws DuplicateSubjectException {

		if (subject.containsKey(code)) {
			throw new DuplicateSubjectException();
		}
		subject.put(code, desc + " " + "(" + code.toString() + ")");

	}

	/**
	 * Adds a course to the course list collection.
	 * 
	 * @param code      The subject code of the course
	 * @param num       The course number of the course
	 * @param name      The course name
	 * @param creditNum The number of the credits of the course
	 * @throws DuplicateCourseException The course is already in the system
	 */
	public void addCourse(SubjectCode code, int num, String name, int creditNum)
			throws DuplicateCourseException {

		Course crse = new Course(code, num, name, creditNum);
		if (course.containsKey(code + "-" + num)) {
			throw new DuplicateCourseException();
		}
		course.put(code + "-" + num, crse);

	}

	/**
	 * Adds a prerequisite to an existing course in the course list collection.
	 * 
	 * @param code       The subject code of the course
	 * @param num        The course number of the course
	 * @param prereqCode The subject code of the prerequisite to add to the
	 *                   course
	 * @param prereqNum  The course number of the prerequisite to add to the
	 *                   course
	 * @throws CourseNotFoundException The course was not found in the system
	 */
	public void addPrerequisite(SubjectCode code, int num,
			SubjectCode prereqCode, int prereqNum) throws CourseNotFoundException {

		if (!course.containsKey(code + "-" + num)) {
			throw new CourseNotFoundException();
		} else
			course.get(code + "-" + num).getPrereq().add("Name=" + prereqCode + "-" 
		+ prereqNum + ": " + course.get(code + "-" + num).getCourseName());

	}

	/**
	 * Adds a section to the section list collection.
	 * 
	 * @param code       The subject code of the course
	 * @param courseNum  The course number of the course
	 * @param sectionNum The section number for the course
	 * @param firstName  The first name for the faculty teaching the course
	 * @param lastName   The last name for the faculty teaching the course
	 * @param quarter    The quarter that the course section is held
	 * @param year       The year that the course section is held
	 * @param cap        The capacity of the course section
	 * @param bldg       The building that the course section is held
	 * @param room       The room that the course section is held
	 * @throws CourseNotFoundException   The course was not found in the system
	 * @throws PersonNotFoundException   The person was not found in the system
	 * @throws DuplicateSectionException The section is already in the system
	 */
	public void addSection(SubjectCode code, int courseNum, int sectionNum,
			String firstName, String lastName, Quarter quarter, int year, int cap,
			Building bldg, int room) throws CourseNotFoundException,
			PersonNotFoundException, DuplicateSectionException {

		Section sec = new Section(course.get(code + "-" +courseNum), sectionNum,
				faculty.get(firstName + lastName), quarter, year, cap, bldg, room);
		if (!course.containsKey(code + "-" +courseNum)) {
			throw new CourseNotFoundException();
		} else if (!faculty.containsKey(firstName + lastName)) {
			throw new PersonNotFoundException();
		} else if (section.containsKey(code.toString()
				+ Integer.toString(courseNum) + Integer.toString(sectionNum))) {
			throw new DuplicateSectionException();
		}

		section.put(code.toString() + Integer.toString(courseNum)
				+ Integer.toString(sectionNum), sec);

	}

	/**
	 * returns the faculty hashMap
	 * @return faculty hashMap
	 */
	public static HashMap<String, Faculty> getFaculty() {
		return faculty;
	}

	/**
	 * returns the student hashMap
	 * @return student hashMap
	 */
	public HashMap<String, Student> getStudent() {
		return student;
	}

	/**
	 * returns the subject hashMap
	 * @return subject hashMap
	 */
	public HashMap<SubjectCode, String> getSubject() {
		return subject;
	}

	/**
	 * returns the course hashMap
	 * @return course hashMap
	 */
	public HashMap<String, Course> getCourse() {
		return course;
	}

	/**
	 *  returns the section hashMap
	 * @return section hashMap
	 */
	public HashMap<String, Section> getSection() {
		return section;
	}

	private HashMap<String, Student> student;// - student list
	private static HashMap<String, Faculty> faculty;// - faculty list
	private HashMap<SubjectCode, String> subject;// - subject list
	private HashMap<String, Course> course;// = course list
	private HashMap<String, Section> section;// = section list
	//
	// Note -- there is no list for prerequisites - these should be included
	// as part of the course list

}
