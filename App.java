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
        listStudents.addStudents(new Student(1023223l, "Hoang Kim Tung", (short) 2007, 5.65f));
        listStudents.addStudents(new Student(1023225l, "Ta Hoang Hiep", (short) 2010, 5.65f));
        listStudents.addStudents(new Student(9403253l, "Nguyen Van Anh", (short) 2004, 7.95f));
        listStudents.addStudents(new Student(203294l, "Duong Quan Hoa", (short) 2003, 8f));
        listStudents.addStudents(new Student(1232445l, "Ta Thanh Tu", (short) 1999, 4.3f));
        short selection = 0;
        try {
            clearConsole();
            System.out.println("Choose what you want to do now :");
            System.out.println("1. Add student.\n" + "2. Print all student.\n"
                    + "3. Check StudentList is empty.\n" + "4. Get average mark of students.\n"
                    + "5. Clear all data in list.\n" + "6. Check a student in list by id.\n"
                    + "7. Delete a student in list.\n" + "8. Update student in list by id.\n"
                    + "9. Search student by name\n" + "10. Sort and export student.\n" + "0. Exit.\n");
            System.out.print("Enter your choice : ");
            selection = scan.nextShort();
        } catch (Exception e) {
            System.out.println("Command not found!");
            System.exit(selection);
        }

        
        switch (selection) {
            case 1:
                // + "1. Add student."
                try {
                    clearConsole();
                    System.out.println("Enter all fields below");
                    System.out.print("Name : ");
                    String name = scan.next();
                    System.out.print("Birth : ");
                    Short birth = scan.nextShort();
                    System.out.print("Code : ");
                    Long code = scan.nextLong();
                    System.out.print("AverageMark : ");
                    Float averageMark = scan.nextFloat();
                    Student student = new Student(code, name, birth, averageMark);
                    listStudents.addStudents(student);
                    System.out.println("________________Successed! Below is new Student List____________________________");
                    listStudents.displayStudents();
                    System.out.println();
                    System.out.println("Total student : " + listStudents.getTotalStudents());
                    break;
                } catch (Exception e) {
                    System.out.println("Error, re-run to complete the pending progress");
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
                System.out.println("List now is " + (listStudents.isEmpty() ? "empty" : "not empty"));
                break;

            case 4:
                // + "4. Get average of students.\n"
                clearConsole();
                System.out.println("Average mark : " + listStudents.averageMarkOfClass());
                listStudents.displayStudents();
                break;

            case 5:
                // + "5. Clear all data in list.\n"
                clearConsole();
                System.out.println("Do you want to clear all?\n1. Type true to agree\n2. Type false to cancel and exit");
                try {
                    Boolean select = scan.nextBoolean();
                    if (select) {
                        listStudents.clearAll();
                        System.out.println("Total student : " + listStudents.getTotalStudents());
                        listStudents.displayStudents();
                        break;
                    }
                    System.out.println("Exiting....");
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println("Error, please type \"true\" or \"false\"!!!");
                }
                break;

            case 6:
                // + "6. Check a student in list by id.\n"
                if (!listStudents.isEmpty()) {
                    clearConsole();
                    try {
                        System.out.print("Enter id : ");
                        Integer id = scan.nextInt();
                        Student student = listStudents.isExist(id, null);
                        if (student != null) {
                            listStudents.displayStudent(student);
                        }
                        else System.out.println("Not found id " + id);
                    } catch (Exception e) {
                        System.out.println("Id must be a number!");
                    }
                    break; 
                }
                System.out.println("List empty");
                break;
                
            
            case 7:
                // + "7. Delete a student in list.\n"
                if (!listStudents.isEmpty()) {
                    clearConsole();
                    try {
                        System.out.print("Enter id : ");
                        Integer id = scan.nextInt();
                        Student student = listStudents.isExist(id, null);
                        if (student != null) {
                            listStudents.removeStudent(id);
                            listStudents.displayStudents();
                        }
                    } catch (Exception e) {
                        System.out.println("Id must be a number!");
                    }
                    break;
                }
                System.out.println("List empty");
                break;

            case 8:
                // + "8. Update student by id / code.\n"
                if (listStudents.isEmpty()) {
                    System.out.println("List empty");
                    break;
                }
                clearConsole();
                try {
                    System.out.print("Enter id : ");
                    Integer id = scan.nextInt();
                    Student student = listStudents.isExist(id, null);
                    if (student != null) {
                        try {
                            System.out.println("Enter code, name, birth, mark : ");
                            Long code = scan.nextLong();
                            String name = scan.next();
                            Short birth = scan.nextShort();
                            Float mark = scan.nextFloat();

                            listStudents.updateStudent(code, name, birth, mark, id);
                            clearConsole();
                            System.out.println("Updating...");
                            listStudents.displayStudents();
                        } catch (Exception e) {
                            System.out.println("Error, type wrong");
                        }
                        break;
                    } 
                    else {
                        System.out.println("Not found id " + id);
                    }
                    } catch (Exception e) {
                    System.out.println("Id must be a number!");
                }
                break;
            case 9:

                // + "9. Search student by name\n"
                if (!listStudents.isEmpty()) {
                    System.out.print("Enter name : ");
                    String name = scan.next();
                    ArrayList<Student> listRS = listStudents.searchName(name);
                    System.out.println("\nFound " + listRS.size() + " results\n");
                    for (Student std : listRS) {
                        listStudents.displayStudent(std);
                    }
                    break;
                }
            case 10:

                // + "10. Sort and export student.\n"
                if (!listStudents.isEmpty()) {
                    ArrayList<Student> rs = listStudents.sortDescByMark();
                    clearConsole();
                    System.out.println("Id\t" + "Code" + "\t" + "\t" + "Name" + "\t" + "\t" + "\tBirth" + "\t" + "\t"
                    + "Average Mark");
                    for (Student student : rs) {
                        System.out.println(student.toString());
                    }
                }
                else {
                    System.out.println("List empty!");
                }
                break;

            case 0:
                // + "0. Exit.\n"
                System.exit(selection);
                break;
            }
    }
}