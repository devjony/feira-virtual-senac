package br.com.senacrio.feiravirtual.feiravirtual.controllers;

import br.com.senacrio.feiravirtual.feiravirtual.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sample")
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @GetMapping
    public ModelAndView listAll(){
        logger.info("Request received on [GET][/sample]");

        ModelAndView mv = new ModelAndView("/sample/sample-list");
        mv.addObject("sampleDomainList", sampleService.findAll());

        logger.info("Returning view to the client");
        return mv;
    }

}
