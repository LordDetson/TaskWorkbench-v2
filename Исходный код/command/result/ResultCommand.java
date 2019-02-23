package command.result;

import java.util.TreeMap;

public class ResultCommand {
    private TreeMap<String, Object> result;

    private static class SingltonHolder{
        private static final ResultCommand INSTANCE = new ResultCommand();
    }

    private ResultCommand() {
        result = new TreeMap<>();
    }

    public static ResultCommand getInstance() {
        return SingltonHolder.INSTANCE;
    }

    public TreeMap<String, Object> getResult() {
        return result;
    }
}
