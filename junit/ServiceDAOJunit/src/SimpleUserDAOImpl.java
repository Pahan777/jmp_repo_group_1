import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 09.03.16
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
public class SimpleUserDAOImpl implements UserDao {

    @Override
    public List<User> getAllUsers() {
        List<User> tempList = new ArrayList<User>();
        tempList.add(new User("Vasia", User.Role.ADMIN));
        tempList.add(new User("Kolia", User.Role.USER));
        tempList.add(new User("Dima", User.Role.USER));
        return tempList;
    }
}
