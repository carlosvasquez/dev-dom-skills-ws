package org.devdom.api.model.bean;

import java.util.List;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import org.devdom.api.model.dao.UniversityDao;
import org.devdom.api.model.dto.University;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@SessionScoped
@Named
public class UniversityController {

    private static final long serialVersionUID = 1L;
    private final UniversityDao dao = new UniversityDao();
    
    /**
     * Lista de universidades
     * @return 
     * @throws java.lang.Exception 
     */
    public List<University> getUniversities() throws Exception{
        return dao.findAllUniversities();
    }
}
