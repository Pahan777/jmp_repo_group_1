/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 24.01.16
 * Time: 5:41
 * To change this template use File | Settings | File Templates.
 */
public class OutOfHeapExample {

    public static void main(String[] args) {
        int[] intArray = new int[2* 1024 * 1024];
    }
}
