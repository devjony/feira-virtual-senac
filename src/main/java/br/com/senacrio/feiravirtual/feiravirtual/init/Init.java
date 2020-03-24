package br.com.senacrio.feiravirtual.feiravirtual.init;


import br.com.senacrio.feiravirtual.feiravirtual.controllers.SampleController;
import br.com.senacrio.feiravirtual.feiravirtual.domain.SampleDomain;
import br.com.senacrio.feiravirtual.feiravirtual.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(Init.class);

    @Autowired
    private SampleService sampleService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("Starting saving mock values on database");

        SampleDomain sampleDomain = new SampleDomain();
        sampleDomain.setAttributeName("Sample Attribute Name 1");
        sampleService.save(sampleDomain);

        sampleDomain = new SampleDomain();
        sampleDomain.setAttributeName("Sample Attribute Name 2");
        sampleService.save(sampleDomain);

        logger.info("Finishing saving mock values on database");
    }

}
