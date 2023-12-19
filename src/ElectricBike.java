public class ElectricBike extends Bike{
    private boolean Charge=true;

    public ElectricBike(boolean isRented, String serialNumber, boolean charge) {
        super(isRented, serialNumber);
        Charge = charge;
    }
}
