package temaOOP2;

/**
 * Class that contains the general phone properties and behavior
 */
public abstract class Nokia implements Phone {
    private boolean isOn = false;
    private int batteryLife = 20;
    private String name;
    private String color;
    private String material;

    /**
     * Constructor
     *
     * @param name     contains the name of the phone
     * @param color    contains the color of the phone
     * @param material contains the material of the phone
     */
    public Nokia(String name, String color, String material) {
        this.name = name;
        this.color = color;
        this.material = material;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getName() {
        return name;
    }
}
