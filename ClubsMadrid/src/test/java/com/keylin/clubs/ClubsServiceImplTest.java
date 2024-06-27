package com.keylin.clubs.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.entities.common.Cathegory;
import com.keylin.clubs.exceptions.MessageError;
import com.keylin.clubs.exceptions.ServiceException;
import com.keylin.clubs.repositories.ClubRepository;
import com.keylin.clubs.services.ClubsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ClubsServiceImplTest {

    @Mock
    private ClubRepository clubRepository;

    @Mock
    private Logger logger;

    @InjectMocks
    private ClubsServiceImpl clubsService;


    @Test
    public void testListClubs_Exception() {
        // Arrange
        when(clubRepository.findAll()).thenThrow(new RuntimeException("Database connection error"));

        // Act & Assert
        ServiceException exception = org.junit.jupiter.api.Assertions.assertThrows(
                ServiceException.class,
                () -> clubsService.listClubs()
        );

        assertThat(exception.getMessage()).isEqualTo(MessageError.CLUBS_NOT_FOUND.getMessage());

        verify(logger).error("Exception");
        verify(clubRepository).findAll();
    }
}
