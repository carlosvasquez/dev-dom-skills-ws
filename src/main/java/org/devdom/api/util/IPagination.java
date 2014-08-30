package org.devdom.api.util;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public interface IPagination {

    String PATTERN_REPLACE = "/page/+(\\d)*";

    String PATTERN_MATCH = "(?s).*\\/page/.*";
    
    String APPLICATION_JSON_FILE = ".json";
    
    String APPLICATION_XML_FILE = ".xml";
    
    String DEFAULT_APPLICATION_XML = "application/xml";
    
    String DEFAULT_APPLICATION_JSON = "application/json";
    
    String CAPTION_CURRENT = "Current page";
    
    String CAPTION_PREVIOUS = "Previous Page";

    String CAPTION_NEXT = "Next Page";
    
    String CAPTION_LAST = "Last Page";
    
    String CAPTION_FIRST = "First Page";
    
    int ROWS_PER_PAGE = 10;
    
}
