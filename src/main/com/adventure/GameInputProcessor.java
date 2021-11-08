package main.com.adventure;

import main.com.adventure.settings.Command;
import main.com.adventure.settings.CommandConstants;
import main.com.adventure.settings.CommandVerb;

import java.util.Locale;
import java.util.Scanner;

public class GameInputProcessor {


    /**
     * Asks the user for their next command.
     * @return the response from the user.
     */
    public String prompt() {
        System.out.println("Enter your next command:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput + "";
    }

    /**
     * Inputs that come into this method represent single action with no object. When building the command, you'll want
     * to supply the first word as the verb and leave the objectName blank.
     * Example input:
     *  "help"
     *  "look"
     * @param input - the input from the user
     * @return - the Command object with the proper verb and blank object
     */
    private Command buildSimpleCommand(String input) {

        String[] userInputArray = input.split(" ");
        String verb = userInputArray[0];
        CommandVerb v = CommandVerb.getVerb(verb);
        return new Command(v);
    }

    /**
     * Inputs that come into this method will have an object or objects that the action is acting on. You'll need to
     * include the object as part of the Command object.
     * Example input:
     *  "use key"
     *  "examine door"
     *  "move west"
     *
     * You should also account for incomplete actions (i.e. the object is missing). In that case, you should return a
     * blank object.
     * Example bad input:
     *  "move "
     *
     * @param input - the input from the user. userInput
     * @return - the Command object with the proper verb and object
     */
    private Command buildCommandWithObject(String input) {
        String[] userInputArray = input.trim().split(" ");
        String object;
        String verb;

        if (userInputArray.length <= 0) {
            verb = "";
            object = "";
        } else if (userInputArray.length == 1) {
            verb = userInputArray[0];
            object = "";
        } else {
            verb = userInputArray[0];
            object = input.substring(input.indexOf(" ") + 1);
        }

        return new Command(CommandVerb.getVerb(verb), object);
    }


    /** DO NOT CHANGE ANYTHING BELOW THIS LINE. **/

    /**
     * Gets the next command from the user.
     * @return a command object
     */
    public Command getNextCommand() {
        String input = prompt();
        return processCommand(input);
    }

    private Command processCommand(String input) {
        String normalizedInput = input.toLowerCase(Locale.ROOT);
        if (normalizedInput.contains(CommandConstants.MOVE) ||
                normalizedInput.contains(CommandConstants.USE) ||
                normalizedInput.contains(CommandConstants.TAKE) ||
                normalizedInput.contains(CommandConstants.EXAMINE)
        ) {
            return buildCommandWithObject(normalizedInput);
        } else {
            return buildSimpleCommand(normalizedInput);
        }
    }

}
