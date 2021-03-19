package kr.ac.jejunu.user;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTests {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "JHP";
        String password = "JHPPW";

        UserDao userDao = new UserDao();
        User user = userDao.findById(id);
        assertThat(user.getId(), Is.is(id));
        assertThat(user.getName(), Is.is(name));
        assertThat(user.getPassword(), Is.is(password));
    }
}
