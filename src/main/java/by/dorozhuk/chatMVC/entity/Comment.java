package by.dorozhuk.chatMVC.entity;

public class Comment {
    private int id;
    private String text;
    private User author;

    public Comment(int id, String text, User author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
