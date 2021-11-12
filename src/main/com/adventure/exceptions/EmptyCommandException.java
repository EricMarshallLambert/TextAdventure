package main.com.adventure.exceptions;

public class EmptyCommandException extends RuntimeException {

    public String getMessage() {
        return "Use your words adventurer!";
    }

}
