package br.com.senacrio.feiravirtual.feiravirtual.service;

import br.com.senacrio.feiravirtual.feiravirtual.domain.EventoDomain;
import br.com.senacrio.feiravirtual.feiravirtual.repository.EventoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    Logger logger = LoggerFactory.getLogger(EventoService.class);

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }
    
    public EventoDomain find(Integer id) throws ObjectNotFoundException {
    	logger.info("Finding [EventoDomain] id: " + id + "");
    	
    	Optional<EventoDomain> eventoDomain = eventoRepository.findById(id);
    	
    	logger.info("Returning [EventoDomain] id: " + id + "");
    	return eventoDomain.orElseThrow(() -> new ObjectNotFoundException(
    			"not found, id: " + id + "Tipe: " + EventoDomain.class.getName()));
    }

    public List<EventoDomain> findAll() {
        logger.info("Finding all [EventoDomain] on Database");

        List<EventoDomain> eventoDomainList = this.eventoRepository.findAll();

        logger.info("Returning [EventoDomain] List");
        return eventoDomainList;
    }

    public EventoDomain save(EventoDomain eventoDomain) {
        logger.info("Saving [EventoDomain] on Database");

        EventoDomain eventoDomainFromDb = this.eventoRepository.save(eventoDomain);

        logger.info("Returning [EventoDomain] saved on Database");
        return eventoDomainFromDb;
    }
    
    public EventoDomain update(EventoDomain eventoDomain) throws ObjectNotFoundException {
    	logger.info("Updating [EventoDomain] attributes");
    	
    	EventoDomain oldEventoDomain = find(eventoDomain.getId());
    	oldEventoDomain.setEventoTitulo(eventoDomain.getEventoTitulo());
    	oldEventoDomain.setEventoTipo(eventoDomain.getEventoTipo());
    	oldEventoDomain.setEventoDataInicio(eventoDomain.getEventoDataInicio());
    	oldEventoDomain.setEventoDataFim(eventoDomain.getEventoDataFim());
    	oldEventoDomain.setEventoLink(eventoDomain.getEventoLink());
    	oldEventoDomain.setEventoLinkBanner(eventoDomain.getEventoLinkBanner());
    	oldEventoDomain.setEventoVagas(eventoDomain.getEventoVagas());
    	
    	return save(oldEventoDomain);
    }
    
    public void delete(Integer id) {
    	logger.info("Deleting [EventoDomain], id: " + id);
    	eventoRepository.deleteById(id);
    }
}
