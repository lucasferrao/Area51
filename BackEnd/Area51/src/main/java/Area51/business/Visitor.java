package Area51.business;

import java.time.LocalDate;

public class Visitor {
    private String name;
    private int nif;

    /**
     * Visitor's default constructor.
     */
    public Visitor(){
        this.name = "";
        this.nif = 0;
    }

    /**
     * Visitor's parametrized constructor.
     *
     * @param name Visitor's name
     * @param nif Visitor's birthday
     */
    public Visitor(String name, int nif){
        this.name = name;
        this.nif = nif;
    }

    /**
     * Visitor's copy constructor.
     *
     * @param visitor a visitor
     */
    public Visitor(Visitor visitor){
        this.name = visitor.getName();
        this.nif = visitor.getNif();
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public int getNif() {
        return this.nif;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Displays a visitor's information on the screen.
     *
     * @return visitor's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Visitor:\n");
        s.append("Visitor's name: " + this.name + ".\n");
        s.append("Visitor's nif: " + this.nif + ".\n");

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
        Visitor test = (Visitor) o;

        return test.name.equals(this.name);
    }

    /**
     * Makes a copy of a visitor.
     *
     * @return a clone of this instance
     */
    public Visitor clone(){
        return new Visitor(this);
    }
}
