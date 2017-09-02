package com.example.springandtiles;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
/**
 * Handles requests for the application about page.
 */
@Controller
public class AboutController {
     
    private static final Logger logger = LoggerFactory.getLogger(AboutController.class);
     
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        logger.info("About page !");
         
        return "about";
    }
     
}