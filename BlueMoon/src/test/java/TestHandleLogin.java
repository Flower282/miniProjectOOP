import org.example.bluemoon.model.dao.UserDAO;
import org.example.bluemoon.model.entity.User;

import java.util.Scanner;

public class TestHandleLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
         String username = sc.nextLine();
        System.out.println("Enter password: ");
         String password = sc.nextLine();
         username = username.trim();
         password = password.trim();
         if (username.isEmpty() || password.isEmpty()) {
                System.out.println("Username or password is empty");
         }
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.checkLogin(username, password);
            if (user != null) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
