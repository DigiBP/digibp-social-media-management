package ch.fhnw.digibp.smm.business.api;

import ch.fhnw.digibp.smm.business.dto.TweetCase;
import ch.fhnw.digibp.smm.business.service.TweetCaseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@Component
@Path("/api/smm/v1/tweetcase")
@Api
public class TweetCaseEndpoint {
    @Autowired
    private TweetCaseService tweetCaseService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void openTweetCase(TweetCase tweetCase) {
        tweetCaseService.saveTweetCase(tweetCase.getTweetText(), tweetCase.getTweetDate(), tweetCase.getContent(), tweetCase.getPersonName(), tweetCase.getEmail(), tweetCase.getProjectName());
    }

    @Path("/assign")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void openTweetCase(@FormParam("reviewerName") String reviewerName, @FormParam("tweetId") Long tweetId) {
        tweetCaseService.assignReviewer(reviewerName, tweetId);
    }
}
