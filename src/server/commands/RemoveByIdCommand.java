package server.commands;

import common.Response;
import common.Request;
import server.CollectionManager;

public class RemoveByIdCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        String text = request.getStringArgument();

    }

    public String getName(){
        return "remove_by_id";
    }

    @Override
    public String getDescription(){
        return "удаляет элемент в коллекции";
    }

}
