package aplikacja.models;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AdvertisementDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Advertisement advertisement) {
        getSession().save(advertisement);
    }

    public void delete(int id) {
        getSession().createQuery("delete from Advertisement where id="+id).executeUpdate();

    }

    @SuppressWarnings("unchecked")
    public List<Advertisement> getAll() {
        return getSession().createQuery("from Advertisement").list();
    }






    public User getById(long id) {
        return (User) getSession().load(User.class, id);
    }

    public void update(User user) {
        getSession().update(user);
    }

} // class UserDao
