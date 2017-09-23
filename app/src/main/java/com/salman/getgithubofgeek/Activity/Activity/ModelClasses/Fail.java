package com.salman.getgithubofgeek.Activity.Activity.ModelClasses;

/**
 * Created by Salman on 9/21/2017.
 */

public class Fail {

    private String message;
    private String documentationUrl;

    /**
     * No args constructor for use in serialization
     *
     */
    public Fail() {
    }

    /**
     *
     * @param message
     * @param documentationUrl
     */
    public Fail(String message, String documentationUrl) {
        super();
        this.message = message;
        this.documentationUrl = documentationUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentationUrl() {
        return documentationUrl;
    }

    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }
}
