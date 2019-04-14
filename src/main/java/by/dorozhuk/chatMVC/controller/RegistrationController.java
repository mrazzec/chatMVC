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

@Controller
@RequestMapping(path = "/reg")
public class RegistrationController {

    @GetMapping
    public String registrationGet() {
        return "registration";
    }

    @PostMapping
    public String registrationPost(@RequestParam("name") String name,
                                   @RequestParam("login") String login,
                                   @RequestParam("password") String password,
                                   Model model) {
        int id = InvalidBd.getIdUser();
        InvalidBd.getUserList().add(new User(++id, name, login, password, Role.USER));
        InvalidBd.setIdUser(id);
        InvalidBd.addModel(model);
        System.out.println(InvalidBd.getUserList());
        return "redirect:/";
    }
}
