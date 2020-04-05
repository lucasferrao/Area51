package area51.business;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Represents someone that is in prison.
 *
 * @author A89262
 * @version 20200329
 */

public class Recluse {
    private String recluseName;
    private LocalDate birthdate;
    private String genre;
    private String disease;
    private String cause;
    private String cell;

    /**
     * Recluse's default constructor.
     */
    public Recluse(){
        this.recluseName = "";
        this.birthdate = LocalDate.now();
        this.genre = "";
        this.disease = "";
        this.cause = "";
        this.cell = "";
    }

    /**
     * Recluse's parametrized constructor.
     *
     * @param recluseName Recluse's name
     * @param birthdate Recluse's birthday
     * @param genre Recluse's genre
     * @param disease Recluse's disease if has
     * @param cause Recluse's jail cause
     * @param cell Recluse's cell number
     */
    public Recluse(String recluseName, LocalDate birthdate, String genre, String disease,
                   String cause, String cell){
        this.recluseName = recluseName;
        this.birthdate = birthdate;
        this.genre = genre;
        this.disease = disease;
        this.cause = cause;
        this.cell = cell;
    }

    /**
     * Recluse's copy constructor.
     *
     * @param recluse a recluse
     */
    public Recluse(Recluse recluse){
        this.recluseName = recluse.getRecluseName();
        this.birthdate = recluse.getBirthdate();
        this.genre = recluse.getGenre();
        this.disease = recluse.getDisease();
        this.cause = recluse.getCause();
        this.cell = recluse.getCell();
    }

    /**
     * Returns a recluse's name.
     *
     * @return a name
     */
    public String getRecluseName() {
        return this.recluseName;
    }

    /**
     * Returns a recluse's birthdate.
     *
     * @return a birthdate
     */
    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    /**
     * Returns a recluse's genre.
     *
     * @return a genre
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Returns a recluse's disease.
     *
     * @return a disease
     */
    public String getDisease() {
        return this.disease;
    }

    /**
     * Returns a recluse's cause.
     *
     * @return a cause
     */
    public String getCause() {
        return this.cause;
    }

    /**
     * Returns a recluse's cell.
     *
     * @return a cell
     */
    public String getCell() {
        return this.cell;
    }

    /**
     * Updates a recluse's name.
     *
     * @param recluseName a new recluse's name
     */
    public void setRecluseName(String recluseName) {
        this.recluseName = recluseName;
    }

    /**
     * Updates a recluse's birthdate.
     *
     * @param birthdate a new recluse's birthdate
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Updates a recluse's genre.
     *
     * @param genre a new recluse's genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Updates a recluse's disease.
     *
     * @param disease a new recluse's disease
     */
    public void setDisease(String disease) {
        this.disease = disease;
    }

    /**
     * Updates a recluse's cause.
     *
     * @param cause a new recluse's cause
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     * Updates a recluse's cell.
     *
     * @param cell a new recluse's cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    /**
     * Displays a recluse's information on the screen.
     *
     * @return recluse's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Recluse:\n");
        s.append("Recluse's name: " + this.recluseName + ".\n");
        s.append("Recluse's birthdate: " + this.birthdate + ".\n");
        s.append("Recluse's genre: " + this.genre + ".\n");
        s.append("Recluse's disease: " + this.disease + ".\n");
        s.append("Recluse's cause: " + this.cause + ".\n");
        s.append("Recluse's cell: " + this.cell + ".\n\n");

        return s.toString();
    }

    /**
     * Method that compares if two recluses are the same.
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
        Recluse test = (Recluse) o;

        return test.recluseName.equals(this.recluseName) &&
                test.birthdate.equals(this.birthdate) && test.genre.equals(this.genre)
                && test.disease.equals(this.disease) && test.cause.equals(this.cause)
                && test.cell.equals(this.cell);
    }

    /**
     * Makes a copy of a recluse.
     *
     * @return a clone of this instance
     */
    public Recluse clone(){
        return new Recluse(this);
    }

    /**
     *
     * @param valueOf
     * @return
     */
    public LocalDate toLocalDate(Date valueOf) {
        LocalDate date = valueOf.toLocalDate();
        this.birthdate = date;
        return date;
    }
}
