package com.orangehrm.util;

public enum FilePaths {
	
	  CONFIG_FILE("src/test/resources/config.properties"),
	    EXCEL_DATA("src/test/resources/testdata.xlsx"),
	    LOG4J_CONFIG("src/test/resources/log4j2.xml"),
	    EXTENT_REPORTS("reports/ExtentReport.html");

	    private String path;

	    // Constructor
	    FilePaths(String path) {
	        this.path = path;
	    }

	    // Getter method to retrieve the path
	    public String getPath() {
	        return path;
	    }

}
