package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("user1", "ivanov", "user1@mail.com", new Car("lada", 111)));
      userService.add(new User("user2", "petrov", "user2@mail.com", new Car("nissan", 222)));
      userService.add(new User("user3", "katzman", "user3@mail.com", new Car("honda", 333)));
      userService.add(new User("user4", "sidorov", "user4@mail.com", new Car("kia", 444)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }


      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }
      context.close();
   }
}
