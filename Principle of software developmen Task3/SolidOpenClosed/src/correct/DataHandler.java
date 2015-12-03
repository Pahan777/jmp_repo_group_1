package correct;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 12/3/15
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataHandler
{
    private IDataHandler dataHandler;

    DataHandler(IDataHandler dataHandler)
    {
        this.dataHandler = dataHandler;
    }

    public String loadData()
    {
        return dataHandler.loadData();
    }

    public void saveData()
    {
        dataHandler.saveData();
    }

}
