package org.devdom.api.model.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery( name="University.findAllUniversities", 
                                procedureName="findAllUniversities",
                                returnsResultSet=true,
                                resultClass=University.class
                                ),
    @NamedStoredProcedureQuery( name="University.findUniversityByDeveloperId", 
                                procedureName="findUniversityByDeveloperId",
                                returnsResultSet=true,
                                resultClass=University.class,
                                parameters={@StoredProcedureParameter(queryParameter="developer_id",
                                                                      name="developer_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="University.findUniversityById", 
                                procedureName="findUniversityById",
                                returnsResultSet=true,
                                resultClass=University.class,
                                parameters={@StoredProcedureParameter(queryParameter="university_id",
                                                                      name="university_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="University.search_developers_university", 
                                procedureName="search_developers_university",
                                returnsResultSet=true,
                                resultClass=University.class,
                                parameters={@StoredProcedureParameter(queryParameter="name",
                                                                      name="name",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                )
})
public class University implements Serializable {

    @Id
    @Column(name = "university_id")
    private long id;
    @Column(name = "university")
    private String name;
    @Column(name = "votes")
    private short votes;
    @Column(name = "link")
    private String link;
    @Column(name = "developers_count")
    private short developersCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the votes
     */
    public short getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(short votes) {
        this.votes = votes;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return "reports.xhtml?report=university-popular-skills&university-id="+getId()+"&university-title="+getName();
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    public short getDevelopersCount() {
        return developersCount;
    }

    public void setDevelopersCount(short developersCount) {
        this.developersCount = developersCount;
    }
    
}
