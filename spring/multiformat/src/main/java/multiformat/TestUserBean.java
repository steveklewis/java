package multiformat;

import java.util.Date;

public class TestUserBean
{
   private final String firstName = "John";
   private final String lastName = "Smith";
   private final String company="Test Company";
   private final String businessTitle="Test Employee";
   private final Date creationDate = new Date();
   private final Date modifiedDate = new Date();

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @return the businessTitle
     */
    public String getBusinessTitle() {
        return businessTitle;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }
   
   
}
