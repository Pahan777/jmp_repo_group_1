import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class User
{
    private String name;

    private Integer age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public static void displayAllUsers(List<User> users)
    {
        for (User user: users)
        {
            System.out.println(user.getName());
        }
    }
}
