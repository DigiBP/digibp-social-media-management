package ch.fhnw.digibp.config;

/**
 * Created by andreas.martin on 16.04.2017.
 */

import org.camunda.bpm.engine.rest.impl.CamundaRestResources;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/*
* JerseyResourceConfig fixes a BUG in CamundaJerseyResourceConfig
*/
@Configuration //This fixes a BUG in "camunda-bpm-spring-boot-starter-rest" when deploying as WAR on Tomcat
@ApplicationPath("/rest")
public class JerseyResourceConfig extends ResourceConfig implements InitializingBean {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JerseyResourceConfig.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Configuring camunda rest api.");
        this.registerClasses(CamundaRestResources.getResourceClasses());
        this.registerClasses(CamundaRestResources.getConfigurationClasses());
        this.register(JacksonFeature.class);
        log.info("Finished configuring camunda rest api.");
    }
}