package server.commands;

import common.Request;
import common.Response;
import server.CollectionManager;
import common.Government;

public class RemoveAllByGovernmentCommand implements Command{
    private CollectionManager collectionManager;

    public RemoveAllByGovernmentCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    @Override
    public Response execute(Request request){
        String arg = request.getStringArgument();
        common.Government gov = common.Government.valueOf(arg.toUpperCase());
        boolean isRemoved = this.collectionManager.removeAllByGovernment(gov);

        if(isRemoved){
            Response response = new Response(true, "успешно удалены города по виду правления");
            return response;
        }
        else{
            Response response = new Response(false, "удалить по виду правления невозможно");
            return response;
        }
    }
    @Override
    public String getName(){
        return "remove_all_by_government";
    }

    @Override
    public String getDescription(){
        return "удаляет все города по виду правления";
    }

}
