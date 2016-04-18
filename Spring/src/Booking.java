import java.util.Date;

/**
 * Created by Yauheni_Kuzmianok on 4/16/2016.
 */
public class Booking
{
    private String number;
    private String FilmName;
    private Date date;
    private Integer place;
    private Integer cost;
    private Human human;

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getFilmName()
    {
        return FilmName;
    }

    public void setFilmName(String filmName)
    {
        FilmName = filmName;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Integer getPlace()
    {
        return place;
    }

    public void setPlace(Integer place)
    {
        this.place = place;
    }

    public Integer getCost()
    {
        return cost;
    }

    public void setCost(Integer cost)
    {
        this.cost = cost;
    }

    public Human getHuman()
    {
        return human;
    }

    public void setHuman(Human human)
    {
        this.human = human;
    }
}
