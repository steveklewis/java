package multiformat.models;

import java.util.Date;

/**
 *
 * @author slewis
 */
public class TestBeachBean {
    private final String name = "Clearwater Beach";
    private final boolean ocean = false;
    private final boolean gulf = true;
    private final boolean peaceful = true;
    private final Date creationDate = new Date();
    private final Date modifiedDate = new Date();

    public String getName() {
        return name;
    }

    public boolean isOcean() {
        return ocean;
    }

    public boolean isGulf() {
        return gulf;
    }

    public boolean isPeaceful() {
        return peaceful;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
    
}
