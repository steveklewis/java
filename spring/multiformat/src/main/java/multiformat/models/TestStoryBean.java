package multiformat.models;

import java.util.Date;

public class TestStoryBean {

    private String headline = "Test Headline";
    private TestUserBean author = new TestUserBean();
    private String body = "Story Body: Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
    private Date modifiedDate = new Date();
    private Date createdDate = new Date();
    private int position = 15;
    private boolean published = false;

    public String getHeadline() {
        return headline;
    }

    public TestUserBean getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public int getPosition() {
        return position;
    }

    public boolean isPublished() {
        return published;
    }
}
