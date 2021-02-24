package gkumar_hw4.registration;
/* 

* Grey Kumar 

* CPSC 5002, Seattle University 

* This is free and unencumbered software released into the public domain. 

*/
import gkumar_hw4.enums.Building;
import gkumar_hw4.enums.Quarter;
import gkumar_hw4.person.Faculty;

/**
 * <p>The <strong>Section</strong> class holds information about a course section.</p>
 * <ul>
 * <li><strong>course:</strong> course associated with the section</li>
 * <li><strong>section:</strong> section number for the course</li>
 * <li><strong>instructor:</strong> instructor for the section (assume single instructor)</li>
 * <li><strong>term:</strong> quarter and year when the section is offered (see Quarter enum)</li>
 * <li><strong>capacity:</strong> capacity for the section</li>
 * <li><strong>location:</strong> building and room where the section is held (see Building enum)</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011-02: Object-Oriented Concepts</strong>
 * <ul>
 * <li><strong>course:</strong> CPSC 5011</li>
 * <li><strong>section:</strong> 02</li>
 * <li><strong>instructor:</strong> Sheila Oh</li>
 * <li><strong>term (quarter/year):</strong> FQ18</li>
 * <li><strong>capacity:</strong> 30</li>
 * <li><strong>location (building/room):</strong> LEML 122</li>
 * </ul>
 * 
 * @author Grey Kumar
 * @version 1.0
 */
public class Section {    
    
    /**
     * constructs the section object
     * 
     * 
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor, Quarter quarter, 
                    int year, int cap, Building bldg, int room) {
        
        crse = course;
        this.section = section;
        this.instructor = instructor;
        this.quarter = quarter;
        this.capacity = cap;
        this.bldg = bldg;
        this.year = year;
        this.room = room;
    }
    
    
    /**
     * constructs the string that consists of all the field variables
     * 
     * @return the string to be printed
     */
    public String toString() {
   	 return "Section: Course=" + crse.getCode() + "-" + crse.getNum() + "-" 
   			 + "0" + section + ": " + crse.getCourseName() + ", Faculty=" 
   			 + instructor.getName() + ", Term=" + quarter + " " + year 
   			 + ", Capacity=" + capacity + ", Room=" + bldg + " " + room;
    }

    
    private Course crse;// - course
    private int section;// - section
    private Faculty instructor;// - instructor
    private Quarter quarter;// - term (see Quarter)
    private int capacity;// - capacity
    private Building bldg;// - location (see Building)
    private int year;
    private int room;

}
