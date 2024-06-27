package com.keylin.clubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.entities.common.Cathegory;
import com.keylin.clubs.exceptions.MessageError;
import com.keylin.clubs.exceptions.ServiceException;
import com.keylin.clubs.repositories.ClubRepository;
import com.keylin.clubs.services.ClubsServiceImpl;

public class ClubsServiceImplTest {

    @Mock
    private ClubRepository clubRepository;

    @InjectMocks
    private ClubsServiceImpl clubsServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetListOfClubsCity_success() throws ServiceException {
        List<Club> expectedClubs = Arrays.asList(new Club(), new Club());
        when(clubRepository.findByCity("TestCity")).thenReturn(expectedClubs);

        List<Club> actualClubs = clubsServiceImpl.getListOfClubsCity("TestCity");

        assertEquals(expectedClubs, actualClubs);
    }

    @Test
    public void testGetListOfClubsCity_nullCity() {
        assertThrows(ServiceException.class, () -> {
            clubsServiceImpl.getListOfClubsCity(null);
        });
    }

    @Test
    public void testGetListOfClubsCity_repositoryException() {
        when(clubRepository.findByCity("TestCity")).thenThrow(new RuntimeException());

        assertThrows(ServiceException.class, () -> {
            clubsServiceImpl.getListOfClubsCity("TestCity");
        });
    }

    @Test
    public void testSearchForCathegory_success() throws ServiceException {
        List<Club> expectedClubs = Arrays.asList(new Club(), new Club());
        Cathegory cathegory = new Cathegory();
        when(clubRepository.findByCathegory(cathegory)).thenReturn(expectedClubs);

        List<Club> actualClubs = clubsServiceImpl.searchForCathegory(cathegory);

        assertEquals(expectedClubs, actualClubs);
    }

    @Test
    public void testSearchForCathegory_nullCathegory() {
        assertThrows(ServiceException.class, () -> {
            clubsServiceImpl.searchForCathegory(null);
        });
    }

    @Test
    public void testSearchForCathegory_repositoryException() {
        Cathegory cathegory = new Cathegory();
        when(clubRepository.findByCathegory(cathegory)).thenThrow(new RuntimeException());

        assertThrows(ServiceException.class, () -> {
            clubsServiceImpl.searchForCathegory(cathegory);
        });
    }

    @Test
    public void testListClubs_success() throws ServiceException {
        List<Club> expectedClubs = Arrays.asList(new Club(), new Club());
        when(clubRepository.findAll()).thenReturn(expectedClubs);

        List<Club> actualClubs = clubsServiceImpl.listClubs();

        assertEquals(expectedClubs, actualClubs);
    }

    @Test
    public void testListClubs_repositoryException() {
        when(clubRepository.findAll()).thenThrow(new RuntimeException());

        assertThrows(ServiceException.class, () -> {
            clubsServiceImpl.listClubs();
        });
    }
}
