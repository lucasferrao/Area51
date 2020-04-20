package Area51.business;

/**
 * This is the class that contains de user.
 *
 * @author A89262
 * @version 20200329
 */
public class Officer {
    private String idOfficerLogin;
    private String email;
    private String password;
    private String address;
    private int phoneNumber;

    /**
     * Officer's default constructor.
     */
    public Officer(){
        this.idOfficerLogin = "";
        this.email = "";
        this.password = "";
        this.address = "";
        this.phoneNumber = 0;
    }

    /**
     * Officer's default constructor.
     */
    public Officer(String idOfficerLogin, String password){
        this.idOfficerLogin = idOfficerLogin;
        this.email = "";
        this.password = password;
        this.address = "";
        this.phoneNumber = 0;
    }

    /**
     * Officer's parametrized constructor.
     *
     * @param idOfficerLogin Officer's login username
     * @param email Officer's email
     * @param password Officer's password
     * @param address Officer's address
     * @param phoneNumber Officer's phone number
     */
    public Officer(String idOfficerLogin, String email, String password, String address,
                    int phoneNumber){
        this.idOfficerLogin = idOfficerLogin;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Officer's copy constructor.
     *
     * @param officer a officer
     */
    public Officer(Officer officer){
        this.idOfficerLogin = officer.getIdOfficerLogin();
        this.email = officer.getEmail();
        this.password = officer.getPassword();
        this.address = officer.getAddress();
        this.phoneNumber = officer.getPhoneNumber();
    }

    /**
     * Returns a officer's login id.
     *
     * @return a id officer login
     */
    public String getIdOfficerLogin() {
        return this.idOfficerLogin;
    }

    /**
     * Returns a officer's email.
     *
     * @return a email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns a officer's password.
     *
     * @return a password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns a officer's address.
     *
     * @return a address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns a officer's phone number.
     *
     * @return a phone number
     */
    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Updates a officer's login id.
     *
     * @param idOfficerLogin a new officer's login id
     */
    public void setIdOfficerLogin(String idOfficerLogin) {
        this.idOfficerLogin = idOfficerLogin;
    }

    /**
     * Updates a officer's email.
     *
     * @param email a new officer's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Updates a officer's password.
     *
     * @param password a new officer's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Updates a officer's address.
     *
     * @param address a new officer's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Updates a officer's phone number.
     *
     * @param phoneNumber a new officer's phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Displays a officer's information on the screen.
     *
     * @return officer's information
     */
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Officer:\n");
        s.append("Officer's login ID: " + this.idOfficerLogin + ".\n");
        s.append("Officer's email: " + this.email + ".\n");
        s.append("Officer's password: " + this.password + ".\n");
        s.append("Officer's address: " + this.address + ".\n");
        s.append("Officer's phoneNumber: " + this.phoneNumber + ".\n\n");

        return s.toString();
    }

    /**
     * Method that compares if two officers are the same.
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
        Officer test = (Officer) o;

        return test.email.equals(this.email) &&
                test.password.equals(this.password) && test.address.equals(this.address);
    }

    /**
     * Makes a copy of a officer.
     *
     * @return a clone of this instance
     */
    public Officer clone(){
        return new Officer(this);
    }

    /**
     * Verifies if the ID and password gaven matches the officer's ID and passowrd
     *
     * @param id officer's id
     * @param password officer's password
     * @return true if matches, false if not
     */
    public boolean validateCredentials(String id, String password) {
        return this.idOfficerLogin == id && this.password.equals(password);
    }
}
