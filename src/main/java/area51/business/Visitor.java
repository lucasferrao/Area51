<<<<<<< HEAD:BackEnd/Area51/src/main/java/Area51/business/Visitor.java
package Area51.business;

/**
 * This is the class that gives the recluse's visitor information.
 *
 * @author A89262
 * @version 20200329
 */
=======
package area51.business;

>>>>>>> b34c85bf8807ae19992fa0065d4bac8b77d44d4e:src/main/java/area51/business/Visitor.java
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

    /**
     * Returns a visitor's name.
     *
     * @return a name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a visitor's nif.
     *
     * @return a nif
     */
    public int getNif() {
        return this.nif;
    }

    /**
     * Updates a visitor's name.
     *
     * @param name a new visitor's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates a visitor's nif.
     *
     * @param nif a new visitor's nif
     */
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
