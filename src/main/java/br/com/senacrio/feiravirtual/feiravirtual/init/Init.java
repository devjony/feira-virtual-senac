package br.com.senacrio.feiravirtual.feiravirtual.init;

import br.com.senacrio.feiravirtual.feiravirtual.domain.EventoDomain;
import br.com.senacrio.feiravirtual.feiravirtual.domain.EventoTipoDomain;
import br.com.senacrio.feiravirtual.feiravirtual.repository.EventoRepository;
import br.com.senacrio.feiravirtual.feiravirtual.repository.EventoTipoRepository;
import br.com.senacrio.feiravirtual.feiravirtual.util.Strings;

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
    private EventoRepository eventoRepository;

    @Autowired
    private EventoTipoRepository eventoTipoRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    	logger.info("Starting saving mock values on database");

		EventoTipoDomain eventoTipoDomain = new EventoTipoDomain();
		eventoTipoDomain.setEventoTipoDescricao("Tipo 1");
		eventoTipoDomain.setEventoTipoStatus("Status 1");    		
    	eventoTipoRepository.save(eventoTipoDomain);
		
		EventoTipoDomain eventoTipoDomain2 = new EventoTipoDomain();
		eventoTipoDomain2.setEventoTipoDescricao("Tipo 2");
		eventoTipoDomain2.setEventoTipoStatus("Status 2");
		eventoTipoRepository.save(eventoTipoDomain2);
		
		EventoTipoDomain eventoTipoDomain3 = new EventoTipoDomain();
		eventoTipoDomain3.setEventoTipoDescricao("Tipo 3");
		eventoTipoDomain3.setEventoTipoStatus("Status 3");
		eventoTipoRepository.save(eventoTipoDomain3);
		
        EventoDomain eventoDomain = new EventoDomain();
        eventoDomain.setEventoTitulo("evento 1");
        eventoDomain.setEventoTipo(eventoTipoDomain);
        eventoDomain.setEventoDataInicio(Strings.parseDateTime("15/05/2020 04:00"));
        eventoDomain.setEventoDataFim(Strings.parseDateTime("22/05/2020 04:01"));
        eventoDomain.setEventoVagas(30);
        eventoDomain.setEventoLink("www.youtube.com.br");
        eventoDomain.setEventoLinkBanner("www.youtube.com.br");
        eventoDomain.setEventoStatus(1);;
        eventoRepository.save(eventoDomain);

        EventoDomain eventoDomain2 = new EventoDomain();
        eventoDomain2.setEventoTitulo("evento 2");
        eventoDomain2.setEventoTipo(eventoTipoDomain2);
        eventoDomain2.setEventoDataInicio(Strings.parseDateTime("03/05/2020 12:30"));
        eventoDomain2.setEventoDataFim(Strings.parseDateTime("03/05/2020 12:31"));
        eventoDomain2.setEventoVagas(22);
        eventoDomain2.setEventoLink("www.google.com.br");
        eventoDomain2.setEventoLinkBanner("www.google.com.br");
        eventoDomain2.setEventoStatus(1);;
        eventoRepository.save(eventoDomain2);
        
        EventoDomain eventoDomain3 = new EventoDomain();
        eventoDomain3.setEventoTitulo("evento 3");
        eventoDomain3.setEventoTipo(eventoTipoDomain3);
        eventoDomain3.setEventoDataInicio(Strings.parseDateTime("12/05/2020 09:45"));
		eventoDomain3.setEventoDataFim(Strings.parseDateTime("12/05/2020 09:46"));
        eventoDomain3.setEventoVagas(44);
        eventoDomain3.setEventoLink("www.netflix.com.br");
        eventoDomain3.setEventoLinkBanner("www.netflix.com.br");
        eventoDomain3.setEventoStatus(1);;
        eventoRepository.save(eventoDomain3);

        logger.info("Finishing saving mock values on database");
    }

}
