import java.sql.*;
import java.util.Random;

/**
 * Created by Yauheni_Kuzmianok on 2/22/2016.
 */
public class Runner
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Creare Users table
            String dropTableQuerry = "DROP TABLE IF EXISTS Users";
            stmt.executeUpdate(dropTableQuerry);
            String sql = "CREATE TABLE Users " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " birthdate DATE not NULL, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);

            for (int i=0; i<3000; i++)
            {
                sql = "INSERT INTO Users " +
                        "VALUES ("+i+", 'name"+i+"', 'surname"+i+"', NOW())";
                stmt.executeUpdate(sql);
            }


            // Creare Friendships table
            dropTableQuerry = "DROP TABLE IF EXISTS Friendships";
            stmt.executeUpdate(dropTableQuerry);
            sql = "CREATE TABLE Friendships " +
                    "(userid1 INTEGER not NULL, " +
                    " userid2 INTEGER not NULL, " +
                    " timestamp timestamp) ";

            stmt.executeUpdate(sql);

            Random random = new Random();
            for (int i=0; i<80000; i++)
            {
                sql = "INSERT INTO Friendships " +
                        "VALUES ("+random.nextInt(200)+", "+random.nextInt(3000)+" , NOW())";
                stmt.executeUpdate(sql);
            }

            // Creare Posts table
            dropTableQuerry = "DROP TABLE IF EXISTS Posts";
            stmt.executeUpdate(dropTableQuerry);

            sql = "CREATE TABLE Posts " +
                    "(id INTEGER not NULL, " +
                    " userId INTEGER not NULL, " +
                    " text VARCHAR(255), " +
                    " timestamp  timestamp," +
                    "PRIMARY  KEY (id))";

            stmt.executeUpdate(sql);

            for (int i=0; i<300; i++)
            {
                sql = "INSERT INTO Posts " +
                        "VALUES ("+i+", "+random.nextInt(3000)+" , 'post text"+i+"', '2013-03-06 18:19:03')";
                stmt.executeUpdate(sql);
            }

            // Creare Likes table
            dropTableQuerry = "DROP TABLE IF EXISTS Likes";
            stmt.executeUpdate(dropTableQuerry);
            sql = "CREATE TABLE Likes " +
                    "(postid INTEGER not NULL, " +
                    " userid INTEGER not NULL, " +
                    " timestamp  timestamp)";

            stmt.executeUpdate(sql);

            for (int i=0; i<300000; i++)
            {
                sql = "INSERT INTO Likes " +
                        "VALUES ("+random.nextInt(300)+", "+random.nextInt(3000)+" , '201"+random.nextInt(9)+"-03-02 18:19:03')";
                stmt.executeUpdate(sql);
            }


            sql = "SELECT u.id, u.name, friends.count_friens , likes.count_of_likes, likes.timestamp FROM Users u\n" +
                    "INNER JOIN (SELECT Friendships.userid1 as userid1 ,COUNT(Friendships.userid1) as count_friens FROM Friendships GROUP BY Friendships.userid1) friends ON u.id= friends.userid1\n" +
                    "INNER JOIN (SELECT userId,COUNT(userId)as count_of_likes, timestamp  From Likes GROUP BY userId) likes ON u.id = likes.userId \n" +
                    "HAVING friends.count_friens > 100 AND  likes.count_of_likes > 100 AND likes.timestamp BETWEEN '2015-03-00 00:00:00' AND '2015-03-31 23:59:59'  ";

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("u.id");
                String name = rs.getString("u.name");
                int countFliends = rs.getInt("friends.count_friens");
                int countLikes = rs.getInt("likes.count_of_likes");
                String data = rs.getString("likes.timestamp");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", name: " + name+"");
                System.out.print(", countLikes: " + countLikes+"");
                System.out.print(", countFliends: " + countFliends+"");
                System.out.print(", data: " + data+"\n");

            }
            rs.close();

            System.out.println("Created table in given database...");


            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
