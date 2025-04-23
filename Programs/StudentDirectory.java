import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String id;
    double grade;


Student(String name, String id, double grade) {
    this.name = name;
    this.id = id;
    this.grade = grade; 
    }
void displayInfo(){
    System.out.println("Name: " + name + ", ID: " + id + ", Grade: " + grade);
    }
public class StudentDirectory {

    static ArrayList<StudentDirectory> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[]args) {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Student\n2. Display All\n3. Search by ID\n4. Remove by ID\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAll(); break;
                case 3: searchById(); break;
                case 4: removeById(); break;
                case 5: running = false; break;
                default: System.out.println("Invalid option."); break;
            }
        }
    }
    static void addStudent(){
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = Double.parseDouble(scanner.nextLine());

        StudentDirectory newStudent = new StudentDirectory(name, id, grade);
        students.add(newStudent);
        System.out.println("Student added.");
    }
    static void displayAll() {
        if(students.isEmpty()){
            System.out.println("No studnets found.");
        } else {
            for (StudentDirectory s : students){
                s.displayInfo();
            }
        }
    }
    static void searchById() {
        System.out.print("Enter ID to search: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (StudentDirectory s : students){
            if (s.id.equals(id)){
                s.displayInfo();
                found = true;
                break;
                }
            } if (!found) {
                System.out.println("Student not found.");
        } 
      }
      static void removeById(){
        System.out.print("Enter ID to remove: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).id.equals(id)){
                students.remove(i);
                found = true;
                System.out.println("Student removed.");
            }
        }
      }
}
}
