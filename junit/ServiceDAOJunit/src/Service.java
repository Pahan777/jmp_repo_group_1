import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 09.03.16
 * Time: 12:39
 * To change this template use File | Settings | File Templates.
 */
public class Service {
    public UserDao userDao;

    public Service(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getAdminInfo() {
        List<User> allUsers = userDao.getAllUsers();
        for (User allUser : allUsers) {
            if(allUser.getRole().equals(User.Role.ADMIN))
            {
                return allUser.getName() + ":" + allUser.getRole().toString();
            }
        }
        return "";
    }
}
