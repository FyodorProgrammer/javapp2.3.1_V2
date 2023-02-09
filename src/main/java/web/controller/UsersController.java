package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAOList;
import web.model.User;
import web.service.Service;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        //Получим всех людей из DAO и передадим на отображение в представление

        model.addAttribute("users", service.index());

        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        // Получим одного человека по id из DAO
        model.addAttribute("user", service.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", service.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        service.update(id, user);
        return "redirect:/{id}";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        service.delete(id);
        return "redirect:/";
    }

}
