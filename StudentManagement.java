import java.util.*;

class Student {
    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\ncourse: " + course;

    }
}

public class StudentManagement {
    private static Map<Integer, Student> studentRes = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewDetails();
                    break;

                case 3:
                    search();
                    break;

                case 4:
                    updateDetails();
                    break;

                case 5:
                    remove();
                    break;

                case 6:
                    flag = false;
                    System.out.println("Exiting......");
                    break;

                default:
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n........... Student Management System.........\n");
        System.out.println("1. Add student details");
        System.out.println("2. view all details.");
        System.out.println("3. search student with Id");
        System.out.println("4. update student Details");
        System.out.println("5. Remove student");
        System.out.println("6. Exit");
        System.out.println("Enter your choice...");
    }

    public static void addStudent() {
        System.out.print("Enter the ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student student = new Student(id, name, course);
        studentRes.put(id, student);
        System.out.println("Student Added Successfully.....");
        System.out.println(studentRes);
    }

    public static void viewDetails() {
        if (!studentRes.isEmpty()) {
            for (Student val : studentRes.values()) {
                System.out.println(val);
            }
        } else {
            System.out.println("No Result Found.....");
        }
    }

    public static void search() {
        System.out.println("Enter Student ID to get Details: ");
        int id = sc.nextInt();

        if (studentRes.containsKey(id)) {
            System.out.println(studentRes.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void updateDetails() {
        System.out.println("Enter Student ID to update:");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentRes.containsKey(id)) {
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new course: ");
            String course = sc.nextLine();

            Student updatedStudent = new Student(id, name, course);
            studentRes.put(id, updatedStudent);
            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void remove() {
        System.out.println("Enter the Student ID to Remove: ");
        int id = sc.nextInt();
        if (studentRes.remove(id) != null) {
            System.out.println("Student Removed Successfully...");
        } else {
            System.out.println("Student Not Found.");
        }
    }
}