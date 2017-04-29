package ch.fhnw.digibp.smm.process.service;

import ch.fhnw.digibp.smm.business.service.TweetCaseService;
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
public class InitialiseTweetCaseService implements JavaDelegate{
    @Inject
    private TweetCaseService tweetCaseService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Tweet tweet = tweetCaseService.saveTweetCase(
                (String) delegateExecution.getVariable("tweet"),
                (Date) delegateExecution.getVariable("when"),
                (String) delegateExecution.getVariable("content"),
                (String) delegateExecution.getVariable("name"),
                (String) delegateExecution.getVariable("email"),
                (String) delegateExecution.getVariable("project"));
        delegateExecution.setVariable("tweetId",tweet.getId());
    }
}
