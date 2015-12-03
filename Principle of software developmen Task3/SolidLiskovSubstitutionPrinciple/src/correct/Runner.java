package correct;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{
    public static void main(String[] args)
    {
        System.out.println(getSpeed(new Bird()));
        System.out.println(getSpeed(new Penguin()));
    }
    public static Integer getSpeed(Bird bird)
    {
        return bird.getSpeed();
    }
}
