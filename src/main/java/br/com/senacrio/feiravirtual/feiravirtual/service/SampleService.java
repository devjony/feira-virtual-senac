package br.com.senacrio.feiravirtual.feiravirtual.service;

import br.com.senacrio.feiravirtual.feiravirtual.domain.SampleDomain;
import br.com.senacrio.feiravirtual.feiravirtual.repository.SampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    Logger logger = LoggerFactory.getLogger(SampleService.class);

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public List<SampleDomain> findAll() {
        logger.info("Finding all [SampleDomain] on Database");

        List<SampleDomain> allSampleDomain = this.sampleRepository.findAll();

        return allSampleDomain;
    }

    public SampleDomain save(SampleDomain sampleDomain) {
        logger.info("Saving [SampleDomain] on Database");

        SampleDomain sampleDomainFromDb = this.sampleRepository.save(sampleDomain);

        return sampleDomainFromDb;
    }
}
