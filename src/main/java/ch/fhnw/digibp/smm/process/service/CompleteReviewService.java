package ch.fhnw.digibp.smm.process.service;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;

/**
 * Created by andreas.martin on 17.04.2017.
 */
@Named
public class CompleteReviewService implements TaskListener{
    @Override
    public void notify(DelegateTask delegateTask) {
        String URL = "http://localhost:8080/data/api/smm/v1/tweet";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String input = "{\"approved\": "+((Boolean)delegateTask.getVariable("approved")).toString()+
                ", \"review\": \""+(String) delegateTask.getVariable("review") +"\"}";
        HttpEntity<String> requestUpdate = new HttpEntity<String>(input, headers);
        restTemplate.exchange(URL+"/"+ ((Long) delegateTask.getVariable("tweetId")).toString(), HttpMethod.PATCH, requestUpdate, Void.class);
    }
}
