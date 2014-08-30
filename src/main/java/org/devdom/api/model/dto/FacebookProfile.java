package org.devdom.api.model.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Vasquez Polanco
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@XmlRootElement
public class FacebookProfile implements Serializable{
    
    /**
     * 
     */
    public enum Sex {
        MALE ("male","Hombre"),
        FEMALE ("female","Mujer");

        private final String id;
        private final String value;

        Sex(String id, String value){ this.id = id; this.value = value; }

        public String id(){ return id;}
        public String value(){ return value;}
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uid", length = 16)
    protected long uid;
    
    @Max(40) @NotNull
    @Column(name = "first_name", length = 40)
    protected String firstName;

    @Max(40)
    @Column(name = "last_name", length = 40)
    protected String lastName;
    
    @Column(name = "pic")
    protected String picture;
    
    @Column(name = "sex")
    protected Sex sex;
    
    @Column(name = "birthday_date")
    protected String birthdayDate;

    @Column(name = "email")
    protected String email;
    
    @Column(name= "current_location_id")
    protected String currentLocationId;
    
    @Column(name = "current_location")
    protected String currentLocation;
    
}
