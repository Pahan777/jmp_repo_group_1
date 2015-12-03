package correct;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayUtil
{
    public static void displayAllUsers(List<User> users)
    {
        for (User user: users)
        {
            System.out.println(user.getName());
        }
    }
}
