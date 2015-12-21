import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/21/15
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */

public class StackAdapter implements SimpleStack
{
    private List<String> list;

    public StackAdapter(List<String> list)
    {
        this.list = list;
    }
    @Override
    public void push(String str)
    {
        list.add(str);
    }


    @Override
    public String pop()
    {
        String tmp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return tmp;
    }

}
