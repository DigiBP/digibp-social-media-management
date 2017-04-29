package ch.fhnw.digibp.demo.process.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import javax.inject.Named;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@Named
public class PublishTweetService implements JavaDelegate {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PublishTweetService.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String tweet = (String) delegateExecution.getVariable("tweet");

        log.info("\n######\n"
                + "NOW WE WOULD TWITTER: '" + tweet + "'" + "\n"
                + "Original content: " + tweet + "\n"
                + "\n######\n");
    }
}
