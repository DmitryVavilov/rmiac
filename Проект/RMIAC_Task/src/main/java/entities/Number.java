package entities;

public class Number {

    int id;
    String date;
    String time;
    String hospital;
    String doctorName;
    String status;
    int policy;

    public Number(){}

    public Number(int id, String date, String time, String hospital, String doctorName, String status){
        this.id = id;
        this.date = date;
        this.time = time;
        this.hospital = hospital;
        this.doctorName = doctorName;
        this.status = status;
    }

    public Number(String date, String time, String hospital, String doctorName, String status, int policy){
        this.date = date;
        this.time = time;
        this.hospital = hospital;
        this.doctorName = doctorName;
        this.status = status;
        this.policy = policy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String policy) {
        this.status = policy;
    }

    public int getPolicy() {
        return policy;
    }

    public void setPolicy(int policy) {
        this.policy = policy;
    }
}