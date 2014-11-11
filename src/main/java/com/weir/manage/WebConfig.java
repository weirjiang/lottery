package com.weir.manage;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.orm.hibernate3.support.OpenSessionInViewInterceptor;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.quidsi.core.platform.web.site.SiteSettings;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.weir" })
public class WebConfig extends WebMvcConfigurationSupport {
//    @Inject
//    EntityManagerFactory entityManagerFactory;
    @Inject
    EntityManagerFactory entityManagerFactory;
    
    


    @Bean
	public ViewResolver viewResolver() {
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//viewResolver.setViewClass(UrlBasedViewResolver.class);
		viewResolver.setSuffix(".jsp");
		viewResolver.setPrefix("/view/");
		viewResolver.setOrder(9);
		return viewResolver;
	}


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//    	OpenSessionInViewInterceptor interceptor= new OpenSessionInViewInterceptor();
        OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
        interceptor.setEntityManagerFactory(entityManagerFactory);
       registry.addWebRequestInterceptor(interceptor);
//        interceptor.setSessionFactory(sessionFactory);
    }
}
