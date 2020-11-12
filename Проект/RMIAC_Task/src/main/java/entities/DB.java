package entities;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    private static final String url = "jdbc:mysql://localhost:3306/rmiac_task?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String username = "root";
    private static final String password = "123456";

    public static ArrayList<Number> getSchedule() {

        ArrayList<Number> schedule = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM number");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String date = resultSet.getString(2);
                    String time = resultSet.getString(3);
                    String hospital = resultSet.getString(4);
                    String doctorName = resultSet.getString(5);
                    String status = resultSet.getString(6);
                    Number scheduleElem = new Number(id, date, time, hospital, doctorName, status);
                    schedule.add(scheduleElem);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return schedule;
    }

    public static Patient checkPatient(String surname, int policy){

        Patient patient = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM patients WHERE surname=? and policy=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, surname);
                    preparedStatement.setInt(2, policy);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int policyPatient = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String surnamePatient = resultSet.getString(3);
                        String patronymic = resultSet.getString(4);
                        patient = new Patient(policyPatient, name, surnamePatient, patronymic);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return patient;
    }

    public static boolean isRecordInTable(Number number){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM number WHERE policy IS NULL AND date = ? AND time = ? AND doctorName = ?;";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, number.getDate());
                    preparedStatement.setString(2, number.getTime());
                    preparedStatement.setString(3, number.getDoctorName());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next())
                        return true;
                }
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public static void appointmentRecord(String hospital){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO recordingAndCanceling (hospital, date, record) VALUES (?, CURRENT_DATE(), 1)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, hospital);
                    preparedStatement.executeUpdate();
                }
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static int appointmentPatient(Number number){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                if (isRecordInTable(number)) {
                    String sql = "UPDATE number SET status=?, policy=? WHERE date=? and time=? and doctorName=?";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setString(1, number.getStatus());
                        preparedStatement.setInt(2, number.getPolicy());
                        preparedStatement.setString(3, number.getDate());
                        preparedStatement.setString(4, number.getTime());
                        preparedStatement.setString(5, number.getDoctorName());
                        appointmentRecord(number.getHospital());
                        return preparedStatement.executeUpdate();
                    }
                }
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static void appointmentCancel(String hospital){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO recordingAndCanceling (hospital, date, cancel) VALUES (?, CURRENT_DATE(), 1)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, hospital);
                    preparedStatement.executeUpdate();
                }
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static int cancelAppointment(int policy, String date, String time, String hospital, String doctorName){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "UPDATE number SET status='Запись свободна', policy=null WHERE policy=? AND date=? AND time=? AND doctorName=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, policy);
                    preparedStatement.setString(2, date);
                    preparedStatement.setString(3, time);
                    preparedStatement.setString(4, doctorName);
                    appointmentCancel(hospital);
                    return preparedStatement.executeUpdate();
                }
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int[] numberCancelRecord(String hospital, String date1, String date2){

        int[] mass;
        mass = new int[2];
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT SUM(record), SUM(cancel) FROM recordingAndCanceling WHERE hospital = ? AND date BETWEEN ? AND ?;";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, hospital);
                    preparedStatement.setString(2, date1);
                    preparedStatement.setString(3, date2);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int numberRecord = resultSet.getInt(1);
                        int numberCancel = resultSet.getInt(2);
                        mass[0] = numberRecord;
                        mass[1] = numberCancel;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return mass;
    }

    public static DoctorsWithoutRecord doctorsWithoutRecord(String hospital, String date1, String date2){

        DoctorsWithoutRecord doctorsWithoutRecord = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT hospital, COUNT(DISTINCT(doctorName)) FROM number WHERE hospital = ? AND policy IS NULL AND date BETWEEN ? AND ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, hospital);
                    preparedStatement.setString(2, date1);
                    preparedStatement.setString(3, date2);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        String hospitalName= resultSet.getString(1);
                        int number = resultSet.getInt(2);
                        doctorsWithoutRecord = new DoctorsWithoutRecord(hospitalName, number);
                        return doctorsWithoutRecord;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return doctorsWithoutRecord;
    }

    public static ArrayList<PatientWithRecord> listPatientRecordOnDate(String date){

        ArrayList<PatientWithRecord> patientList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = ("SELECT patients.surname, patients.name, patients.patronymic, patients.policy, number.hospital, number.date, number.time FROM number INNER JOIN patients ON number.policy = patients.policy WHERE number.date = ? AND number.policy IS NOT NULL");
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, date);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String surname = resultSet.getString(1);
                        String name = resultSet.getString(2);
                        String patronymic = resultSet.getString(3);
                        int policy = resultSet.getInt(4);
                        String hospital = resultSet.getString(5);
                        String recordDate = resultSet.getString(6);
                        String time = resultSet.getString(7);
                        PatientWithRecord patientListElem = new PatientWithRecord(surname, name, patronymic, policy, hospital, recordDate, time);
                        patientList.add(patientListElem);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return patientList;
    }
}