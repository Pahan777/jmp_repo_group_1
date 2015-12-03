package wrong;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(getflySpeed(new Bird()));
        System.out.println(getflySpeed(new Penguin()));
    }
    public static Integer getflySpeed(Bird bird) throws Exception
    {
        return bird.getFlySpeed();
    }
}
