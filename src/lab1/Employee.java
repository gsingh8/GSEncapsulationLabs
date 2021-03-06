package lab1;

import java.util.Date;

/**
 * In this lab your challenge is to fix the code in both classes to use
 * proper encapsulation and the four other best practices as explained by 
 * your instructor.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.01
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;

    public Employee() {
     
    }
    
    
    public void completeAdministrative(String cubeId){
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    }
           
    
    public void setFirstName(String name){
        // Very basic validation
        // more validation needed
        if(name.length() <=0 ){
            throw new IllegalArgumentException("First Name is illegal");
        }
        this.firstName = name;
    };
    
    public void setLastName(String name){
        // Very basic validation
        // more validation needed
        if(name.length() <=0 ){
            throw new IllegalArgumentException("Last Name is illegal");
        }
        this.lastName = name;
    };
    
    public void setSSN(String ssn){
        // Very basic validation
        // more validation needed
        if (ssn.length() < 9){
            throw new IllegalArgumentException("SSN is too short");
        }
        this.ssn = ssn;
    };
    
    public void setDate(Date date){
        // Very basic validation
        // more validation needed
        if(date == null){
            throw new IllegalArgumentException("Date is illegal");
        }
    }

    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalryInfo() {
        
        metWithHr = true;
    }

    // Assume this is must be performed second
    private void meetDepartmentStaff() {
        if(metWithHr) {
            metDeptStaff = true;
        } else {
            throw new IllegalStateException("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies() {
        if(metWithHr && metDeptStaff) {
            reviewedDeptPolicies = true;
        } else {
            throw new IllegalStateException("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    private void moveIntoCubicle(String cubeId) {
        if(metWithHr && metDeptStaff && reviewedDeptPolicies) {
            
            //validate cube id
            this.cubeId = cubeId;
            this.movedIn = true;
        } else {
            throw new IllegalStateException("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }

    }

    public String getStatus() {
        if(metWithHr && metDeptStaff
           && reviewedDeptPolicies && movedIn) {
            return "Orientation is complete";
        } else {
            return "Orientation in progress...";
        }
    }
}
