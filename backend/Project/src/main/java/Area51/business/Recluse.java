package Area51.business;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Recluse {
    private String recluse_name;
    private Date birthdate;
    private String genre;
    private String disease;
    private String cause;
    private String cell;

    /**
     * Recluse's default constructor.
     */
    public Recluse(){
        this.recluse_name = "";
        this.birthdate = Date.from(Instant.now());
        this.genre = "";
        this.disease = "";
        this.cause = "";
        this.cell = "";
    }

    /**
     * Recluse's parametrized constructor.
     *
     * @param recluse_name Recluse's name
     * @param birthdate Recluse's birthday
     * @param genre Recluse's genre
     * @param disease Recluse's disease if has
     * @param cause Recluse's jail cause
     * @param cell Recluse's cell number
     */
    public Recluse(String recluse_name, Date birthdate, String genre, String disease,
                   String cause, String cell){
        this.recluse_name = recluse_name;
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
        this.recluse_name = recluse.getRecluse_name();
        this.birthdate = recluse.getBirthdate();
        this.genre = recluse.getGenre();
        this.disease = recluse.getDisease();
        this.cause = recluse.getCause();
        this.cell = recluse.getCell();
    }

    //Getters
    public String getRecluse_name() {
        return this.recluse_name;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDisease() {
        return this.disease;
    }

    public String getCause() {
        return this.cause;
    }

    public String getCell() {
        return this.cell;
    }

    //Setters
    public void setRecluse_name(String recluse_name) {
        this.recluse_name = recluse_name;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

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
        s.append("Recluse's name: " + this.recluse_name + ".\n");
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

        return test.recluse_name.equals(this.recluse_name) &&
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
}
