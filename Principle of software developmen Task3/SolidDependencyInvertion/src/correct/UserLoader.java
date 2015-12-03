package correct;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserLoader
{
    private ILoader dataLoader = null;
    UserLoader(ILoader loader)
    {
        dataLoader = loader;
    }

    public User getUser(String id)
    {
        return dataLoader.getUser(id);
    }

}
