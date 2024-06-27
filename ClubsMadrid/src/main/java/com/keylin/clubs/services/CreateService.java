package com.keylin.clubs.services;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.exceptions.ServiceException;

public interface CreateService {
	public Club saveClub(Club club) throws ServiceException;
	public void deleteClub(Long id) throws ServiceException;
}
