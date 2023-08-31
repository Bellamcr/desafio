package next.school.cesar.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafio.entities.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    
}
