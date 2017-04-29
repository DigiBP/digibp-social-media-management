package ch.fhnw.digibp.smm.process.service;

import ch.fhnw.digibp.smm.business.service.TweetCaseService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@Named
public class AssignReviewService implements TaskListener {
    @Inject
    private TweetCaseService tweetCaseService;

    @Override
    public void notify(DelegateTask delegateTask) {
        tweetCaseService.assignReviewer(delegateTask.getAssignee(),(Long) delegateTask.getVariable("tweetId"));
    }
}
