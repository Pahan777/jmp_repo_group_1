import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/21/15
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonOutputStream extends FilterOutputStream
{
    public PersonOutputStream(OutputStream out)
    {
        super(out);
    }


    public void write(int b) throws IOException
    {
        super.write(Character.toUpperCase((char) b));
    }

    public void writePerson(Person person) throws IOException
    {
        byte[] str = person.getName().getBytes();
        for (int i=0;i < str.length; i++ )
        {
            write(str[i]);
        }
    }
}
