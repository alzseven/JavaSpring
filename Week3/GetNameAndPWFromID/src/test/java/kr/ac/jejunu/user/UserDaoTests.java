package kr.ac.jejunu.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    static UserDao userDao;

    @BeforeAll
    public static void setup() {
//        // ClassPathXmlApplicationContext
//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("daoFactory.xml");

        // AnnotationConfigApplcationContext
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void getJeju() throws SQLException {
        Integer id = 1;
        String name = "JHP";
        String password = "JHPPW";

        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }


    @Test
    public void insertJeju() throws SQLException {
        String name = "JHP";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        User insertedUser = userDao.findById(user.getId());

        assertThat(insertedUser.getId(), greaterThan(0));
        assertThat(insertedUser.getId(), is(user.getId()));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void updateJeju() throws SQLException {
        String name = "JHP";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        user.setName("alz7");
        user.setPassword("1234");

        userDao.update(user);

        User updatedUser = userDao.findById(user.getId());

        assertThat(updatedUser.getId(), is(user.getId()));
        assertThat(updatedUser.getName(), is(user.getName()));
        assertThat(updatedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void deleteJeju() throws SQLException {
        String name = "JHP";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        userDao.delete(user.getId());

        User deletedUser = userDao.findById(user.getId());

        assertThat(deletedUser, nullValue());
    }
    
}