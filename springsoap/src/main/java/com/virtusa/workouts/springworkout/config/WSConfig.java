package com.virtusa.workouts.springworkout.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WSConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);

        ServletRegistrationBean servletDef = new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");

        return servletDef;
    }
    @Bean
    public DefaultWsdl11Definition accountAddress() {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        //definition.setServiceName("accountAddress");
        definition.setPortTypeName("AccountPort");
        definition.setLocationUri("/account");
        definition.setTargetNamespace("http://springworkout.workouts.virtusa.com/");

        definition.setSchema(accountAddressServiceXsd());

        return definition;
    }
    @Bean
    public XsdSchema accountAddressServiceXsd()
    {
        return new SimpleXsdSchema(new ClassPathResource("schema/account.xsd"));
    }
}
