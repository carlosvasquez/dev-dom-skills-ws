package org.devdom.api.util;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public interface IPagination {

    public final String PATTERN_REPLACE = "/page/+(\\d)*";

    public final String PATTERN_MATCH = "(?s).*\\/page/.*";
    
    public final String APPLICATION_JSON_FILE = ".json";
    
    public final String APPLICATION_XML_FILE = ".xml";
    
    public final String DEFAULT_APPLICATION_XML = "application/xml";
    
    public final String DEFAULT_APPLICATION_JSON = "application/json";
    
    public final String CAPTION_CURRENT = "Current page";
    
    public final String CAPTION_PREVIOUS = "Previous Page";

    public final String CAPTION_NEXT = "Next Page";
    
    public final String CAPTION_LAST = "Last Page";
    
    public final String CAPTION_FIRST = "First Page";
    
    public final int ROWS_PER_PAGE = 10;
    
}
