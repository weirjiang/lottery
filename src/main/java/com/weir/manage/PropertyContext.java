package com.weir.manage;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.weir.util.RuntimeIOException;

	public class PropertyContext extends PropertySourcesPlaceholderConfigurer {
	    private Properties allProperties;

	    public void loadAllProperties() {
	        try {
	            allProperties = mergeProperties();
	        } catch (IOException e) {
	            throw new RuntimeIOException(e);
	        }
	    }

	    public Properties getAllProperties() {
	        Properties properties = new Properties();
	        properties.putAll(allProperties);
	        return properties;
	    }
	}
