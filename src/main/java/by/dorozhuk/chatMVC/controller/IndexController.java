package by.dorozhuk.chatMVC.controller;

import by.dorozhuk.chatMVC.repository.InvalidBd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {


    @GetMapping
    public String index(Model model) {
        InvalidBd.addModel(model);
        return "index";
    }

    @GetMapping(path = "/logout")
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
