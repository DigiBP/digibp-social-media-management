package ch.fhnw.digibp.smm.business.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by andreas.martin on 17.04.2017.
 */
public class TweetCase implements Serializable{
    private String tweetText; 
    private Date tweetDate;
    private String content;
    private String personName;
    private String email;
    private String projectName;


    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public Date getTweetDate() {
        return tweetDate;
    }

    public void setTweetDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
