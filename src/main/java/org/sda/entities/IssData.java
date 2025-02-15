package org.sda.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssData {
    private long timestamp;
    @JsonProperty("iss_position")
    private IssPosition issPosition;
    private String message;

    public IssData(long timestamp, IssPosition issPosition, String message) {
        this.timestamp = timestamp;
        this.issPosition = issPosition;
        this.message = message;
    }

    public IssData() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public IssPosition getIssPosition() {
        return issPosition;
    }

    public void setIssPosition(IssPosition issPosition) {
        this.issPosition = issPosition;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "IssData{" +
                "timestamp=" + timestamp +
                ", issPosition=" + issPosition +
                ", message='" + message + '\'' +
                '}';
    }
}
