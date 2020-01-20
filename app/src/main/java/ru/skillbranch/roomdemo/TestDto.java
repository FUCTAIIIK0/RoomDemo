package ru.skillbranch.roomdemo;

public class TestDto {
    private String regSerial;
    private Boolean isOnline;
    //Tec
    private String userID;
    private String cityID;
    private String companyID;

    //DriverLicense
    private String driverNum;
    private String driverSeries;
    private Boolean driverA;
    private Boolean driverB;
    private Boolean driverC;
    private Boolean driverD;

    //User
    private String firstName;
    private String midleName;

    public TestDto(String regSerial, Boolean isOnline, String userID, String cityID, String companyID, String driverNum, String driverSeries, Boolean driverA, Boolean driverB, Boolean driverC, Boolean driverD, String firstName, String midleName, String lastName, String passportNum, String pasportSeries, String pasportIssue) {
        this.regSerial = regSerial;
        this.isOnline = isOnline;
        this.userID = userID;
        this.cityID = cityID;
        this.companyID = companyID;
        this.driverNum = driverNum;
        this.driverSeries = driverSeries;
        this.driverA = driverA;
        this.driverB = driverB;
        this.driverC = driverC;
        this.driverD = driverD;
        this.firstName = firstName;
        this.midleName = midleName;
        this.lastName = lastName;
        this.passportNum = passportNum;
        this.pasportSeries = pasportSeries;
        this.pasportIssue = pasportIssue;
    }

    public String getRegSerial() {
        return regSerial;
    }

    public void setRegSerial(String regSerial) {
        this.regSerial = regSerial;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getDriverSeries() {
        return driverSeries;
    }

    public void setDriverSeries(String driverSeries) {
        this.driverSeries = driverSeries;
    }

    public Boolean getDriverA() {
        return driverA;
    }

    public void setDriverA(Boolean driverA) {
        this.driverA = driverA;
    }

    public Boolean getDriverB() {
        return driverB;
    }

    public void setDriverB(Boolean driverB) {
        this.driverB = driverB;
    }

    public Boolean getDriverC() {
        return driverC;
    }

    public void setDriverC(Boolean driverC) {
        this.driverC = driverC;
    }

    public Boolean getDriverD() {
        return driverD;
    }

    public void setDriverD(Boolean driverD) {
        this.driverD = driverD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public String getPasportSeries() {
        return pasportSeries;
    }

    public void setPasportSeries(String pasportSeries) {
        this.pasportSeries = pasportSeries;
    }

    public String getPasportIssue() {
        return pasportIssue;
    }

    public void setPasportIssue(String pasportIssue) {
        this.pasportIssue = pasportIssue;
    }

    private String lastName;
    private String passportNum;
    private String pasportSeries;
    private String pasportIssue;
}
