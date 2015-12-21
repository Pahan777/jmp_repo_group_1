import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/21/15
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{
    public static void main(String[] args) throws IOException
    {
        InputStream in = new PersonInputStream(new BufferedInputStream(new FileInputStream("d:/test.txt")));
        Person person = PersonInputStream.readPerson(in);
        System.out.println(person.getName());

        PersonOutputStream ou = new PersonOutputStream(new BufferedOutputStream(new FileOutputStream("d:/testout.txt")));
        ou.writePerson(person);
        ou.flush();
        ou.close();
    }
}
