package area51.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the project's main class.
 *
 * @author A89262
 * @version 20200329
 */
public class Area51 {
    //private Officer officerLoggedIn;
    private Map<Integer, Recluse> recluses;
    private Map<Integer, Visitor> visitors;
    private Map<Integer, Visit> visits;

    /**
     * Area51's default constructor.
     */
    public Area51(){
        this.recluses = new HashMap<Integer, Recluse>();
        this.visitors = new HashMap<Integer, Visitor>();
        this.visits = new HashMap<Integer, Visit>();
    }

    /**
     * Area51's parametrized constructor.
     *
     * @param recluses Area51's recluses
     * @param visitors Area51's visitors
     * @param visits Area51's visits
     */
    public Area51(Map<Integer, Recluse> recluses, Map<Integer, Visitor> visitors, Map<Integer, Visit> visits){
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
        this.recluses = (Map<Integer, Recluse>) area51.getRecluses();
        this.visitors = (Map<Integer, Visitor>) area51.getVisitors();
        this.visits = (Map<Integer, Visit>) area51.getVisits();
    }

    /**
     * Returns a list of recluses.
     *
     * @return all recluses
     */
    public ArrayList<Recluse> getRecluses() {
        return (ArrayList<Recluse>) this.recluses;
    }

    /**
     * Returns a list of visitors.
     *
     * @return all visitors
     */
    public ArrayList<Visitor> getVisitors() {
        return (ArrayList<Visitor>) this.visitors;
    }

    /**
     * Returns a list of visits.
     *
     * @return all visits
     */
    public ArrayList<Visit> getVisits() {
        return (ArrayList<Visit>) this.visits;
    }

    /**
     * Updates the list of all recluses.
     *
     * @param recluses a new list of recluses
     */
    public void setRecluses(ArrayList<Recluse> recluses) {
        this.recluses = (Map<Integer, Recluse>) recluses;
    }

    /**
     * Updates the list of all visitors.
     *
     * @param visitors a new list of visitors
     */
    public void setVisitors(ArrayList<Visitor> visitors) {
        this.visitors = (Map<Integer, Visitor>) visitors;
    }

    /**
     * Updates the list of all visits.
     *
     * @param visits a new list of visits
     */
    public void setVisits(ArrayList<Visit> visits) {
        this.visits = (Map<Integer, Visit>) visits;
    }

    /**
     * Displays a area51's information on the screen.
     *
     * @return area51's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();
        int count = 0;

        s.append("Area51's recluses:\n");
        for(Map.Entry<Integer, Recluse> e : recluses.entrySet()) {
            s.append("Recluse " + (count + 1) + ": " + e.toString() + "\n");
        }
        s.append("\n\n");
        s.append("Area51's visitors:\n");
        for(Map.Entry<Integer, Visitor> e : visitors.entrySet()) {
            s.append("Visitor " + (count + 1) + ": " + e.toString() + "\n");
        }
        s.append("\n\n");
        s.append("Area51's visits:\n");
        for(Map.Entry<Integer, Visit> e : visits.entrySet()) {
            s.append("Visit " + (count + 1) + ": " + e.toString() + "\n");
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
