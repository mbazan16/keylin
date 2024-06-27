package com.keylin.clubs.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.entities.common.Cathegory;
import com.keylin.clubs.exceptions.MessageError;
import com.keylin.clubs.exceptions.ServiceException;
import com.keylin.clubs.repositories.ClubRepository;

@Service
public class ClubsServiceImpl implements ClubsService{
	
	//Logger
    private static final Logger log = LoggerFactory.getLogger(ClubsServiceImpl.class);
	
    //Injection of the repository to use the methods created
	@Autowired
	private ClubRepository clubRepository;
	
	
	//The business logic of the methods: 
	
	//Service 1: get a list of Clubs filtered by the city
	@Override
	public List<Club> getListOfClubsCity(String city) throws ServiceException {
		
        log.info("[List of clubs filtered by the name of the city]");
        try {
            if (city == null) {
                throw new ServiceException(MessageError.EMPTY_SEARCH_EXCEPTION);
            }
            return clubRepository.findByCity(city);
        }catch(ServiceException se) {
        	log.error("ServiceException: {}", se.getMessage());
            throw se;
        }catch (Exception e) {
            log.error("Error trying to get the list of clubs by city", e);
            throw new ServiceException(MessageError.GENERAL_EXCEPTION);
        }
	}
	

	//Service 2: get a list of Clubs filtered by cathegory
	public List<Club> searchForCathegory(Cathegory cathegory) throws ServiceException {
        log.info("[Searching]");
        log.debug("[cathegory: {}]", cathegory);
        try {
            if (cathegory == null) {
                throw new ServiceException(MessageError.EMPTY_SEARCH_EXCEPTION);
            }
            return clubRepository.findByCathegory(cathegory);
        } catch (ServiceException ae) {
            log.error("ServiceException: {}", ae.getMessage());
            throw ae;
        } catch (Exception e) {
            log.error("Error trying to get the list of clubs by cathegory", e);
            throw new ServiceException(MessageError.GENERAL_EXCEPTION);
        }
    }
	
	//Service 3: get all the clubs
	@Override
	public List<Club> listClubs() throws ServiceException{
		log.info("[list Clubs]");		
		List<Club> clubs;	
		try {
			clubs= clubRepository.findAll();		
		}catch(Exception e) {
			log.error("Exception");
			throw new ServiceException(MessageError.CLUBS_NOT_FOUND);
		}
		return clubs;	
	}
	

	
}	
