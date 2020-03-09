import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Area51 {
    //private Officer officerLoggedIn;
    private ArrayList<Recluse> recluses;
    private ArrayList<Visitor> visitors;
    private ArrayList<Visit> visits;

    /**
     * Area51's default constructor.
     */
    public Area51(){
        this.recluses = new ArrayList<Recluse>();
        this.visitors = new ArrayList<Visitor>();
        this.visits = new ArrayList<Visit>();
    }

    /**
     * Area51's parametrized constructor.
     *
     * @param recluses Area51's recluses
     * @param visitors Area51's visitors
     * @param visits Area51's visits
     */
    public Area51(ArrayList<Recluse> recluses, ArrayList<Visitor> visitors, ArrayList<Visit> visits){
        this.recluses = recluses;
        this.visitors = visitors;
        this.visits = visits;
    }

    /**
     * Area51's copy constructor.
     *
     * @param area51 a area51
     */
    public Area51(Area51 area51){
        this.recluses = area51.getRecluses();
        this.visitors = area51.getVisitors();
        this.visits = area51.getVisits();
    }

    //Getters
    public ArrayList<Recluse> getRecluses() {
        return this.recluses;
    }

    public ArrayList<Visitor> getVisitors() {
        return this.visitors;
    }

    public ArrayList<Visit> getVisits() {
        return this.visits;
    }

    //Setters
    public void setRecluses(ArrayList<Recluse> recluses) {
        this.recluses = recluses;
    }

    public void setVisitors(ArrayList<Visitor> visitors) {
        this.visitors = visitors;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
    }

    /**
     * Displays a area51's information on the screen.
     *
     * @return area51's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Area51's recluses:\n");
        for(Recluse r: this.recluses){
            s.append(" - " + r.toString() + ".\n");
        }
        s.append("\n\n");
        s.append("Area51's visitors:\n");
        for(Visitor vr: this.visitors){
            s.append(" - " + vr.toString() + ".\n");
        }
        s.append("\n\n");
        s.append("Area51's visits:\n");
        for(Visit v: this.visits){
            s.append(" - " + v.toString() + ".\n");
        }

        return s.toString();
    }

    /**
     * Method that compares if two area51 are the same.
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
        Area51 test = (Area51) o;

        return test.recluses.equals(this.recluses) && test.visitors.equals(this.visitors) &&
                test.visits.equals(this.visits);
    }

    /**
     * Makes a copy of a area51.
     *
     * @return a clone of this instance
     */
    public Area51 clone(){
        return new Area51(this);
    }
}
