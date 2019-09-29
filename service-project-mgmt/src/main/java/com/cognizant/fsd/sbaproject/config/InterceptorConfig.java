package com.cognizant.fsd.sbaproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cognizant.fsd.sbaproject.interceptor.RequestInterceptor;
/**
 * SwaggerConfig 
 * Generating Swagger API Documentation 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

	@Autowired
	RequestInterceptor requestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
	}

}