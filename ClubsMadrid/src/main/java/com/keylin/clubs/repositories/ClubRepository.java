package com.keylin.clubs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keylin.clubs.entities.Club;
import com.keylin.clubs.entities.common.Cathegory;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long>{
	
	//To find a club by city
	@Query("SELECT c FROM Club c WHERE c.city = city ")
	List<Club> findByCity(String city);

	
	//To find a club by category
	@Query("SELECT c FROM Club c WHERE c.cathegory= cathegory ")
	List<Club> findByCathegory(Cathegory cathegory);
}
