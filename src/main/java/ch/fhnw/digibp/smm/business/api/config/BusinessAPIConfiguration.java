package ch.fhnw.digibp.smm.business.api.config;

import ch.fhnw.digibp.config.JerseyResourceConfig;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by andreas.martin on 29.04.2017.
 */
@Configuration
public class BusinessAPIConfiguration {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JerseyResourceConfig.class);
    private ResourceConfig resourceConfig;

    public BusinessAPIConfiguration(ResourceConfig resourceConfig)
    {
        this.resourceConfig = resourceConfig;
        log.info("Configuring SMM Business API.");
        resourceConfig.packages("ch.fhnw.digibp.smm.business.api"); //Some demo API
        configureSwagger();
        log.info("Finished configuring SMM Business API.");
    }

    private void configureSwagger() {
        resourceConfig.register(ApiListingResource.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setBasePath(JerseyResourceConfig.class.getAnnotation(ApplicationPath.class).value());
        beanConfig.setTitle("SMM Business API");
        beanConfig.setDescription("SMM Business API");
        beanConfig.setVersion("1.0");
        beanConfig.setContact("Andreas Martin");
        beanConfig.setResourcePackage("ch.fhnw.digibp.smm.business.api");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }
}
