import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    public String username;
    public ArrayList<Bike> RentedList = new ArrayList<Bike>();

    public User(String username, ArrayList<Bike> rentedList) {
        this.username = username;
        RentedList = rentedList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Bike> getRentedList() {
        return RentedList;
    }

    public void setRentedList(ArrayList<Bike> rentedList) {
        RentedList = rentedList;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", RentedList=" + RentedList +
                '}';
    }
    public static void Write(){
        ArrayList<Bike> rentedList = new ArrayList<Bike>();
        User s = new User("",rentedList );
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(s.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}