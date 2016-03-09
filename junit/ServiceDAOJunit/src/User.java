/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 09.03.16
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public class User {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role{
        ADMIN,USER, MODERATOR
    }

    private String name;
    private Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }
}
