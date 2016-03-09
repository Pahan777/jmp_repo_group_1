import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 09.03.16
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
public class ServiceTest {
    @org.junit.Test
    public void testGetAdminInfo() throws Exception {

        UserDao daoTest = mock(SimpleUserDAOImpl.class);
        User mockUser = new User("test", User.Role.ADMIN);
        List<User> mockList = new ArrayList<User>();
        mockList.add(mockUser);
        when(daoTest.getAllUsers()).thenReturn(mockList);

        Service service = new Service(daoTest);

        Assert.assertEquals(service.getAdminInfo(),"test:ADMIN");

    }
}
