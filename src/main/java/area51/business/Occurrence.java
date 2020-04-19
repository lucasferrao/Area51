package area51.business;

import java.sql.Date;
import java.time.Instant;

/**
 * This class is an occurrence made by a device or a officer.
 *
 * @author A89262
 * @version 20200329
 */
public class Occurrence {
    private String description;
    private String subject;
    private Date date;

    /**
     * Occurrence's default constructor.
     */
    public Occurrence(){
        this.description = "";
        this.subject = "";
        this.date = (Date) Date.from(Instant.now());
    }

    /**
     * Occurrence's parametrized constructor.
     *
     * @param description Occurrence's description
     * @param subject Occurrence's subject
     * @param date Occurrence's date
     */
    public Occurrence(String description, String subject, Date date){
        this.description = description;
        this.subject = subject;
        this.date = date;
    }

    /**
     * Occurrence's copy constructor.
     *
     * @param occurrence a occurrence
     */
    public Occurrence(Occurrence occurrence){
        this.description = occurrence.getDescription();
        this.subject = occurrence.getSubject();
        this.date = occurrence.getDate();
    }

    /**
     * Returns a occurrence's description.
     *
     * @return a description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns a occurrence's subject.
     *
     * @return a subject
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * Returns a occurrence's date.
     *
     * @return a date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Updates a occurrence's description.
     *
     * @param description a new occurrence's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Updates a occurrence's subject.
     *
     * @param subject a new occurrence's subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Updates a occurrence's date.
     *
     * @param date a new occurrence's date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Displays a occurrence's information on the screen.
     *
     * @return occurrence's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Occurrence:\n");
        s.append("Occurrence's description: " + this.description + ".\n");
        s.append("Occurrence's subject: " + this.subject + ".\n");
        s.append("Occurrence's date: " + this.date + ".\n\n");

        return s.toString();
    }

    /**
     * Method that compares if two occurrence are the same.
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
        Occurrence test = (Occurrence) o;

        return test.description.equals(this.description) &&
                test.subject.equals(this.subject) && test.date.equals(this.date);
    }

    /**
     * Makes a copy of a occurrence.
     *
     * @return a clone of this instance
     */
    public Occurrence clone(){
        return new Occurrence(this);
    }
}
