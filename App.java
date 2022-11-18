import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentList listStudents = new StudentList();
        listStudents.addStudents(new Student(2203211l, "Pham Duy", (short) 2003, 8.4f));
        listStudents.addStudents(new Student(1023223l, "Hoang Thanh Tung", (short) 2007, 5.65f));
        listStudents.addStudents(new Student(1023225l, "Ta Hoang Hiep", (short) 2010, 5.65f));
        listStudents.addStudents(new Student(9403253l, "Nguyen Van Anh", (short) 2004, 7.95f));
        listStudents.addStudents(new Student(203294l, "Duong Quan Hoa", (short) 2003, 8f));
        listStudents.addStudents(new Student(1232445l, "Ta Thanh Tu", (short) 1999, 4.3f));
        short selection = 0;
        try {
            do {
                clearConsole();
                System.out.println("Choose what you want to do now :");
                System.out.println("1. Add student.\n" + "2. Print all student.\n"
                        + "3. Check StudentList is empty.\n" + "4. Get total students.\n"
                        + "5. Clear all data in list.\n" + "6. Check a student in list by id.\n"
                        + "7. Delete a student in list.\n" + "8. Update student in list by id.\n"
                        + "9. Search student by name\n" + "10. Sort and export student.\n" + "0. Exit.\n");
                System.out.print("Enter your choice : ");
                selection = scan.nextShort();
            } while (selection < 0 || selection >= 10);
        } catch (Exception e) {
            System.out.println("Command not found!");
            System.exit(selection);
        }

        
        switch (selection) {
            case 1:
                // + "1. Add student.\n"
                try {
                    clearConsole();
                    System.out.println("Enter all fields below");
                    System.out.print("Name :");
                    String name = scan.next();
                    System.out.print("Birth :");
                    Short birth = scan.nextShort();
                    System.out.print("Code :");
                    Long code = scan.nextLong();
                    System.out.print("AverageMark : ");
                    Float averageMark = scan.nextFloat();
                    Student student = new Student(code, name, birth, averageMark);
                    listStudents.addStudents(student);
                    System.out.println("__________Successed! Below is new Student List_____________");
                    listStudents.displayStudents();
                    System.out.println();
                    System.out.println("Total student : " + listStudents.getTotalStudents());
                    System.out.println("Average of class : " + listStudents.averageMarkOfClass());
                    break;
                } catch (Exception e) {
                    System.out.println("Error, re-run to refill. Error : " + e);
                    break;
                }

            case 2:
                // + "2. Print all student.\n"
                clearConsole();
                System.out.println();
                System.out.println("________________Current students_______________");
                listStudents.displayStudents();
                System.out.println("Total student : " + listStudents.getTotalStudents());
                System.out.println();
                break;

            case 3:
                // + "3. Check StudentList is empty.\n"
                clearConsole();
                if (!listStudents.checkIsEmpty()) {
                    System.out.println(listStudents.checkIsEmpty());
                }
                break;

            case 4:
                // + "4. Get number of students.\n"
                clearConsole();
                System.out.println("Total student : " + listStudents.getTotalStudents());
                break;

            case 5:
                // + "5. Clear all data in list.\n"
                clearConsole();
                if (listStudents.clearAllStudents()) {
                    listStudents.displayStudents();
                    System.out.println("Total student : " + listStudents.getTotalStudents());
                }
                break;

            case 6:
                // + "6. Check a student in list by id.\n"
                if (listStudents.checkIsEmpty()) {
                    System.out.println("List empty");
                    break;
                }
                clearConsole();
                try {
                    System.out.print("Enter id : ");
                    Long id = scan.nextLong();
                    listStudents.displayStudent(id);
                    break;
                } catch (Exception e) {
                    System.out.println("Id must be a number!");
                    break;
                }

            case 7:
                // + "7. Delete a student in list.\n"
                if (!listStudents.checkIsEmpty()) {
                    System.out.println("The progress is "
                            + ((listStudents.deleteAStudent())
                                    ? "successed"
                                    : "failure").toString());
                    break;
                }
                System.out.println("List students empty");
                break;

            case 8:
                // + "8. Update student by id.\n"
                if (!listStudents.checkIsEmpty()) {
                    System.out.println("The progress is "
                            + ((listStudents.updateStudent())
                                    ? "successed"
                                    : "failure").toString());
                    break;
                }
                System.out.println("List Students empty");
                break;
            case 9:

                // + "9. Search student by name\n"
                if (!listStudents.checkIsEmpty()) {
                    ArrayList<Student> listRS = listStudents.searchName();
                    if (listRS == null) {
                        System.out.println("Not found name!");
                        break;
                    }
                    System.out.println("Found " + listRS.size() + " results");
                    for (Student std : listRS) {
                        listStudents.displayStudent(std.getId());
                        System.out.println();
                    }
                    break;
                }
                break;
            case 10:

                // + "10. Sort and export student.\n"
                break;

            case 0:
                // + "0. Exit.\n"
                System.exit(selection);
                break;
            }
            scan.locale();
    }
        
        
        
}