package domain;

import constant.AcademicAbility;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends People implements Serializable {
    private String studentCode;
    private String school;
    private Integer yearBegin;
    private Double averageScore;
    private AcademicAbility academicAbility;

    public void updateAcademicAbility(){
        if(this.averageScore < 3){
            academicAbility = AcademicAbility.LEAST;
        } else if(this.averageScore >= 3 && this.averageScore < 5){
            academicAbility = AcademicAbility.WEAK;
        } else if(this.averageScore >= 5 && this.averageScore < 6.5){
            academicAbility = AcademicAbility.MEDIUM;
        } else if(this.averageScore >= 6.5 && this.averageScore < 7.5){
            academicAbility = AcademicAbility.RATHER;
        } else if(this.averageScore >= 7.5 && this.averageScore < 9){
            academicAbility = AcademicAbility.GOOD;
        }  else if(this.averageScore >= 9.0 && this.averageScore <= 10){
            academicAbility = AcademicAbility.EXCELLENT;
        }
    }
    public Student() {
    }

    public Student(Integer id, String fullName, LocalDate dateOfBirth, String address, Double height, Double weight,
                   String studentCode, String school, Integer yearBegin, Double averageScore) {
        super(id, fullName, dateOfBirth, address, height, weight);
        this.studentCode = studentCode;
        this.school = school;
        this.yearBegin = yearBegin;
        this.averageScore = averageScore;
        updateAcademicAbility();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getYearBegin() {
        return yearBegin;
    }

    public void setYearBegin(Integer yearBegin) {
        this.yearBegin = yearBegin;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public AcademicAbility getAcademicAbility() {
        return academicAbility;
    }

    public void setAcademicAbility(AcademicAbility academicAbility) {
        this.academicAbility = academicAbility;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + super.getId() +
                ", fullName='" + super.getFullName() + '\'' +
                ", dateOfBirth=" + super.getDateOfBirth() +
                ", address='" + super.getAddress() + '\'' +
                ", height=" + super.getHeight() +
                ", weight=" + super.getWeight() +
                ", studentCode='" + studentCode + '\'' +
                ", school='" + school + '\'' +
                ", yearBegin=" + yearBegin +
                ", averageScore=" + averageScore +
                ", academicAbility=" + academicAbility +
                '}';
    }
}
