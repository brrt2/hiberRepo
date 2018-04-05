package aplikacja.service;

import aplikacja.dao.AdvertisementDao;
import aplikacja.model.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    @Autowired
    AdvertisementDao advertisementDao;


    public void save(Advertisement advertisement) {

        advertisementDao.save(advertisement);
    }

    public void delete(int id) {

    advertisementDao.delete(id);
    }

    public Advertisement findOne(int id) {

        return advertisementDao.findOne(id);
    }
}
