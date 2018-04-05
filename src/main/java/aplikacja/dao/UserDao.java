package aplikacja.dao;

import aplikacja.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void saveUser(User user) {
        getSession().saveOrUpdate(user);
    }

    public void deleteUser(int userId) {

        String hql = "DELETE FROM User WHERE id = :user_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("user_id", userId);
        int result = query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getSession().createQuery("from User").list();
    }

    public User findUser(int id) {
        return (User) getSession().createQuery("FROM User WHERE id = :user_id")
                .setParameter("user_id",id).uniqueResult();
    }

}
