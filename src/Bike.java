import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bike {
    public boolean isRented;
    public String SerialNumber;

    public Bike(boolean isRented, String serialNumber) {
        this.isRented = isRented;
        this.SerialNumber = serialNumber;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }


    @Override
    public String toString() {
        return "Bike{" +
                "isRented=" + isRented +
                ", SerialNumber='" + SerialNumber + '\'' +
                '}';
    }

    public static void Write(){
        Bike s = new Bike(false,"");
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
