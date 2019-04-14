package by.dorozhuk.chatMVC.controller;

import by.dorozhuk.chatMVC.entity.User;
import by.dorozhuk.chatMVC.repository.InvalidBd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/log")
public class LoginController {

    @GetMapping
    public String loginGet(Model model) {
        return "login";
    }

    @PostMapping
    public String loginPost(@RequestParam("login") String login,
                            @RequestParam("password") String password,
                            Model model, HttpSession session) {
        User user = new User(login, password);
        if (InvalidBd.getUserList().contains(user)) {
            System.out.println("FIND USER!!");
            for (User currentUser : InvalidBd.getUserList()) {
                if (currentUser. equals(user)) {
                    session.setAttribute("currentUser", currentUser);
                }
            }
        } else System.out.println("no user!");
        InvalidBd.addModel(model);
        return "redirect:/";
    }

}
