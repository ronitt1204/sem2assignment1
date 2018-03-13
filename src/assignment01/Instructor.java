
package assignment01;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class Instructor {
    
    private String firstname, lastname, streetaddress, city, postalcode; 
    private LocalDate dateOfBirth, dateHired;
    private int employeeNum;
    private boolean canTeach;
    
    private ArrayList<String> Coursecode = new ArrayList<>();
    //Coursecode.add(new String("COMP1003"));
    /**
     * 
     * @param firstname
     * @param lastname
     * @param streetaddress
     * @param city
     * @param postalcode
     * @param dateHired
     * @param dateOfBirth
     * @param employeeNum 
     */
    
    public Instructor(String firstname, String lastname, String streetaddress, String city, String postalcode,  LocalDate dateHired,
                        LocalDate dateOfBirth, int employeeNum)
            
    {
        setFirstName(firstname);
        setLastName(lastname);
        setStreetAddress(streetaddress);
        setCity(city);
        setPostalCode(postalcode);
        setEmployeeNum(employeeNum);
        setBirthday(dateOfBirth);
        setHireDate(dateHired);
        
        canTeach=false;
    }

  
    
    public String getFirstName() {
        return firstname;
    }
    /**
     * This method throws new IllegalArgumentException if  FirstName is empty
     * @param firstname 
     */
    public void setFirstName(String firstname) {
        if(firstname.isEmpty())
            throw new IllegalArgumentException("First Name cannot be blank");
        this.firstname = firstname;
    }
    
    
    public String getLastName() {
        return lastname;
    }
    /**
     * This method throws new IllegalArgumentException if Last Name is empty
     * @param lastname 
     */
    public void setLastName(String lastname) {
        if(lastname.isEmpty())
            throw new IllegalArgumentException("Larst Name cannot be blank");
        this.lastname = lastname;
    }

    public String getStreetAddress() {
        return streetaddress;
    }
    /**
     * This method throws new IllegalArgumentException if Address is empty
     * @param streetaddress 
     */
    public void setStreetAddress(String streetaddress) {
        if(streetaddress.isEmpty())
            throw new IllegalArgumentException("Street Address cannot be blank");
        this.streetaddress = streetaddress;
    }

    public String getCity() {
        return city;
    }
    /**
     * This method throws new IllegalArgumentException if city is empty
     * @param city 
     */
    public void setCity(String city) {
        if(city.isEmpty())
            throw new IllegalArgumentException("City cannot be blank");
        this.city = city;
    }

    public String getPostalCode() {
        return postalcode;
    }
    
    /**
     * This method throws new IllegalArgumentException if postal code is empty
     * @param postalcode 
     */
    
    public void setPostalCode(String postalcode) {
        if(postalcode.isEmpty())
            throw new IllegalArgumentException("Postal-Code cannot be blank");
        this.postalcode = postalcode;
    }
    
    public LocalDate getBirthday() {
        return dateOfBirth;
    }
    /**
     * This will throw an exception if the age of person is more than 90
     * @param dateOfBirth 
     */
    public void setBirthday(LocalDate dateOfBirth) {
       LocalDate today = LocalDate.now();
        int age = Period.between(dateOfBirth, today).getYears();
        
        if (age < 90)
            this.dateOfBirth = dateOfBirth;
        else
            throw new IllegalArgumentException("Age should be less than 90");
       
    }
    /*
    This will return the date when the employee was hired
    */
    public LocalDate getHireDate() {
        return dateHired;
    }
    
    /**
     * This will throw an exception if after present date
     * @param dateHired 
     */
    public void setHireDate(LocalDate dateHired) {
        
        LocalDate date = LocalDate.now();
        if(dateHired.isAfter(date))
            throw new IllegalArgumentException("Date entered is invalid.");
        else
            
        this.dateHired = dateHired;
        
    }
    /*
    This will return the employee number
    */
    public int getEmployeeNum() {
        return employeeNum;
    }
    /**
     * This will throw an exception if the employee number is less than 0
     * @param employeeNum 
     */
    
    public void setEmployeeNum(int employeeNum) 
    {
        if(employeeNum > 0)
        this.employeeNum = employeeNum;
        else 
            throw new IllegalArgumentException("employee numbers must be greater than 0");
    }
        /*This method is to return the instructor's age  */
        public int getAgeInYears()
    {
         int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
         
         return age;
    }
        /*This method will return the number of years the instructor has worked at the college*/
        public int getYearsAtCollege()
        {
            int yearsatcollege = Period.between(dateHired, LocalDate.now()).getYears();
            return yearsatcollege;
        }
        /*this returns the year the Instructor was born*/
        public int getYearBorn(){
        
        return dateOfBirth.getYear();     
        
    }
        /**
         * This method accepts a course code as a String and 
         * adds it to the list of teachable subjects in UPPERCASE.  
         * If the course code is empty, it should throw an IllegalArgumentException.
         * @param coursecode 
         */
        public void addCourseToAbilities(String coursecode)
        {
            if(coursecode.isEmpty())
            throw new IllegalArgumentException("Coursecode cannot be blank");
            
            else
            Coursecode.add(coursecode.toUpperCase());
        }
        /**
         * This method accepts a String with a course code in it.
         * If the course code is in the list of courses an Instructor can teach,
         * it returns true, false otherwise.        
         * @param coursecode
         * @return 
         */
        public boolean canTeach(String coursecode) 
        {
            if(Coursecode.contains(coursecode))
            canTeach=true;
     
                return canTeach;           
        }
        
        /**
         * This returns a String with all the course codes an Instructor is certified to teach
         * @return 
         */         
        public String listOfSubjectsCertifiedToTeach() {
        String courseName = "";
        for(String course : Coursecode) {
            if(courseName.length() != 0) {
                courseName += ", ";
            }
            courseName += course;
        }
        return courseName;
    }
        
        /**
         * this returns the Instructor’s first and last name separated by a space
         * @return 
         */
        @Override
    public String toString()
    {
        return (firstname + " " + lastname);
    }
    
}
