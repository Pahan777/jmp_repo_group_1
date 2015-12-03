/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserUtil
{
    public static String generateSignature(User user)
    {
        return user.getName() + "_" + user.getAge();
    }
}
