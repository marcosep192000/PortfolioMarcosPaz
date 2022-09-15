package com.portfolio.PortfolioMarcosPaz.util.exeptions;

import org.springframework.http.HttpStatus;

public class Message {
    String message;

    public Message(String message) {
        this.message = message;
    }

    public Message() {
    }

    public Message(String s, HttpStatus accepted) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
