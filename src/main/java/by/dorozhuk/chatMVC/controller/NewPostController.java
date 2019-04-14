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
@RequestMapping(path = "/newpost")
public class NewPostController {

    @GetMapping
    private String newpostGet() {
        return "newpost";
    }

    @PostMapping
    private String newpostPost(@RequestParam("text") String text, Model model, HttpSession session) {
        int id = InvalidBd.getIdPost();
        User user = (User) session.getAttribute("currentUser");
        System.out.println(user);
        InvalidBd.getPostList().add(new Post(++id, text, user, new ArrayList<Comment>()));
        InvalidBd.setIdPost(id);
        InvalidBd.addModel(model);
        return "redirect:/";
    }
}
