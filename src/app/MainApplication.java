package app;

import domain.Student;
import service.NumberGenerator;
import service.StudentServices;
import util.validator.PeopleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static StudentServices studentServices = new StudentServices();
    public static Student[] staticArrayStudents = new Student[50];
    public static List<Student> dynamicArrayStudents = new ArrayList<>();
    public static int studentCount = 0;

    public static void menu() {
        System.out.println("================================STATIC ARRAY===================================");
        System.out.println("(1)  Add student to the static array.");
        System.out.println("(2)  Find student by ID.");
        System.out.println("(3)  Update student by ID.");
        System.out.println("(4)  Delete student by ID.");
        System.out.println("(5)  Show students of static arrays.");
        System.out.println("(6)  Change data from STATIC ARRAYS to DYNAMIC ARRAYS !.");
        System.out.println("================================DYNAMIC ARRAY===================================");
        System.out.println("CRUD dynamic arr code is similar to static arr | Method: add, get, set, remove");
        System.out.println("(7)  Add student to the dynamic arrays.");
        System.out.println("(8)  Displays the percentage of academic ability students from high to low.");
        System.out.println("(9)  Displays the average score percentage of the students.");
        System.out.println("(10) Displays a list of students by academic ability.");
        System.out.println("(11) Show students of dynamic arrays.");
        System.out.println("(0). Exit application ! & Save student list to file !.");
        System.out.println("=================================================================================");
    }

    public static void fakeDataStaticArr() {
        staticArrayStudents[studentCount] = new Student(NumberGenerator.generateId(), "Hao",
                PeopleValidator.stringToLocalDate("3002-09-23"), "HN", 76.0, 67.0, "0987654321", "UNE", 2003, 9.0);
        studentCount++;
        staticArrayStudents[studentCount] = new Student(NumberGenerator.generateId(), "Nam",
                PeopleValidator.stringToLocalDate("3002-09-23"), "HN", 76.0, 67.0, "0987654321", "UET", 2003, 6.0);
        studentCount++;
        staticArrayStudents[studentCount] = new Student(NumberGenerator.generateId(), "Long",
                PeopleValidator.stringToLocalDate("3002-09-23"), "HN", 76.0, 67.0, "0987654321", "UET", 2003, 3.0);
        studentCount++;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        fakeDataStaticArr();
        do {
            menu();
            do {
                try {
                    System.out.print("Enter the choice: ");
                    choice = Integer.parseInt(input.nextLine().trim());
                } catch (Exception ex) {
                    System.out.println("Choice is not in correct format ! Please Re enter choice !");
                }
            } while (choice == -1);

            switch (choice) {
                case 1:
                    studentServices.addToStaticArr(staticArrayStudents);
                    break;
                case 2:
                    studentServices.findById(staticArrayStudents, studentCount);
                    break;
                case 3:
                    studentServices.updateById(staticArrayStudents, studentCount);
                    break;
                case 4:
                    boolean isValid = false;
                    int idDelete = 0;
                    do {
                        try {
                            System.out.print("Enter the id of students delete: ");
                            idDelete = Integer.parseInt(input.nextLine());
                            isValid = true;
                        } catch (Exception ex) {
                            System.out.println("Id is not in correct format ! Please Re enter id !");
                        }
                    } while (!isValid);
                    // Compare the origin array length with the array length after delete.
                    if (studentCount > studentServices.deleteById(staticArrayStudents, studentCount, idDelete)) {
                        studentCount--;
                        System.out.println("Delete success !");
                    }
                    break;
                case 5:
                    studentServices.displayStudentOfStaticArr(staticArrayStudents, studentCount);
                    break;
                case 6:
                    if (studentServices.dataStaticToDynamic(staticArrayStudents, studentCount, dynamicArrayStudents)) {
                        studentCount = 0;
                        System.out.println("Change data success !");
                    } else {
                        System.out.println("Change data Fail !");
                    }
                    break;
                case 7:
                    studentServices.addToDynamicArr(dynamicArrayStudents);
                    break;
                case 8:
                    studentServices.compareByAcademicPercentage(dynamicArrayStudents);
                    break;
                case 9:
                    studentServices.displayAveragePercentage(dynamicArrayStudents);
                    break;
                case 10:
                    studentServices.displayByAcademic(dynamicArrayStudents);
                    break;
                case 11:
                    studentServices.displayStudentOfDynamicArr(dynamicArrayStudents);
                    break;
                case 0:
                    studentServices.writeFile(dynamicArrayStudents);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please re enter choice !");
                    break;
            }
        } while (choice != 0);
    }
}
