import org.example.bluemoon.model.entity.Role;
import org.example.bluemoon.model.entity.User;
import org.example.bluemoon.security.PasswordUtil;
import org.example.bluemoon.util.HibernateUtil;
import org.hibernate.Session;

public class TestCreateAdminAcconut {
    public static void main(String[] args) {

        User admin = new User("duongduong", PasswordUtil.hashPassword("admin"), Role.ADMIN);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(admin);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtil.shutdown();
        }
    }
}
