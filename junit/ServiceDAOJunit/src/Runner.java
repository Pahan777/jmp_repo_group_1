/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 09.03.16
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public class Runner {
    public static void main(String[] args) {
        Service service = new Service(new SimpleUserDAOImpl());
        System.out.println(service.getAdminInfo());
    }
}
