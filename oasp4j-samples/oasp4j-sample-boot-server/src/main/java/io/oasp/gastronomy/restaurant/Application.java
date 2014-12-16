package io.oasp.gastronomy.restaurant;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ImportResource({"classpath:config/app/beans-application.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {

        return new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {

                tomcat.addUser("chief", "chief");
                tomcat.addUser("waiter", "waiter");
                tomcat.addUser("barkeeper", "barkeeper");
                tomcat.addUser("cook", "cook");
                tomcat.addRole("chief", "Chief");
                tomcat.addRole("barkeeper", "Barkeeper");
                tomcat.addRole("cook", "Cook");
                tomcat.addRole("waiter", "Waiter");

                return super.getTomcatEmbeddedServletContainer(tomcat);
            }
        };
    }
}
