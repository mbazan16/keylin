package com.keylin.clubs.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.entities.common.Cathegory;
import com.keylin.clubs.exceptions.ServiceException;
import com.keylin.clubs.services.ClubsServiceImpl;
import com.keylin.clubs.services.CreateService;

@Controller
public class CreateController {
	
	//Logger
    private static final Logger log = LoggerFactory.getLogger(ClubsServiceImpl.class);
	
    //Injection of the repository to use the business methods and connect 

            
            @Autowired
            private CreateService createService;

            @GetMapping("/club-form")
            public String showForm(Model model) {
                log.info("Starting method showForm");

                model.addAttribute("club", new Club());
                model.addAttribute("categories", Cathegory.values());
                return "club-form";
            }

            @PostMapping("/submit-club")
            public String submitForm(Club club) throws ServiceException {
                log.info("Starting method submitForm");
                createService.saveClub(club);
                return "redirect:/clubindex";
            }
        }
 
