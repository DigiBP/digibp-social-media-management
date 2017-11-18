package ch.fhnw.digibp.demo.process.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;

import javax.inject.Named;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@Named
public class TweetRejectionService implements JavaDelegate {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TweetRejectionService.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String tweet = (String) delegateExecution.getVariable("tweet");
        String review = (String) delegateExecution.getVariable("review");

        log.info("\nHi!\n"
                + "Unfortunately your tweet has been rejected.\n"
                + "Original content: " + tweet + "\n"
                + "Review: " + review + "\n"
                + "Sorry, please try with better content the next time :-)\n");
    }

    public void executeMethod(DelegateExecution delegateExecution) throws Exception {
        this.execute(delegateExecution);
    }
}
