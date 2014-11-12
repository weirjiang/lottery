package com.weir.manage;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class DefaultAppConfig {
    @Inject
    private ConfigurableEnvironment environment;

    @Bean
    static PropertyContext propertyContext() throws IOException {
        PropertyContext propertySource = new PropertyContext();
        propertySource.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:*.properties"));
        propertySource.loadAllProperties();
        return propertySource;
    }

    @PostConstruct
    void configureEnvironment() throws IOException {
        environment.setIgnoreUnresolvableNestedPlaceholders(true);
        Properties properties = propertyContext().getAllProperties();
        environment.getPropertySources().addLast(new PropertiesPropertySource("properties", properties));
    }

    @Bean
    Messages messages() throws IOException {
        Resource[] messageResources = new PathMatchingResourcePatternResolver().getResources("classpath*:messages/*.properties");
        Messages messages = new Messages();
        String[] baseNames = new String[messageResources.length];
        for (int i = 0, messageResourcesLength = messageResources.length; i < messageResourcesLength; i++) {
            Resource messageResource = messageResources[i];
            String filename = messageResource.getFilename();
            baseNames[i] = "messages/" + filename.substring(0, filename.indexOf('.'));
        }
        messages.setBasenames(baseNames);
        return messages;
    }

//    @Bean
//    ManagedServiceApplicationListener managedServiceApplicationListener() {
//        return new ManagedServiceApplicationListener();
//    }

    @Bean
    SpringObjectFactory springObjectFactory() {
        return new SpringObjectFactory();
    }

//    @Bean
//    ActionLoggerImpl actionLogger() {
//        return ActionLoggerImpl.get();
//    }

//    @Bean
//    ErrorHandler errorHandler() {
//        return new ErrorHandler();
//    }

//    @Bean
//    public ExceptionMonitor exceptionMonitor() {
//        return new ExceptionMonitor();
//    }

//    @Bean
//    public RecentExceptions recentExceptions() {
//        return new RecentExceptions();
//    }
//
//    @Bean
//    MonitorManager monitorManager() {
//        return new MonitorManager();
//    }
//
//    @Bean
//    public RuntimeSettings runtimeSettings() {
//        return RuntimeSettings.get();
//    }
//
//    @Bean
//    public LogSettings logSettings() {
//        return LogSettings.get();
//    }
//
//    @Bean
//    SchedulerImpl scheduler() {
//        return new SchedulerImpl();
//    }
//
//    @Bean
//    ServerStatus serverStatus() {
//        return new ServerStatus();
//    }
//
//    @Bean
//    JobStatistic jobStatistic() {
//        return new JobStatistic();
//    }

//    @Bean
//    PerformanceStatistics performanceStatistics() {
//        return new PerformanceStatistics();
//    }
}
