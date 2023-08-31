package next.school.cesar.desafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafio.entities.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    List<House> findByzipcode(String zipcode);

}