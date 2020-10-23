package br.com.pillwatcher.dpb.repositories;

import br.com.pillwatcher.dpb.entities.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NurseRepository extends JpaRepository<Nurse, Long> {

    Optional<Nurse> findByEmail(final String email);

    Optional<Nurse> findByUserDocument(final String document);

}
