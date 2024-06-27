package com.keylin.clubs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.exceptions.MessageError;
import com.keylin.clubs.exceptions.ServiceException;
import com.keylin.clubs.repositories.ClubRepository;

@Service
public class CreateServiceImpl implements CreateService{
	//Logger
    private static final Logger log = LoggerFactory.getLogger(ClubsServiceImpl.class);
	
    //Injection of the clubRepository to use the methods created
	@Autowired
	private ClubRepository clubRepository;
	
	public Club saveClub(Club club) throws ServiceException{
		log.info("[saving Club]");
		log.debug("[Club: "+club.toString()+"]");		
		try{
			club =clubRepository.save(club);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServiceException(MessageError.CLUBS_NOT_FOUND);
		}
		return club;		
	}
	
	@Override
	public void deleteClub(Long id) throws ServiceException{
		log.info("[delete Club]");
		log.debug("[idClub: "+id+"]");
		
			try {
			clubRepository.deleteById(id);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServiceException(MessageError.CLUBS_NOT_FOUND);
		}
		
	}
}
