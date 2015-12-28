import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;


public class ClassLoaderExample
{

    public static void main(String[] args) throws Exception
    {
        File file = new File("d:\\TestEnv\\ClassLoaderExample\\extension\\loadedFunction.jar");

        List functionalitys = loadClassesFromJar(file);

        System.out.println("=======================================================================");
        System.out.println("=============================== MENU ==================================");
        System.out.println("=======================================================================");
        System.out.println("You can choose " + functionalitys.size() + " actions");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an action");
        int input = keyboard.nextInt();

        Object runnableObject = functionalitys.get(input - 1);
        Method m = runnableObject.getClass().getMethod("run");
        m.invoke(runnableObject);


    }

    public static List loadClassesFromJar(File file) throws Exception
    {
        List functionalitys = new ArrayList();

        JarFile jarFile = new JarFile(file);
        Enumeration e = jarFile.entries();

        URL[] urls = { new URL("jar:file:" + file+"!/") };
        URLClassLoader cl = URLClassLoader.newInstance(urls);


        while (e.hasMoreElements()) {
            JarEntry je = (JarEntry) e.nextElement();
            if(je.isDirectory() || !je.getName().endsWith(".class")){
                continue;
            }
                // -6 because of .class
            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');
            Class c = cl.loadClass(className);
            Object o = c.newInstance();
            functionalitys.add(o);
        }
        return functionalitys;
    }
}
