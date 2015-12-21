/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/21/15
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person
{
    private String name;



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Person(String str)
    {
        name = str;
    }
}