package next.school.cesar.desafio.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafio.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
