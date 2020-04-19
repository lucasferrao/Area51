package Area51.business;

/**
 * Represents the device that gives a alert.
 *
 * @author A89262
 * @version 20200329
 */
public class Device {
    private String type;
    private String model;
    private String location;
    private String repairHistory;

    /**
     * Device's default constructor.
     */
    public Device(){
        this.type = "";
        this.model = "";
        this.location = "";
        this.repairHistory = "";
    }

    /**
     * Device's parametrized constructor.
     *
     * @param type Device's type
     * @param model Device's model
     * @param location Device's location
     * @param repairHistory Device's repair history
     */
    public Device(String type, String model, String location, String repairHistory){
        this.type = type;
        this.model = model;
        this.location = location;
        this.repairHistory = repairHistory;
    }

    /**
     * Device's copy constructor.
     *
     * @param device a device
     */
    public Device(Device device){
        this.type = device.getType();
        this.model = device.getModel();
        this.location = device.getLocation();
        this.repairHistory = device.getRepairHistory();
    }

    /**
     * Returns a device's type.
     *
     * @return a type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns a device's model.
     *
     * @return a model
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Returns a device's location.
     *
     * @return a location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Returns a device's repair history.
     *
     * @return a repair history
     */
    public String getRepairHistory() {
        return this.repairHistory;
    }

    /**
     * Updates a device's type.
     *
     * @param type a new device's type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Updates a device's model.
     *
     * @param model a new device's model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Updates a device's location.
     *
     * @param location a new device's location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Updates a device's repair history.
     *
     * @param repairHistory a new device's repair history
     */
    public void setRepairHistory(String repairHistory) {
        this.repairHistory = repairHistory;
    }

    /**
     * Displays a device's information on the screen.
     *
     * @return device's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Device:\n");
        s.append("Device's type: " + this.type + ".\n");
        s.append("Device's model: " + this.model + ".\n");
        s.append("Device's location: " + this.location + ".\n\n");
        s.append("Device's repair history: " + this.repairHistory + ".\n\n");

        return s.toString();
    }

    /**
     * Method that compares if two devices are the same.
     *
     * @param o object being used as a term of comparison
     *
     * @return boolean indicating if two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Device test = (Device) o;

        return test.type.equals(this.type) &&
                test.model.equals(this.model) && test.location.equals(this.location)
                && test.repairHistory.equals(this.repairHistory);
    }

    /**
     * Makes a copy of a device.
     *
     * @return a clone of this instance
     */
    public Device clone(){
        return new Device(this);
    }
}
