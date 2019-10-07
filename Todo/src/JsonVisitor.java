public class JsonVisitor implements Visitor {

    private String result = "";

    @Override
    public void drawTask(CompositeTask task, int depth) {
        result +=  "{";
        result +=  "  title: \"" + task.getTitle() + "\",";
        result +=  "  date: \"" + task.getDate() + "\",";
        result +=  "  isComplete: " + task.isComplete() + ",";
        result +=  "  sub: [ ";
    }

    private String getPadding(int depth) {
        String padding = "";
        for (int i=0; i < depth; i++) {
            padding += "  ";
        }
        return padding;
    }

    @Override
    public void end(int depth, boolean isEnd) {
        String padding = getPadding(depth);
        result +=  "  ]";
        result +=  "}";
        if (!isEnd){
            result += ",";
        }
    }

    public String getJson() {
        return result;
    }
}