import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/21/15
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdapterExample
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        StackAdapter stack = new StackAdapter(list);
        stack.push("q");
        stack.push("w");
        stack.push("e");
        printList(list);
        String str = stack.pop();
        printList(list);
        System.out.println("pop element: "+str);
    }
    public static void printList(List<String> list)
    {
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
