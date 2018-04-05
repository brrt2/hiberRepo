package aplikacja.controller;

import aplikacja.model.Advertisement;
import aplikacja.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdvertisementController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value = "/advertisements", method = RequestMethod.POST)
    public String saveAdvertisement(Advertisement advertisement) {
        advertisementService.save(advertisement);
        return "redirect:/";
    }

    @RequestMapping(value = "/advertisements/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        advertisementService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/advertisements/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("ad", advertisementService.findOne(id));
        return "editAdvert";
    }

    @RequestMapping(value = "/advertisements/create", method = RequestMethod.GET)
    public String createAd(Model model) {
        model.addAttribute("ad", new Advertisement());
        return "createAdvert";
    }

}
