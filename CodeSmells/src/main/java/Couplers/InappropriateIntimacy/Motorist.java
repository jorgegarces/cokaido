package Couplers.InappropriateIntimacy;

public class Motorist {
    private License license;
    private String surname;
    private String firstName;
    private String title;

    public Motorist(License license, String surname, String firstName, String title)
    {
        license.setMotorist(this);
        this.license = license;
        this.surname = surname;
        this.firstName = firstName;
        this.title = title;
    }

    public License getLicense() {
        return license;
    }

    String getMotoristData() {
        return title + " " + firstName + " " + surname;
    }
}
