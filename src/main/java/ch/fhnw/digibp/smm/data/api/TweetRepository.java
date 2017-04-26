package ch.fhnw.digibp.smm.data.api;

import ch.fhnw.digibp.smm.data.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@RepositoryRestResource(path = "/tweet")
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findTweetsByAuthorEmail(@Param("email") String email);
    List<Tweet> findTweetsByProjectProjectName(@Param("projectName") String projectName);
}