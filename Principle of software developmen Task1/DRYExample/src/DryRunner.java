import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class DryRunner
{
    public static void main(String[] args)
    {
        List<String> signatures = new ArrayList<String>();
        User userOne = new User();
        userOne.setName("first");
        userOne.setAge(18);
        signatures.add(UserUtil.generateSignature(userOne));

        User userTwo = new User();
        userTwo.setName("second");
        userTwo.setAge(19);
        signatures.add(UserUtil.generateSignature(userTwo));

        User userTre = new User();
        userTre.setName("third");
        userTre.setAge(18);
        signatures.add(UserUtil.generateSignature(userTre));

        for (String signature: signatures)
        {
            System.out.println(signature);
        }
    }




}
