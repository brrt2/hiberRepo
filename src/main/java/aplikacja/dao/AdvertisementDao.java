package aplikacja.dao;

import java.util.List;
import javax.transaction.Transactional;
import aplikacja.model.Advertisement;
import org.hibernate.Query;
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
        getSession().saveOrUpdate(advertisement);
    }

    public void delete(int advertId) {
        String hql = "DELETE FROM Advertisement "  +
                "WHERE id = :advert_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("advert_id", advertId);
        int result = query.executeUpdate();
    }

    public Advertisement findOne(int id) {
        return (Advertisement) getSession().createQuery("FROM Advertisement WHERE id = :ad_id")
                .setParameter("ad_id",id).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Advertisement> getAll() {
        return getSession().createQuery("from Advertisement").list();
    }

    public void update(Advertisement advertisement) {
        getSession().update(advertisement);
    }

}
