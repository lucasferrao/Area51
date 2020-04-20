package Area51.business;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

/**
 * Represents an alert from any device.
 *
 * @author A89262
 * @version 20200329
 */
public class Alert {
    private String type;
    private Date date;
    private Time hour;

    /**
     * Occurrence's default constructor.
     */
    public Alert(){
        this.type = "";
        this.date = (Date) Date.from(Instant.now());
        this.hour = (Time) Time.from(Instant.now());
    }

    /**
     * Alert's parametrized constructor.
     *
     * @param type Alert's type
     * @param date Alert's date
     * @param hour Alert's hour
     */
    public Alert(String type, Date date, Time hour){
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

    /**
     * Returns a alert's type.
     *
     * @return a type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns a alert's date.
     *
     * @return a date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Returns a alert's hour.
     *
     * @return a hour
     */
    public Time getHour() {
        return this.hour;
    }

    /**
     * Updates a alert's type.
     *
     * @param type a new alert's type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Updates a alert's date.
     *
     * @param date a new alert's date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Updates a alert's hour.
     *
     * @param hour a new alert's hour
     */
    public void setHour(Time hour) {
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
        s.append("Alert's hour: " + this.hour + ".\n\n");

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
