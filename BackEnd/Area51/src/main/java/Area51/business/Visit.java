package Area51.business;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;

/**
 * This class gives the recluse's visit time information.
 *
 * @author A89262
 * @version 20200329
 */
public class Visit {
    private Date date;
    private Time checkin;
    private Time checkout;

    /**
     * Visit's default constructor.
     */
    public Visit(){
        this.date = Date.from(Instant.now());
        this.checkin = (Time) Time.from(Instant.now());
        this.checkout = (Time) Time.from(Instant.now());
    }

    /**
     * Visit's parametrized constructor.
     *
     * @param date Visit's name
     * @param checkin Visit's birthday
     * @param checkout Visit's genre
     */
    public Visit(Date date, Time checkin, Time checkout){
        this.date = date;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    /**
     * Visit's copy constructor.
     *
     * @param visit a visit
     */
    public Visit(Visit visit){
        this.date = visit.getDate();
        this.checkin = visit.getCheckin();
        this.checkout = visit.getCheckout();
    }

    /**
     * Returns a visit's date.
     *
     * @return a date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Returns a visit's checkin.
     *
     * @return a checkin
     */
    public Time getCheckin() {
        return this.checkin;
    }

    /**
     * Returns a visit's checkout.
     *
     * @return a checkout
     */
    public Time getCheckout() {
        return this.checkout;
    }

    /**
     * Updates a visit's date.
     *
     * @param date a new visit's date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Updates a visit's checkin.
     *
     * @param checkin a new visit's checkin
     */
    public void setCheckin(Time checkin) {
        this.checkin = checkin;
    }

    /**
     * Updates a visit's checkout.
     *
     * @param checkout a new visit's checkout
     */
    public void setCheckout(Time checkout) {
        this.checkout = checkout;
    }

    /**
     * Displays a visit's information on the screen.
     *
     * @return visit's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Visit:\n");
        s.append("Visit's date: " + this.date + ".\n");
        s.append("Visit's checkin: " + this.checkin + ".\n");
        s.append("Visit's checkout: " + this.checkout + ".\n\n");

        return s.toString();
    }

    /**
     * Method that compares if two visit are the same.
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
        Visit test = (Visit) o;

        return test.date.equals(this.date) &&
                test.checkin.equals(this.checkin) && test.checkout.equals(this.checkout);
    }

    /**
     * Makes a copy of a visit.
     *
     * @return a clone of this instance
     */
    public Visit clone(){
        return new Visit(this);
    }
}
