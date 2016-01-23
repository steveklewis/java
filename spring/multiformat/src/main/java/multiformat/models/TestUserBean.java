package multiformat.models;

import java.util.Date;

public class TestUserBean
{
   private final String firstName = "John";
   private final String lastName = "Smith";
   private final String company="Test Company";
   private final String businessTitle="Test Employee";
   private final Date creationDate = new Date();
   private final Date modifiedDate = new Date();   

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
}
