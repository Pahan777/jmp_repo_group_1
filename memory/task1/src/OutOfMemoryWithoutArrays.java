/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 1/25/16
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class OutOfMemoryWithoutArrays
{
    public String name;
    public OutOfMemoryWithoutArrays parent;

    public OutOfMemoryWithoutArrays(String name, OutOfMemoryWithoutArrays parent)
    {
        this.name = name;
        this.parent = parent;
    }

    public static void main(String[] args)
    {
        OutOfMemoryWithoutArrays tempObject = new OutOfMemoryWithoutArrays("test", null);

        Integer i = 0;
        while (true) {
            OutOfMemoryWithoutArrays o = new OutOfMemoryWithoutArrays("test" + i++, tempObject);
            tempObject = o;
            System.out.println("iteration: "+ i);
        }
    }
}
