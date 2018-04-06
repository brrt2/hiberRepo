package aplikacja.controller;

import aplikacja.model.Advertisement;
import aplikacja.dao.AdvertisementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    AdvertisementDao advertisementDao;

    @RequestMapping("/")
    public String index(Model model) {

        List<Advertisement> advertisements = advertisementDao.getAll();

        model.addAttribute("ads", advertisements);

        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}