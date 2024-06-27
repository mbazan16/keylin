package com.keylin.clubs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.entities.common.Cathegory;
import com.keylin.clubs.exceptions.ServiceException;
import com.keylin.clubs.services.ClubsService;
import com.keylin.clubs.services.ClubsServiceImpl;


@Controller
@RequestMapping(value={"/clubs"})
public class ClubController {
	
	//Logger
    private static final Logger log = LoggerFactory.getLogger(ClubsServiceImpl.class);
	
    //Injection of the repository to use the business methods and connect 
	@Autowired
	private ClubsService clubsService;
	
	// Controllers
	
	@GetMapping
    public String showClubsIndex(Model model) throws ServiceException {

        log.info("Starting method showClubsIndex");
        
        try {
            log.debug("Getting the list of clubs");
            List<Club> clubsCity= clubsService.getListOfClubsCity(null);
            model.addAttribute("Clubs City", clubsCity);
            
            Cathegory cathegory = null; // O la lógica para obtener la matrícula
            log.debug("Getting the list of clubs filtered by cathegory");
            List<Club> searchXcathegory = clubsService.searchForCathegory(cathegory);
            model.addAttribute("searchXcathegory", searchXcathegory);
            
            List<Club> clubs = clubsService.listClubs();  		
    		model.addAttribute("list of clubs", clubs);	
    		
            log.info("Method showClubsIndex completed succesfully");
            return "clubindex";
        } catch (ServiceException e) {
            log.error("Error in the method showClubsIndex", e);
            throw e;
        }
    }

}
