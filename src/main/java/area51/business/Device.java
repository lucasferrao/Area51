package area51.business;

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

    //Getters
    public String getType() {
        return this.type;
    }

    public String getModel() {
        return this.model;
    }

    public String getLocation() {
        return this.location;
    }

    public String getRepairHistory() {
        return this.repairHistory;
    }

    //Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
