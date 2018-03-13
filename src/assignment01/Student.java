
package assignment01;
import java.time.LocalDate;
import java.time.Period;


public class Student {
    private String firstname, lastname, streetaddress, city, postalcode; 
    private LocalDate dateOfBirth, dateEnrolled;
    private int studentNum, yearborn;
    private boolean inGoodStanding;
    
    /**
     * These are the parameters for the constructor
     * @param firstname
     * @param lastname
     * @param streetaddress
     * @param city
     * @param postalcode
     * @param dateOfBirth
     * @param dateEnrolled
     * @param studentNum 
     */
    
    public Student(String firstname, String lastname, String streetaddress, String city, String postalcode,  LocalDate dateOfBirth, LocalDate dateEnrolled, int studentNum)
    {
        setFirstName(firstname);
        setLastName(lastname);
        setStreetAddress(streetaddress);
        setCity(city);
        setPostalCode(postalcode);
        setStudentNum(studentNum);
        setDateOfBirth(dateOfBirth);
        setDateEnrolled(dateEnrolled);
        inGoodStanding = true;
        
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
     * This method throws new IllegalArgumentException if  LastName is empty
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
     * This method throws new IllegalArgumentException if  Address is empty
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * This method validates the person is less than 100 years old.  
     * If the birthday does not appear to be valid, 
     * it should throw an IllegalArgumentException.
     * @param dateOfBirth 
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        
        if (age < 100)
            this.dateOfBirth = dateOfBirth;
        else
            throw new IllegalArgumentException("Age should be less than 100");
       
    }
    
    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }
    /**
     * This method should validate that the student was not enrolled in the future 
     * (i.e. the enrollment date is prior to the current date). 
     * If it is not a valid enrollment date throw an IllegalArgumentException.
     * @param dateEnrolled 
     */
    public void setDateEnrolled(LocalDate dateEnrolled) {
        
        LocalDate date = LocalDate.now();
        if(dateEnrolled.isAfter(date))
            throw new IllegalArgumentException("Date entered is invalid.");
        else
            
        this.dateEnrolled = dateEnrolled;
    }

    public int getStudentNum() {
        return studentNum;
    }
    /**
     * This method throws new IllegalArgumentException if student number is less than 0
     * @param studentNum 
     */
    public void setStudentNum(int studentNum) 
    {
        if(studentNum > 0)
        this.studentNum = studentNum;
        else 
            throw new IllegalArgumentException("Student number should be positive.");
    }    
    
    
  public int getYearBorn(){
      
      return dateOfBirth.getYear();
      
  }
   /**
    * returns true if the student is in good standing or false if they are in bad standing
    * @return 
    */
   public boolean isInGoodStanding()
   {
       return inGoodStanding;
       
   }
   /**
    * this sets their current “good standing” to be false
    */
   public void suspendStudent()
   {
       inGoodStanding = false;
       
   }
   /**
    * reinstate the student’s “good standing” to be true
    */
   public void reinstateStudent() 
   {
       inGoodStanding = true;
       
   }
   /**
    * returns the first name, last name and student number
    * @return 
    */
   @Override
    public String toString()
    {
        return firstname + " " + lastname + ", student number: " + studentNum;
    }
    
    /**
     * This method return the current age of the student (ensure this functions dynamically based on the current date)
     * @return 
     */
    public int getAge()
    {
         int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
         
         return age;
         
    }
    /**
     * returns the year the student enrolled at the college
     * @return 
     */
    public int getYearEnrolled(){
        
        return dateEnrolled.getYear();
        
        
    }
    
    
    
    
}
