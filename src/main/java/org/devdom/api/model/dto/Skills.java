package org.devdom.api.model.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

/**
 * Clase Skills.
 * 
 * @author      Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery( name="Skills.findSkillsByCategoryId", 
                                procedureName="findSkillsByCategoryId",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="category_id",
                                                                      name="category_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Skills.findSkillsById", 
                                procedureName="findSkillsById",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="skill_id",
                                                                      name="skill_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Skills.findSkillsByDeveloperId", 
                                procedureName="findSkillsByDeveloperId",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="developer_id",
                                                                      name="developer_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Skills.findAllSkills",
                                procedureName="findAllSkills",
                                returnsResultSet=true,
                                resultClass=Skills.class
                                ),
    @NamedStoredProcedureQuery( name="Skills.findAllSkillsByTopFilters", 
                                procedureName="findAllSkillsByTopFilters",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="category_id",
                                                                      name="category_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class),
                                            @StoredProcedureParameter(queryParameter="votes_gt",
                                                                      name="votes_gt",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class),
                                            @StoredProcedureParameter(queryParameter="limit",
                                                                      name="limit",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Skills.findPopularLanguagesByUniversityId", 
                                procedureName="findPopularLanguagesByUniversityId",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="university_id",
                                                                      name="university_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Skills.findPopularSkillsByUniversityId", 
                                procedureName="findPopularSkillsByUniversityId",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="university_id",
                                                                      name="university_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Skills.search_skill", 
                                procedureName="search_skill",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="name",
                                                                      name="name",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                )
})
public class Skills implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "option_id")
    private long id;

    @Column(name = "skill")
    private String skill;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "votes")
    private short votes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getVotes() {
        return votes;
    }

    public void setVotes(short votes) {
        this.votes = votes;
    }

}
