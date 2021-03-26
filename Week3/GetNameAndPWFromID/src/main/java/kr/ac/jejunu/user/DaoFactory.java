package kr.ac.jejunu.user;

public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private IConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
