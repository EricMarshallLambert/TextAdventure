package main.com.adventure.exceptions;

public class InvalidCommandException extends RuntimeException {

    public String getMessage() {
        return "These are NOT the words you are looking for!";
    }

}
