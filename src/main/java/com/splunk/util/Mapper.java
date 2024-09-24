package com.splunk.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mapper {

    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(Mapper.class);

    // Private constructor to prevent instantiation
    private Mapper() {
        // Hide the implicit public constructor
    }

    public static String mapToJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Failed to convert object to JSON string", e);
        }
        return null;
    }
}
