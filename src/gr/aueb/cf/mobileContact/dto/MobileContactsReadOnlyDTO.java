package gr.aueb.cf.mobileContact.dto;

public class MobileContactsReadOnlyDTO extends BaseDTO{
    private String firstname;
    private String lastname;
    private String phoneNumber;


    public MobileContactsReadOnlyDTO(){}


    public MobileContactsReadOnlyDTO(String firstname, String lastname, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
