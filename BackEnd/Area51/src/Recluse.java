import java.time.LocalDate;

public class Recluse {
    private String name;
    private LocalDate birthdate;
    private String genre;
    private String disease;
    private String cause;
    private String cell;

    /**
     * Recluse's default constructor.
     */
    public Recluse(){
        this.name = "";
        this.birthdate = LocalDate.now();
        this.genre = "";
        this.disease = "";
        this.cause = "";
        this.cell = "";
    }

    /**
     * Recluse's parametrized constructor.
     *
     * @param name Recluse's name
     * @param birthdate Recluse's birthday
     * @param genre Recluse's genre
     * @param disease Recluse's disease if has
     * @param cause Recluse's jail cause
     * @param cell Recluse's cell number
     */
    public Recluse(String name, LocalDate birthdate, String genre, String disease,
                   String cause, String cell){
        this.name = name;
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
        this.name = recluse.getName();
        this.birthdate = recluse.getBirthdate();
        this.genre = recluse.getGenre();
        this.disease = recluse.getDisease();
        this.cause = recluse.getCause();
        this.cell = recluse.getCell();
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public LocalDate getBirthdate() {
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
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
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
        s.append("Recluse's name: " + this.name + ".\n");
        s.append("Recluse's birthdate: " + this.birthdate + ".\n");
        s.append("Recluse's genre: " + this.genre + ".\n");
        s.append("Recluse's disease: " + this.disease + ".\n\n");
        s.append("Recluse's cause: " + this.cause + ".\n\n");
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

        return test.name.equals(this.name) &&
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
