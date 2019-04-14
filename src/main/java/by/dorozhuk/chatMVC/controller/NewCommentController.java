package by.dorozhuk.chatMVC.controller;

import by.dorozhuk.chatMVC.entity.Comment;
import by.dorozhuk.chatMVC.entity.Post;
import by.dorozhuk.chatMVC.entity.User;
import by.dorozhuk.chatMVC.repository.InvalidBd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/newcomment")
public class NewCommentController {

    private int lid;

    @GetMapping
    public String newCommentGet(@RequestParam("id") int id, Model model) {
        lid = id;
        return "newcomment";
    }

    @PostMapping
    public String newCommentPost(@RequestParam("text") String text, Model model, HttpSession session) {
        int idComment = InvalidBd.getIdComment();
        User user = (User) session.getAttribute("currentUser");
        Comment comment = new Comment(++idComment, text, user);
        InvalidBd.setIdComment(idComment);
        ArrayList<Post> postList = InvalidBd.getPostList();
        Post post = postList.get(lid - 1);
        post.getCommentList().add(comment);
        postList.set(lid - 1, post);
        InvalidBd.setPostList(postList);
        InvalidBd.addModel(model);
        return "redirect:/";
    }
}
