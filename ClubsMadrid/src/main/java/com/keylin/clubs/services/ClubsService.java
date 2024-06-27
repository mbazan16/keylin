package com.keylin.clubs.services;

import java.util.List;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.entities.common.Cathegory;
import com.keylin.clubs.exceptions.ServiceException;

public interface ClubsService {
	public List<Club> getListOfClubsCity(String city) throws ServiceException;
	public List<Club> searchForCathegory(Cathegory cathegory) throws ServiceException;
	public List<Club> listClubs() throws ServiceException;
}
