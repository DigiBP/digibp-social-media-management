package ch.fhnw.digibp.service;

import ch.fhnw.digibp.smm.business.service.TweetCaseService;
import ch.fhnw.digibp.smm.data.api.TweetRepository;
import ch.fhnw.digibp.smm.data.domain.Tweet;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@Named
public class InitialiseReviewTweetCaseService implements JavaDelegate{
    @Inject
    private TweetCaseService tweetCaseService;

    @Inject
    private TweetRepository tweetRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Tweet tweet = tweetCaseService.saveTweetCase(
                (String) delegateExecution.getVariable("tweet"),
                (Date) delegateExecution.getVariable("when"),
                (String) delegateExecution.getVariable("content"),
                (String) delegateExecution.getVariable("name"),
                (String) delegateExecution.getVariable("email"),
                (String) delegateExecution.getVariable("project"));
        Tweet originalTweet = tweetRepository.findOne((Long) delegateExecution.getVariable("tweetId"));
        tweet.setOriginalTweet(originalTweet);
        tweetRepository.save(tweet);
        delegateExecution.setVariable("tweetId",tweet.getId());
    }
}
