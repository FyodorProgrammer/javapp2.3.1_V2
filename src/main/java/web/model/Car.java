package web.model;

public class Car {
    private String manufacturer;

    private String model;

    private int serial_number;

    public Car() {
    }

    public Car(String manufacturer, String model, int serial_number) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.serial_number = serial_number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    @Override
    public String toString() {
        return "Car: Serial number (" + serial_number + "), Manufacturer ("+ manufacturer + "), Model (" + model + ")";
    }
}
