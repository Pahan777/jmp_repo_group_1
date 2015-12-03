package wrong;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Penguin extends Bird
{
    @Override
    public Integer getFlySpeed() throws Exception
    {
        throw new Exception("I can't fly!!!");
    }
}
