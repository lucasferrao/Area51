import java.time.LocalDate;
import java.time.LocalTime;

public class Alert {
    private String type;
    private LocalDate date;
    private LocalTime hour;

    /**
     * Occurrence's default constructor.
     */
    public Alert(){
        this.type = "";
        this.date = LocalDate.now();
        this.hour = LocalTime.now();
    }

    /**
     * Alert's parametrized constructor.
     *
     * @param type Alert's type
     * @param date Alert's date
     * @param hour Alert's hour
     */
    public Alert(String type, LocalDate date, LocalTime hour){
        this.type = type;
        this.date = date;
        this.hour = hour;
    }

    /**
     * Alert's copy constructor.
     *
     * @param alert a alert
     */
    public Alert(Alert alert){
        this.type = alert.getType();
        this.date = alert.getDate();
        this.hour = alert.getHour();
    }

    //Getters
    public String getType() {
        return this.type;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getHour() {
        return this.hour;
    }

    //Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    /**
     * Displays a alert's information on the screen.
     *
     * @return alert's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Alert:\n");
        s.append("Alert's type: " + this.type + ".\n");
        s.append("Alert's date: " + this.date + ".\n");
        s.append("Alert's hour: " + this.hour + ".\n");

        return s.toString();
    }

    /**
     * Method that compares if two alert are the same.
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
        Alert test = (Alert) o;

        return test.type.equals(this.type) &&
                test.date.equals(this.date) && test.hour.equals(this.hour);
    }

    /**
     * Makes a copy of a alert.
     *
     * @return a clone of this instance
     */
    public Alert clone(){
        return new Alert(this);
    }
}
