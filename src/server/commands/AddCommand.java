package server.commands;

import common.Request;
import common.Response;
import server.CollectionManager;

public class AddCommand implements Command {
    private CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        Response city = this.collectionManager.getCityArgument();
        city.add(city);
        Response result = new Resonse(true,city);
        return result;
    }

    @Override
    public String getName(){
        return "add";
    }

    @Override
    public String getDescription(){
        return "adds an element to a collection";
    }

}
