package entities;

public class Doctor {

    String fullName;
    String specialty;
    String hospital;

    public Doctor(){}

    public Doctor(String fullName, String specialty, String hospital){
        this.fullName = fullName;
        this.specialty = specialty;
        this.hospital = hospital;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}