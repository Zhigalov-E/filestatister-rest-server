package com.myapp.server.restservices.config;

import com.myapp.server.restservices.endpoint.FileStatisticRestService;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(LoggingFeature.class);


		register(FileStatisticRestService.class);
	}
}
