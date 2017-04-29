package ch.fhnw.digibp.smm.process.message;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

/**
 * Created by andreas.martin on 25.04.2017.
 */
@Named
public class RevisedTweetMessage implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("Message_TPET_RevisedTweet")
                .processInstanceVariableEquals("tweetId", delegateExecution.getVariable("originalTweetId"))
                .correlateWithResult();
    }
}