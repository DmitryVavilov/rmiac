package entities;

public class PatientWithRecord {

    String surname;
    String name;
    String patronymic;
    int policy;
    String hospital;
    String date;
    String time;

    public PatientWithRecord(){}

    public PatientWithRecord(String surname, String name, String patronymic, int policy, String hospital, String date, String time){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.policy = policy;
        this.hospital = hospital;
        this.date = date;
        this.time = time;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getPolicy() {
        return policy;
    }

    public void setPolicy(int policy) {
        this.policy = policy;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}