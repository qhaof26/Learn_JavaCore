package service;


import app.MainApplication;
import constant.AcademicAbility;
import constant.AppConst;
import domain.Student;
import validator.PeopleValidator;
import validator.StudentValidator;

import java.io.*;
import java.util.*;

public class StudentServices {
    public static Scanner input = new Scanner(System.in);
    public static int id;
    public static boolean isValid = false;

    public static void fillInformation(Student student){
        String fullName, dateOfBirth, address, studentCode, school;
        double height = 0, weight = 0, averageScore = 0;
        int yearBegin = 0;
        do{
            System.out.print("Full Name: ");
            fullName = input.nextLine();
            if(PeopleValidator.validateFullName(fullName)) {
                System.out.println(AppConst.FULL_NAME_REQUIRED);
            } else{
                student.setFullName(fullName);
            }
        } while (PeopleValidator.validateFullName(fullName));

        do{
            System.out.print("Date of Birth (YYYY-MM-dd): ");
            dateOfBirth = input.nextLine();
            if(PeopleValidator.validateDateOfBirth(dateOfBirth)) {
                System.out.println(AppConst.DATE_OF_BIRTH_REQUIRED);
            } else{
                student.setDateOfBirth(PeopleValidator.stringToLocalDate(dateOfBirth));
            }
        } while (PeopleValidator.validateDateOfBirth(dateOfBirth));

        do{
            System.out.print("Address: ");
            address = input.nextLine();
            if(PeopleValidator.validateAddress(address)){
                System.out.println(AppConst.ADDRESS_REQUIRED);
            } else {
                student.setAddress(address);
            }
        } while (PeopleValidator.validateAddress(address));

        do{
            try{
                System.out.print("Height: ");
                height = Double.parseDouble(input.nextLine());
                if(PeopleValidator.validateHeight(height)){
                    System.out.println(AppConst.HEIGHT_REQUIRED);
                } else {
                    student.setHeight(height);
                }
            } catch (NumberFormatException ex){
                System.out.println("Error format ! Please re enter Height !");
            }
        } while (PeopleValidator.validateHeight(height));

        do{
            try{
                System.out.print("Weight: ");
                weight = Double.parseDouble(input.nextLine());
                if(PeopleValidator.validateWeight(weight)){
                    System.out.println(AppConst.WEIGHT_REQUIRED);
                } else {
                    student.setWeight(weight);
                }
            } catch (NumberFormatException ex){
                System.out.println("Error format ! Please re enter Weight !");
            }
        } while (PeopleValidator.validateWeight(weight));

        do{
            System.out.print("Student code: ");
            studentCode = input.nextLine();
            if(StudentValidator.validateStudentCode(studentCode)){
                System.out.println(AppConst.STUDENT_CODE_REQUIRED);
            } else {
                student.setStudentCode(studentCode);
            }
        } while (StudentValidator.validateStudentCode(studentCode));

        do{
            System.out.print("School: ");
            school = input.nextLine();
            if(StudentValidator.validateSchool(school)){
                System.out.println(AppConst.SCHOOL_REQUIRED);
            } else {
                student.setSchool(school);
            }
        } while (StudentValidator.validateSchool(school));

        do{
            try{
                System.out.print("Year begin: ");
                yearBegin = Integer.parseInt(input.nextLine());
                if(StudentValidator.validateYearBegin(yearBegin)){
                    System.out.println(AppConst.YEAR_BEGIN_REQUIRED);
                } else {
                    student.setYearBegin(yearBegin);
                }
            } catch (NumberFormatException ex){
                System.out.println("Error format ! Please re enter Year Begin !");
            }

        } while (StudentValidator.validateYearBegin(yearBegin));

        do{
            try{
                System.out.print("Average score: ");
                averageScore = Double.parseDouble(input.nextLine());
                if(StudentValidator.validateAverageScore(averageScore)){
                    System.out.println(AppConst.AVERAGE_SCORE_REQUIRED);
                } else {
                    student.setAverageScore(averageScore);
                }
            } catch (NumberFormatException ex){
                System.out.println("Error format ! Please re enter Average score !");
            }
        } while (StudentValidator.validateAverageScore(averageScore));
        student.updateAcademicAbility();
    }

    public Student create(){
        Student student = new Student();
        student.setId(NumberGenerator.generateId());
        fillInformation(student);
        return student;
    }

    // STATIC ARRAY
    public void addToStaticArr(Student[] arrStudent){
        int numberOfStudent = 0;
        do{
            try{
                System.out.print("Enter the number of students: ");
                numberOfStudent = Integer.parseInt(input.nextLine());
            } catch (Exception ex){
                System.out.println("Number is not in correct format ! Please Re enter number !");
            }
        } while (numberOfStudent == 0);
        if(MainApplication.studentCount < arrStudent.length){
            for (int i = 0; i < numberOfStudent; i++){
                arrStudent[MainApplication.studentCount] = create();
                System.out.println("Added !");
                System.out.println(arrStudent[MainApplication.studentCount].toString());
                MainApplication.studentCount++;
            }
        } else {
            System.out.println("Static arrays student is full !");
        }
    }

    public void displayStudentOfStaticArr(Student[] arrStudent, int lengthArr){
        if(lengthArr == 0){
            System.out.println("Static arrStudent is empty !");
        } else if(lengthArr > 0){
            System.out.println("5. Show students of static arrays");
            for(int i = 0; i < lengthArr; i++){
                System.out.println(arrStudent[i].toString());
            }
        }
    }

    public Student isExistsById(Student[] arrStudent, int lengthArr, int id){
        for(int i = 0; i < lengthArr; i++){
            if(arrStudent[i].getId() == id){
                return arrStudent[i];
            }
        }
        return null;
    }

    public void findById(Student[] arrStudent, int lengthArr){
        do{
            try{
                System.out.print("Enter the id of students: ");
                id = Integer.parseInt(input.nextLine());
                isValid = true;
            } catch (Exception ex){
                System.out.println("Id is not in correct format ! Please Re enter id !");
            }
        } while (!isValid);
        if(isExistsById(arrStudent, lengthArr , id) != null){
            System.out.println("Success !");
            System.out.println(isExistsById(arrStudent, lengthArr, id).toString());
        } else{
            System.out.println("Student not found !");
        }
        isValid = false;
    }

    public void updateById(Student[] arrStudent, int lengthArr){
        do{
            try{
                System.out.print("Enter the id of students update: ");
                id = Integer.parseInt(input.nextLine());
                isValid = true;
            } catch (Exception ex){
                System.out.println("Id is not in correct format ! Please Re enter id !");
            }
        } while (!isValid);
        if(isExistsById(arrStudent, lengthArr, id) != null){
            System.out.println("Student before update: ");
            System.out.println(isExistsById(arrStudent, lengthArr, id).toString());
            System.out.println("Update information: ");
            fillInformation(isExistsById(arrStudent, lengthArr, id));
            System.out.println("Student after update:");
            System.out.println(isExistsById(arrStudent, lengthArr, id).toString());
        } else{
            System.out.println("Student not found !");
        }
        isValid = false;
    }

    public int deleteById(Student[] arrStudent, int lengthArr, int id){
        int index = 0;
        if(isExistsById(arrStudent, lengthArr, id) != null){
            try {
                for(int i = 0; i < lengthArr; i++){
                    if(arrStudent[i].getId() == id){
                        index = i;
                        break;
                    }
                }
                for(int i = index; i < lengthArr; i++){
                    if(i < (lengthArr - 1)){
                        arrStudent[i] = arrStudent[i+1];
                    } else if(i == (lengthArr - 1)){
                        arrStudent[i] = null;
                        --lengthArr;
                        break;
                    }
                }
                return lengthArr;
            } catch (Exception exception){
                System.out.println(exception.getLocalizedMessage());
            }
        } else {
            System.out.println("Student not found !");
            return lengthArr;
        }
        return lengthArr;
    }

    public boolean dataStaticToDynamic(Student[] staticArr, int lengthArr, List<Student> dynamicArr){
        int count = 0;
        if(lengthArr == 0){
            return false;
        } else{
            for(int i = 0; i < lengthArr; i++){
                dynamicArr.add(staticArr[i]);
                staticArr[i] = null;
                count++;
            }
            return count == lengthArr;
        }
    }

    // DYNAMIC ARRAY
    public void displayStudentOfDynamicArr(List<Student> studentList){
        if(studentList.isEmpty()){
            System.out.println("Dynamic arrStudent is empty !");
        } else {
            System.out.println("(11) Show students of dynamic arrays.");
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
            System.out.println("Size = " + studentList.size());
        }
    }

    public void addToDynamicArr(List<Student> studentList){
        int numberOfStudent = 0;
        do{
            try{
                System.out.print("Enter the number of students: ");
                numberOfStudent = Integer.parseInt(input.nextLine());
            } catch (Exception ex){
                System.out.println("Number is not in correct format ! Please Re enter number !");
            }
        } while (numberOfStudent == 0);
        for (int i = 0; i < numberOfStudent; i++){
            Student studentNew = create();
            studentList.add(studentNew);
            if(studentNew != null){
                System.out.println("Added !");
                System.out.println(studentNew.toString());
            }else {
                System.out.println("Add Fail !");
            }

        }
    }

    public void compareByAcademicPercentage(List<Student> studentList){
        //List<Integer> listAcademic = new ArrayList<>();
        Map<String, Integer> listAcademic = new HashMap<>();
        int countExcellent = 0, countGood = 0, countRather = 0, countMedium = 0, countWeak = 0, countLeast = 0;
        for(Student student : studentList){
            if(student.getAcademicAbility().equals(AcademicAbility.EXCELLENT)){
                countExcellent++;
            } else if(student.getAcademicAbility().equals(AcademicAbility.GOOD)){
                countGood++;
            } else if(student.getAcademicAbility().equals(AcademicAbility.RATHER)){
                countRather++;
            } else if(student.getAcademicAbility().equals(AcademicAbility.MEDIUM)){
                countMedium++;
            } else if(student.getAcademicAbility().equals(AcademicAbility.WEAK)){
                countWeak++;
            } else if(student.getAcademicAbility().equals(AcademicAbility.LEAST)){
                countLeast++;
            }
        }
        listAcademic.put("excellent", countExcellent);
        listAcademic.put("good", countGood);
        listAcademic.put("rather", countRather);
        listAcademic.put("medium", countMedium);
        listAcademic.put("weak", countWeak);
        listAcademic.put("least", countLeast);
        System.out.println("(8)  Displays the percentage of academic ability students from high to low.");
        System.out.println("");
    }

    public void displayAveragePercentage(List<Student> studentList){
        Map<Double, Integer> scoreCountMap = new HashMap<>();
        List<Double> listScore = new ArrayList<>();
        for(Student student : studentList){
            listScore.add(student.getAverageScore());
        }
        for (double score : listScore) {
            scoreCountMap.put(score, scoreCountMap.getOrDefault(score, 0) + 1);
        }
        double numberOfScore = listScore.size();
        for (Map.Entry<Double, Integer> entry : scoreCountMap.entrySet()) {
            double percentage = (entry.getValue() / numberOfScore) * 100;
            System.out.println("Score: " + entry.getKey() + " - Percentage: " + percentage + " %");
        }
    }

    public void displayByAcademic(List<Student> studentList){
        String academic;
        boolean check = false;
        do{
            System.out.print("Please enter Academic (EXCELLENT, GOOD, RATHER, MEDIUM, WEAK, LEAST): ");
            academic = input.nextLine();
            if(StudentValidator.validateSchool(academic)) {
                System.out.println("Please re enter Academic !");
            }
        } while (PeopleValidator.validateFullName(academic));
        try{
            for(Student student : studentList){
                if(student.getAcademicAbility().equals(AcademicAbility.valueOf(academic.toUpperCase()))){
                    System.out.println(student.toString());
                    check = true;
                }
            }
        } catch (IllegalArgumentException ex){
            //System.out.println("Student academic: " + academic + " not exists !");
        }
        if(check == false){
            System.out.println("Student academic: " + academic + " not exists !");
        }
    }

    public void writeFile(List<Student> studentList){
        File file = new File("students.txt");
        boolean check = false;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for(Student student : studentList){
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
                check = true;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        if(check != false){
            System.out.println("Saved File !");
        } else {
            System.out.println("Save file Fail !");
        }
    }
}
