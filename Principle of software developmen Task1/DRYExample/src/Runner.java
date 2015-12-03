import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 8:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{
    public static void main(String[] args)
    {
        List<String> signatures = new ArrayList<String>();
        User userOne = new User();
        userOne.setName("first");
        userOne.setAge(18);
        String signatureOne = userOne.getName() + "_" +userOne.getAge();
        signatures.add(signatureOne);

        User userTwo = new User();
        userTwo.setName("second");
        userTwo.setAge(19);
        String signatureTwo = userTwo.getName() + "_" +userTwo.getAge();
        signatures.add(signatureTwo);

        User userTre = new User();
        userTre.setName("third");
        userTre.setAge(18);
        String signatureTre = userTre.getName() + "_" +userTre.getAge();
        signatures.add(signatureTre);

        for (String signature: signatures)
        {
            System.out.println(signature);
        }
    }

}
