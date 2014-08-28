package org.devdom.api.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import org.devdom.api.model.dto.Resource;
import org.devdom.api.util.IResource;

/**
 *
 * @author Carlos Vásquez
 */
@SessionScoped
@Named
public class ServiceResources implements Serializable{

    private static final long serialVersionUID = 1L;
    private final List<Resource> resource;

    public ServiceResources(){
        resource = new ArrayList<>();
        
        for(int id =0;id < IResource.URI.length;id++){
            resource.add(
                    new Resource(id,
                                IResource.finalURL(IResource.API_PATH+IResource.URI[id]),
                                IResource.URI[id],
                                IResource.getTag(IResource.URI[id]),
                                IResource.DESCRIPTION[id]));
        }
    }

    public List<Resource> getResources(){
        return resource;
    }

}