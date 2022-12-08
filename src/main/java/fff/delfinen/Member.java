package fff.delfinen;


import java.time.LocalDate;

public class Member {

    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String address;
    private int postalCode;
    private String city;
    private int phoneNo;
    private String eMail;
    private boolean passive;
    private boolean junior;
    private boolean exercise;
    private boolean Paid;

    public Member(String firstname, String lastname, LocalDate birthDate, String address, int postalCode,
                  String city, int phoneNo, String eMail, boolean passive, boolean junior,
                  boolean exercise, boolean Paid){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNo = phoneNo;
        this.eMail = eMail;
        this.passive = passive;
        this.junior = junior;
        this.exercise = exercise;
        this.Paid = Paid;

    }
    public Member() {
    }

    //Getter
    public String getFirstname() {
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean isPassive() {
        return passive;
    }

    public boolean isJunior() {
        return junior;
    }

    public boolean isExercise() {
        return exercise;
    }

    public boolean isPaid(){
        return Paid;
    }

    //Setter
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPaid(boolean paid){
        this.Paid = paid;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }

    public void setJunior(boolean junior) {
        this.junior = junior;
    }

    public void setExercise(boolean exercise) {
        this.exercise = exercise;
    }
}





