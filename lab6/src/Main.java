import executionmanager.CommandPrompt;
import Client.ConsoleInputHandler;
import Client.ConsoleOutputHandler;

public class Main {
    public static void main(String[] args) {
        var inputHandler = new ConsoleInputHandler();
        var outputHandler = new ConsoleOutputHandler();
        CommandPrompt commandPrompt = new CommandPrompt(inputHandler, outputHandler);
        commandPrompt.start();
    }
}