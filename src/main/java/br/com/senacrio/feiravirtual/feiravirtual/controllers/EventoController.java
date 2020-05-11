package br.com.senacrio.feiravirtual.feiravirtual.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senacrio.feiravirtual.feiravirtual.domain.EventoDomain;
import br.com.senacrio.feiravirtual.feiravirtual.service.EventoService;
import br.com.senacrio.feiravirtual.feiravirtual.service.EventoTipoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/evento")
public class EventoController {

    Logger logger = LoggerFactory.getLogger(EventoController.class);

    @Autowired
    private EventoService eventoService;
    
    @Autowired
    private EventoTipoService eventoTipoService;

    @GetMapping("/listar")
    public ModelAndView listAll(){
        logger.info("Request received on [GET][/evento]");

        ModelAndView mv = new ModelAndView("/evento/listar_evento");
        mv.addObject("eventoDomainList", eventoService.findAll());
        mv.addObject("eventoDomain", new EventoDomain());

        logger.info("Returning view to the client");
        return mv;
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView create() {
    	logger.info("Request received on [GET][/evento/cadastrar]");
    	
    	ModelAndView mv = new ModelAndView("/evento/cadastrar_evento");
    	mv.addObject("eventoDomain", new EventoDomain());
    	mv.addObject("eventoTipoDomainList", eventoTipoService.findAll());
    	
    	logger.info("Returning view to the client");
    	return mv;
    }
    
    @PostMapping("/salvar")
    public String save(EventoDomain eventoDomain) {
    	logger.info("Request received on [GET][/evento/salvar]");
    	
    	eventoService.save(eventoDomain);
    	
    	logger.info("Returning view to the client");
    	return "redirect:/evento/listar";
    }
    
    @GetMapping("/atualizar/{id}")
    public ModelAndView updateEvento(@PathVariable("id") Integer id) throws ObjectNotFoundException {
    	logger.info("Request received on [GET][/evento/atualizar/" + id + "]" );
    	
    	ModelAndView mv = new ModelAndView("/evento/atualizar_evento");
    	mv.addObject("eventoDomain", eventoService.find(id));
    	mv.addObject("eventoTipoDomainList", eventoTipoService.findAll());
    	
    	logger.info("Returning view to the client");
    	return mv;
    }
    
    @PostMapping("/atualizar")
    public String update(EventoDomain eventoDomain) throws ObjectNotFoundException {
    	logger.info("Request received on [POST][/evento/update]");
    	eventoService.update(eventoDomain);
    	
    	return "redirect:/evento/listar";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
    	logger.info("Request received on [GET][/evento/delete/{id}]");
    	
    	eventoService.delete(id);
    	
    	logger.info("Returning view to the client");
    	return "redirect:/evento/listar";
    }
}