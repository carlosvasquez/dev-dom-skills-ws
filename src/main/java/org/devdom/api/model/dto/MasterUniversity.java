package org.devdom.api.model.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
public class MasterUniversity implements Serializable {
    @Id
    private Long id;

    @OneToMany
    private List<Developer> developers;

    @OneToMany
    private List<University> university;
    
    @OneToOne
    private Pagination pagination;
    
    public Long getId() {
        return id;
    }
    
    /**
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
    
    /**
     * @return the developers
     */
    public List<Developer> getDevelopers() {
        return developers;
    }

    /**
     * @param developers the developers to set
     */
    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    /**
     * @return the university
     */
    public List<University> getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(List<University> university) {
        this.university = university;
    }
    
}
