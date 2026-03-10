package server.commands;

import common.Request;
import common.Response;

/**
 * принимает имя файла и записывает в кортеж. идет проверка на рекурсивный вызов скриптов
 * @return возвращает статус "запущен", если нет рекурсии
 */
public class ExecuteScriptCommand implements Command{
    private static java.util.Vector<String> activeScripts = new java.util.Vector<>();

    @Override
    public Response execute(Request request){
        String fileName = request.getStringArgument();
        if(activeScripts.contains(fileName)){
            return new Response(false, "ошибка: бесконечная рекурсия");
        }
            return new Response(true,"запущен" + fileName);
    }

    @Override
    public String getName(){
        return "execute_script";
    }

    @Override
    public String getDescription(){
        return "выполняет скрипт";
    }

    public static void removeScript(String fileName){
        activeScripts.remove(fileName);
    }

}
