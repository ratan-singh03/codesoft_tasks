import java.util.ArrayList;
import java.util.Scanner;

class Course {

    String code;
    String title;
    String description;
    int capacity;
    int registered;

    Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.registered = 0;
    }

    boolean hasSpace() {
        return registered < capacity;
    }
}

public class CourseRegistrationSystem {

    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<String> registeredCourses = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        courses.add(new Course(
                "CS101",
                "Java Programming",
                "Learn Java programming basics",
                3
        ));

        courses.add(new Course(
                "CS102",
                "Data Structures",
                "Learn arrays, stacks and queues",
                3
        ));

        courses.add(new Course(
                "CS103",
                "Database Management",
                "Learn SQL and databases",
                3
        ));

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:
                    System.out.print("Enter course code: ");
                    String registerCode = sc.next();

                    registerCourse(registerCode);
                    break;

                case 3:
                    System.out.print("Enter course code to drop: ");
                    String dropCode = sc.next();

                    dropCourse(dropCode);
                    break;

                case 4:
                    displayRegisteredCourses();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void displayCourses() {

        System.out.println("\n===== AVAILABLE COURSES =====");

        for (Course course : courses) {

            int available = course.capacity - course.registered;

            System.out.println("\nCourse Code: " + course.code);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Available Seats: " + available);
        }
    }

    static void registerCourse(String code) {

        for (Course course : courses) {

            if (course.code.equalsIgnoreCase(code)) {

                if (registeredCourses.contains(course.code)) {
                    System.out.println("You are already registered for this course.");
                    return;
                }

                if (course.hasSpace()) {

                    course.registered++;
                    registeredCourses.add(course.code);

                    System.out.println("Course registered successfully!");

                } else {
                    System.out.println("No seats available.");
                }

                return;
            }
        }

        System.out.println("Course not found.");
    }

    static void dropCourse(String code) {

        if (registeredCourses.remove(code.toUpperCase())) {

            for (Course course : courses) {

                if (course.code.equalsIgnoreCase(code)) {
                    course.registered--;
                    break;
                }
            }

            System.out.println("Course dropped successfully.");

        } else {
            System.out.println("You are not registered for this course.");
        }
    }

    static void displayRegisteredCourses() {

        System.out.println("\n===== REGISTERED COURSES =====");

        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {

            for (String code : registeredCourses) {
                System.out.println("- " + code);
            }
        }
    }
}