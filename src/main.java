import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class main {
    public static void main(String[] args) {


        ArrayList <Bike> bikes = new ArrayList<>();

        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Making some Bikes
        Bike bike1 = new Bike(false, "001");
        Bike bike2 = new RoadBike(true, "002");
        Bike bike3 = new ElectricBike(false, "003",true);
        Bike bike4 = new Bike(true, "004");
        bikes.add(bike1);
        bikes.add(bike2);
        bikes.add(bike3);
        bikes.add(bike4);

        //Making some Users
        User user1 = new User("Rasputin",new ArrayList<Bike>());
        ArrayList <User> users = new ArrayList<>();
        users.add(user1);

        //Showing Menu
        System.out.println("Menu------------------------------------>");
        System.out.println("1)Available Bikes");
        System.out.println("2)Rented Bikes");
        System.out.println("3)Returning Bikes");
        System.out.println("4)Renting Bikes");
        System.out.println("5)Adding Bikes");
        System.out.println("6)Adding users");
        System.out.println("7)Bike's List");
        System.out.println("8)User's list");
        System.out.println("9)Exit");
        System.out.println("10)Loading Data");
        System.out.println("Enter an option to continue...");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        do{
            Menu(input, bikes, users, user1);
        }while(input != 9);


    }

    public static void Menu(int input,ArrayList<Bike> b,ArrayList<User> users , User user) {
        Scanner in = new Scanner(System.in);
       input = in.nextInt();
        switch (input) {

            case 1:
                System.out.println("1)Available Bikes");
                for (int i = 0 ; i < b.size() ; i++) {
                    if (b.get(i).isRented == false) {
                        System.out.println(b.get(i).SerialNumber);
                    }
                }
                break;

            case 2:
                System.out.println("2)Rented Bikes");
                for (int i = 0 ; i < b.size() ; i++){
                    if (b.get(i).isRented){
                        System.out.println(b.get(i).SerialNumber);
                    }
                }
                break;

            case 3:
                System.out.println("3)Returning Bikes");
                Scanner code = new Scanner(System.in);
                System.out.println("Enter the returned Bike's Serial Number:");
                String c = code.next();
                for (int i = 0 ; i < b.size() ; i++){
                    while (b.get(i).SerialNumber == c){
                        System.out.println("The Code you entered is already here.");
                        break;
                    }
                }
                Bike X = new Bike (false,c);
                b.add(new Bike (false,c));
                System.out.format("The Bike with %s SerialNumber was returned.",c);
                X.Write();
                break;

            case 4:
                System.out.println("4)Renting Bikes");
                System.out.println("Please enter one of the available bike's" +
                        "Serial Numbers:");
                for (int i = 0 ; i < b.size() ; i++) {
                    if (b.get(i).isRented == false) {
                        System.out.println(b.get(i).SerialNumber);
                    }
                }
                Scanner code2 = new Scanner(System.in);
                System.out.println("Enter a Bikes Serial Number and you're " +
                        "user name");
                String c2 = code2.next();
                String U = code2.next();
                user.setUsername(U);
                for (int i = 0 ; i < b.size() ; i++){
                    for (int j = 0 ; j < users.size() ; j ++){
                        if ((b.get(i).SerialNumber == c2) &&
                                (users.get(i).username == user.getUsername())){
                            b.remove(b.get(i));
                            user.RentedList.add(b.get(j));
                        }
                    }
                }
                System.out.println("The Bike "+ c2 + " has successfully " +
                    "added to user "+ U + " .");
                break;

            case 5:
                System.out.println("Adding a new Bike");
                Scanner Bike_new_Serial = new Scanner(System.in);
                String d = Bike_new_Serial.next();
                Bike BMX = new Bike(false,d);
                b.add(BMX);
                System.out.println("The Bike "+ d + " Successfully added.");
                BMX.Write();
                break;

            case 6:
                System.out.println("Adding a new user");
                Scanner User_new = new Scanner(System.in);
                System.out.println("Please enter the new user's name:");
                String name = User_new.next();
                User user1 = new User(name,new ArrayList<Bike>());
                users.add(user1);
                System.out.println("New user " + name + " successfully added.");
                user.Write();
                break;

            case 7:
                System.out.println("Bike List");
                for (int j = 0 ; j < b.size() ; j++){
                    System.out.println(b.get(j).toString());
                }
                break;

            case 8:
                System.out.println("Users List");
                for (int k = 0 ; k < users.size() ; k++){
                    System.out.println(users.get(k).toString());
                }
                break;

            case 9:
                System.out.println("Exit");
                System.out.println("You Exited the menu");
                break;

            case 10:
                System.out.println("Loading Data...");
                break;

            default:
                System.out.println("Please Enter a valid number");
                break;
        }
    }
}