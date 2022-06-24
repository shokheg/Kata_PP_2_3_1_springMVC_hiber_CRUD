package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

/**
 * @author shokhalevich
 */

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/users")
    public String showUsers(ModelMap model) {
        model.addAttribute("userTable", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping(value = "/user-create")
    public String createUser(User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @DeleteMapping (value = "user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(userService.getUser(id));
        return "redirect:/users";
    }

    @GetMapping(value = "user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PatchMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

}
