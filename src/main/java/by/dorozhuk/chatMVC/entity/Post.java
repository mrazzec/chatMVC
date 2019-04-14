package by.dorozhuk.chatMVC.entity;

import java.util.List;

public class Post {
    private int id;
    private String text;
    private User author;
    private List<Comment> commentList;

    public Post(int id, String text, User author, List<Comment> commentList) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.commentList = commentList;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
