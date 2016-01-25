import sun.misc.ClassLoaderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javassist.ClassPool;

/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 24.01.16
 * Time: 5:47
 * To change this template use File | Settings | File Templates.
 */
public class OutOfPermGen {

    String str = "qwe";

    public static void main(String[] args) throws Exception {

        Integer i = 0;
        while (true) {

            ClassPool pool = ClassPool.getDefault();
            pool.makeClass("eu.plumbr.demo.Generated" + i).toClass();
            System.out.println("iteration: " + (i++));
        }

    }
}
