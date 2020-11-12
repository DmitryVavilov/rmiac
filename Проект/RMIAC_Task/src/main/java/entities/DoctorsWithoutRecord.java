package entities;

public class DoctorsWithoutRecord {

    String hospital;
    int number;

    public DoctorsWithoutRecord(){}

    public DoctorsWithoutRecord(String hospital, int number){
        this.hospital = hospital;
        this.number = number;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}