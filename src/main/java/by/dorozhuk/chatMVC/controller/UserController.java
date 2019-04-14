package by.dorozhuk.chatMVC.controller;

import by.dorozhuk.chatMVC.constant.Role;
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
@RequestMapping(path = "/user")
public class UserController {

    @GetMapping
    public String userGet(Model model, HttpSession session) {
        ArrayList<User> userList = InvalidBd.getUserList();
        User currentUser = (User) session.getAttribute("currentUser");
        if (userList.contains(currentUser)) {
            for (User user : userList) {
                if (user.equals(currentUser)) {
                    model.addAttribute("user", user);
                }
            }
        } else return "redirect:/";
        return "user";
    }

    @PostMapping
    public String userPost(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("login") String login,
                           @RequestParam("password") String password,
                           Model model, HttpSession session) {
        User user = new User(id, name, login, password, Role.USER);
        ArrayList<User> userList = InvalidBd.getUserList();
        session.setAttribute("currentUser", user);
        userList.set(--id, user);
        InvalidBd.setUserList(userList);
        System.out.println(userList);
        return "redirect:/";
    }
}
