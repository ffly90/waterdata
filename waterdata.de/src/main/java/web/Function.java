package web;

public class Function {

    private final long id;
    private final String content;

    public Function(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}