package com.keylin.clubs.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import com.keylin.clubs.exceptions.MessageError;
import com.keylin.clubs.exceptions.ServiceException;
import com.keylin.clubs.repositories.ClubRepository;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ClubsServiceImplTest {

    @Mock
    private ClubRepository clubRepository;

    

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

        assertThat(exception.getCode()).isEqualTo(MessageError.CLUBS_NOT_FOUND);

        verify(clubRepository).findAll();
    }
}
