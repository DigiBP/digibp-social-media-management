package ch.fhnw.digibp.smm.data.api;

import ch.fhnw.digibp.smm.data.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@RepositoryRestResource(path = "/person")
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByPersonName(@Param("personName") String personName);
    List<Person> findByEmail(@Param("email") String email);
}
