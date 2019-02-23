package command.content;

import java.util.TreeMap;

public class ContentCommand {
    private TreeMap<String, Object> content = new TreeMap<>();

    private static class SingltonHolder{
        private static final ContentCommand INSTANCE = new ContentCommand();
    }

    private ContentCommand() {
    }

    public static ContentCommand getInstance() {
        return SingltonHolder.INSTANCE;
    }

    public TreeMap<String, Object> getContent() {
        return content;
    }
}
