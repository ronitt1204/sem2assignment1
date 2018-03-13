
package assignment01;

import java.util.ArrayList;


public class Course {
    
   private String courseCode,courseName, room;
    private int maxStudents;
    private Instructor instructor;
    private ArrayList<Student> Student = new ArrayList<>();
    private boolean space=true;
   /**
    * 
    * @param instructor
    * @param courseCode
    * @param courseName
    * @param room
    * @param maxStudents 
    */

    public Course(Instructor instructor, String courseCode, String courseName, String room, int maxStudents) {
        setCourseCode(courseCode);
        setInstructor(instructor);        
        setCourseName(courseName);
        setRoom(room);
        setMaxStudents(maxStudents);
        
    }

    public String getCourseCode() {
        return courseCode;
    }
    /**
     * This method throws new IllegalArgumentException if variable courseCode is empty
     * @param courseCode 
     */

    public void setCourseCode(String courseCode) {
        if(courseCode.isEmpty())
            throw new IllegalArgumentException("Course Code cannot be blank");
        else
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        
        return courseName;
    }
    /**
     * This method throws new IllegalArgumentException if variable courseName is empty
     * @param courseName 
     */
    public void setCourseName(String courseName) {
        if(courseName.isEmpty())
            throw new IllegalArgumentException("Course Name cannot be blank");
        else
        this.courseName = courseName;
    }

    public String getRoom() {
        return room;
    }
    /**
     * This method throws new IllegalArgumentException if variable room is empty
     * @param room 
     */
    public void setRoom(String room) {
        if(room.isEmpty())
            throw new IllegalArgumentException("Room cannot be blank");
        else
        this.room = room;
    }

    public int getMaxStudents() {
        return maxStudents;
    }
/**
 * this method accepts an integer as an argument. 
 * The argument is validated to be less than or equal to 45 and above 0. 
 * If the number is outside that range, an IllegalArgumentException should be thrown
 * otherwise the instance variable should be set.
 * @param maxStudents 
 */
    public void setMaxStudents(int maxStudents) {
        if(maxStudents>0 && maxStudents<=45)
        this.maxStudents = maxStudents;
        
        else
            throw new IllegalArgumentException("Number must be betwenn 0 and 45");
    }

    public Instructor getInstructor() {
        return instructor;
    }
/**
 * this method accepts an Instructor as an argument.
 * If the course code is within the Instructors teachable subjects, 
 * then it set the Instructor otherwise throw an IllegalArgumentException.
 * @param instructor 
 */
    public void setInstructor(Instructor instructor) {
        
        if(instructor.canTeach(courseCode))
        this.instructor = instructor;
        
        else
            throw new IllegalArgumentException("Intructor not eligible to teach");
    }
    /**
     * this accepts a Student as an argument.  
     * It checks if the student is currently in good standing AND if there is space in the class. 
     * If a student cannot be added, it should throw an exception.
     * @param student 
     */
    public void addStudent(Student student)
    {
        if(Student.size()< maxStudents && student.isInGoodStanding()==true )
        Student.add(student);
        
        else
            throw new IllegalArgumentException("Can't add students");
    }
    /**
     * returns an ArrayList of Student objects enrolled in the course
     * @param student
     * @return 
     */
    public ArrayList<Student> getStudents()
    {
        return Student;
    }
    /**
     * This method returns the course name and course code as a String
     * @return 
     */
    
    
    @Override
    public String toString()
    {
        return (courseName + " " + courseCode);
    }
    /**
     * this method will print the names of each student registered in the class to the screen. 
     * There should be 1 student per line.
     */
    public void showClassList()
    {
        for(Student student:Student)
        System.out.printf("%s %s %n",student.getFirstName(),student.getLastName());
         
    }
    
}
