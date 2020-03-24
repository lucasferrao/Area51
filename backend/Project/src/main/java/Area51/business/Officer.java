package Area51.business;

public class Officer {
    private int idOfficerLogin;
    private String email;
    private String password;
    private String address;
    private int phoneNumber;

    /**
     * Officer's default constructor.
     */
    public Officer(){
        this.idOfficerLogin = 0;
        this.email = "";
        this.password = "";
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
    public Officer(int idOfficerLogin, String email, String password, String address,
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

    //Geters
    public int getIdOfficerLogin() {
        return this.idOfficerLogin;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    //Setters
    public void setIdOfficerLogin(int idOfficerLogin) {
        this.idOfficerLogin = idOfficerLogin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
}
