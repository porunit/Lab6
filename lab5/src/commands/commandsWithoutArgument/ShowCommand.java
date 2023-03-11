package commands.commandswithoutargument;

import executionmanager.CollectionManager;
import interfaces.CommandWithoutArgument;

public class ShowCommand implements CommandWithoutArgument {

    public void execute() {
        for (var group : CollectionManager.getAll()) {
            System.out.println(group.toString());
        }
    }

    @Override
    public String getDescription() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
