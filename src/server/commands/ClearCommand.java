package server.commands;

import common.Response;
import common.Request;
import server.CollectionManager;

public class ClearCommand implements Command {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        collectionManager.clear();
        return new Response(true,"Collection is clear");
    }

    @Override
    public String getName(){
        return "clear";
    }

    @Override
    public String getDescription(){
        return "clear a collection";
    }

}
