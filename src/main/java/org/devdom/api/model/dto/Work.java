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
    @NamedStoredProcedureQuery( name="Work.search_developers_work", 
                                procedureName="search_developers_work",
                                returnsResultSet=true,
                                resultClass=Work.class,
                                parameters={@StoredProcedureParameter(queryParameter="name",
                                                                      name="name",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                )
})
public class Work implements Serializable {
    
    @Id
    @Column(name = "work_id")
    private long workId; 
    
    @Column(name = "work_institution")
    private String workInstitution;
    
    @Column(name = "employees")
    private short employees;

    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public String getWorkInstitution() {
        return workInstitution;
    }

    public void setWorkInstitution(String workInstitution) {
        this.workInstitution = workInstitution;
    }

    public short getEmployees() {
        return employees;
    }

    public void setEmployees(short employees) {
        this.employees = employees;
    }

}
