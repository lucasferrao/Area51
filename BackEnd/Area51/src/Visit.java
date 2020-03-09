import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {
    private LocalDate date;
    private LocalTime checkin;
    private LocalTime checkout;

    /**
     * Visit's default constructor.
     */
    public Visit(){
        this.date = LocalDate.now();
        this.checkin = LocalTime.now();
        this.checkout = LocalTime.now();
    }

    /**
     * Visit's parametrized constructor.
     *
     * @param date Visit's name
     * @param checkin Visit's birthday
     * @param checkout Visit's genre
     */
    public Visit(LocalDate date, LocalTime checkin, LocalTime checkout){
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

    //Getters
    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getCheckin() {
        return this.checkin;
    }

    public LocalTime getCheckout() {
        return this.checkout;
    }

    //Setters
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCheckin(LocalTime checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(LocalTime checkout) {
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
        s.append("Visit's checkout: " + this.checkout + ".\n");

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
