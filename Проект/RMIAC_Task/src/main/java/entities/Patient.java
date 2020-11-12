package entities;

public class Patient {

    int policy;
    String name;
    String surname;
    String patronymic;

    public Patient(){}

    public Patient(int policy, String name, String surname, String patronymic){
        this.policy = policy;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public int getPolicy() {
        return policy;
    }

    public void setPolicy(int policy) {
        this.policy = policy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}