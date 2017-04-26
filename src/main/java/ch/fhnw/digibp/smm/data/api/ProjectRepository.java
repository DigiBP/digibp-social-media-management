package ch.fhnw.digibp.smm.data.api;

import ch.fhnw.digibp.smm.data.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@RepositoryRestResource(path = "/project")
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByProjectName(@Param("projectName") String projectName);
}
