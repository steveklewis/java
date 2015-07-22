package multiformat.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import multiformat.models.TestStoryBean;
import multiformat.models.TestUserBean;

/**
 *
 * @author slewis
 */
public class BeanExporter {

    public void exportBean(IDataExporter dataExporter, String type) {                               
        if ("story".equals(type)) {

            TestStoryBean bean = new TestStoryBean();
            dataExporter.addColumn("Author Business Title",
                    "Author Company",
                    "Author Creation Date",
                    "Author First Name",
                    "Author Last Name",
                    "Author Modified Date",
                    "Body",
                    "Created Date",
                    "Headline",
                    "Modified Date",
                    "Position");
            dataExporter.addRow(bean.getAuthor().getBusinessTitle(),
                    bean.getAuthor().getCompany(),
                    getISODateStr(bean.getAuthor().getCreationDate()),
                    bean.getAuthor().getFirstName(),
                    bean.getAuthor().getLastName(),
                    getISODateStr(bean.getAuthor().getModifiedDate()),
                    bean.getBody(),
                    getISODateStr(bean.getCreatedDate()),
                    bean.getHeadline(),
                    getISODateStr(bean.getModifiedDate()),
                    bean.getPosition());

        } else if ("user".equals(type)) {
            TestUserBean bean = new TestUserBean();
            dataExporter.addColumn("User Business Title",
                    "User Company",
                    "User Creation Date",
                    "User First Name",
                    "User Last Name",
                    "User Modified Date");
            dataExporter.addRow(bean.getBusinessTitle(),
                    bean.getCompany(),
                    getISODateStr(bean.getCreationDate()),
                    bean.getFirstName(),
                    bean.getLastName(),
                    getISODateStr(bean.getModifiedDate()));

        } else {
            dataExporter.addColumn("ERROR");
            dataExporter.addRow("Unrecognized type: " + type);
        }
    }
    
    private String getISODateStr(Date input) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        df.setTimeZone(tz);
        return df.format(input);
    }
}
