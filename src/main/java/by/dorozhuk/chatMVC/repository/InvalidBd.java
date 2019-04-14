package by.dorozhuk.chatMVC.repository;

import by.dorozhuk.chatMVC.entity.Post;
import by.dorozhuk.chatMVC.entity.User;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class InvalidBd {
    private static int idUser;
    private static int idPost;
    private static int idComment;
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Post> postList = new ArrayList<>();

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        InvalidBd.idUser = idUser;
    }

    public static int getIdPost() {
        return idPost;
    }

    public static void setIdPost(int idPost) {
        InvalidBd.idPost = idPost;
    }


    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static void setUserList(ArrayList<User> userList) {
        InvalidBd.userList = userList;
    }

    public static ArrayList<Post> getPostList() {
        return postList;
    }

    public static void setPostList(ArrayList<Post> postList) {
        InvalidBd.postList = postList;
    }

    public static int getIdComment() {
        return idComment;
    }

    public static void setIdComment(int idComment) {
        InvalidBd.idComment = idComment;
    }

    public static Model addModel(Model model) {
        model.addAttribute("userList", userList);
        model.addAttribute("postList", postList);
        return model;
    }
}
