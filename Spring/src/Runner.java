/**
 * Created by Yauheni_Kuzmianok on 4/16/2016.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Runner
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Human human = (Human) context.getBean("human");
        System.out.println(human.getLastName());

        List<Booking> list = (List<Booking>) context.getBean("list");

        Date selectedDate = (Date) context.getBean("selectedDate");

        for (Booking booking : list) {
            if (selectedDate.compareTo(booking.getDate()) == 0){

                booking.setHuman(human);
                booking.setPlace(1);
                System.out.println(booking.getFilmName());
            }
        }

    }
}
