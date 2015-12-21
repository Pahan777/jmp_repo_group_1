import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/21/15
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonInputStream extends FilterInputStream
{
    protected PersonInputStream(InputStream in)
    {
        super(in);
    }

    public int read() throws IOException
    {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    public static Person readPerson(InputStream in) throws IOException
    {
        int c;
        String str = "";
        while((c = in.read()) >= 0) {
            str += (char) c;
        }
        return new Person(str);
    }
}
