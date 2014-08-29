package org.devdom.api.util;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public interface IPagination {

    public String PATTERN_REPLACE = "/page/+(\\d)*";

    public String PATTERN_MATCH = "(?s).*\\/page/.*";
    
    public String APPLICATION_JSON_FILE = ".json";
    
    public String APPLICATION_XML_FILE = ".xml";
    
    public String DEFAULT_APPLICATION_XML = "application/xml";
    
    public String DEFAULT_APPLICATION_JSON = "application/json";
    
    public String CAPTION_CURRENT = "Current page";
    
    public String CAPTION_PREVIOUS = "Previous Page";

    public String CAPTION_NEXT = "Next Page";
    
    public String CAPTION_LAST = "Last Page";
    
    public String CAPTION_FIRST = "First Page";
    
    public int ROWS_PER_PAGE = 10;
    
}
