package aplikacja.controller;


import aplikacja.model.User;
import aplikacja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/usersList";
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/usersList";
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public String editUser(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", userService.findUser(id));
        return "editUser";
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @RequestMapping("/usersList")
    public String userList(Model model) {

        List<User> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "usersList";
    }

}
