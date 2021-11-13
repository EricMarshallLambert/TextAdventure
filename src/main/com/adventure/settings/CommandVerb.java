package main.com.adventure.settings;

import main.com.adventure.exceptions.EmptyCommandException;
import main.com.adventure.exceptions.InvalidCommandException;

/**
 * Sprint 3 Module 1
 * This CommandVerb will be used instead of strings once we've learned about Enums.
 */

public enum CommandVerb {
    TAKE,
    MOVE,
    USE,
    DIG,
    EXAMINE,
    LOOK,
    HELP,
    QUIT,
    //Used in Sprint 3 Module 2
    FIGHT,
    //Used in Sprint 3 Module 3
    INVENTORY;


    /**
     * Takes a users input and determines which verb to include in the command.
     *
     * @param verbString - the users input.
     * @return - the CommandVerb associated with the given input.
     */
    public static CommandVerb getVerb(String verbString)
            throws
            EmptyCommandException,
            InvalidCommandException {

        CommandVerb c;

        if (verbString == null || verbString.equals("")) {
            throw new EmptyCommandException();
        }
        switch (verbString.toUpperCase()) {
            case "TAKE":
                c = TAKE;
                break;
            case "MOVE":
                c = MOVE;
                break;
            case "USE":
                c = USE;
                break;
            case "DIG":
                c = DIG;
                break;
            case "EXAMINE":
                c = EXAMINE;
                break;
            case "LOOK":
                c = LOOK;
                break;
            case "HELP":
                c = HELP;
                break;
            case "FIGHT":
                c = FIGHT;
                break;
            case "INVENTORY":
                c = INVENTORY;
                break;
            case "QUIT":
                c = QUIT;
                break;
            default:
                throw new InvalidCommandException();
        }
        return c;
    }
}
