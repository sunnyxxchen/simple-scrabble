package com.gmail.sunnyxxchen;

/**
 * Created by schen on 5/29/17.
 */
public class TilePlacementException extends RuntimeException {
    private String message;

    public TilePlacementException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
