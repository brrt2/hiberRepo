package aplikacja.controllers;

import aplikacja.models.Advertisement;
import aplikacja.models.AdvertisementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

        return "welcome";
    }

    @RequestMapping(value = "/advertisements/create", method = RequestMethod.GET)
    public String createAd(Model model) {
        model.addAttribute("ad", new Advertisement());
        return "create";
    }

    @RequestMapping(value = "/advertisements/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("ad", advertisementDao.findOne(id));
        return "edit";
    }

    @RequestMapping(value = "/advertisements/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        advertisementDao.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/advertisements", method = RequestMethod.POST)
    public String saveAdvertisement(Advertisement advertisement) {
        advertisementDao.save(advertisement);
        return "redirect:/";
    }
}