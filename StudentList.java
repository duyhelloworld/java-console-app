import java.util.ArrayList;
import java.util.Scanner;

public class StudentList{
    Scanner scan = new Scanner(System.in);
    private ArrayList<Student> listStudents;

    public StudentList() {
        this.listStudents = new ArrayList<Student>();
    }

    public StudentList(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // * Methods
    public void addStudents(Student student) {
        this.listStudents.add(student);
    }

    public Boolean checkIsEmpty() {
        return this.listStudents.isEmpty();
    }

    public void displayStudent(Long id) {
        Boolean hasId = false;
        for (Student student : listStudents) {
            if (student.getId() == id) {
                System.out.println(student.toObjectString());
                hasId = true;
                break;
            }
        }
        if (!hasId) {
            System.out.println("Not found id " + id);
        }
    }

    public void displayStudents() {
        System.out.println("Id\t" + "Code\t" + "\tName\t" + "\tBirth\t" + "\tAverage Mark");
        for (Student student : listStudents) {
            System.out.println(student.toString());
        }
    }

    public int getTotalStudents() {
        return listStudents.size();
    }

    public boolean clearAllStudents() {
        System.out.println("Do you want to clear all?\n1. Type true to agree\n2. Type false to cancel and exit");
        try {
            boolean confirm = scan.nextBoolean();
            if (confirm) {
                clearConsole();
                listStudents.clear();
                // - Or
                // this.listStudents.removeAll(listStudents);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error when typing command!!!\nRe-run to complete the pending progress!");
        }
        return false;
    }

    public float averageMarkOfClass() {
        float totalMark = 0;
        for (Student student : listStudents) {
            totalMark += student.getAverageMark();
        }
        return totalMark / this.getTotalStudents();
    }

    public Boolean hasCodeOrID(Long code, Long id) {
        for (Student student : listStudents) {
            if (student.getCode() == code || student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Boolean deleteAStudent() {
        clearConsole();
        try {
            System.out.print("Enter student's id : ");
            Long id = scan.nextLong();
            if (!hasCodeOrID(null, id)) {
                System.out.println("Not found id " + id);
                return false;
            }
            clearConsole();
            for (Student student : listStudents) {
                if (student.getId() == id) {
                    clearConsole();
                    System.out.println("Deleting .........\n");
                    listStudents.remove(listStudents.indexOf(student));

                    for (Student studentAbove : listStudents) {
                        if (student.getId() < studentAbove.getId()) {
                            studentAbove.setId(studentAbove.getId() - 1l);
                        }
                    }

                    displayStudents();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Wrong datatype! Id must be a number");
            return false;
        }
    }

    public Boolean updateStudent() {
        clearConsole();
        try {
            System.out.println("Enter student's code : ");
            Long code = scan.nextLong();
            if (!hasCodeOrID(code, null)) {
                System.out.println("Not found code " + code);
                return false;
            }
            for (Student student : listStudents) {
                if (student.getCode() == code) {
                    try {
                        System.out.println("Enter field by form : name -> birth -> mark");
                        String name = scan.next();
                        Short birth = scan.nextShort();
                        Float mark = scan.nextFloat();
                        addStudents(new Student(code, name, birth, mark));
                        displayStudents();
                        return true;
                    } catch (Exception e) {
                        System.out.println("Enter error : input wrong");
                    }
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Please re-run and enter correct code!");
            return false;
        }
    }
    
    public ArrayList<Student> searchName() {
        ArrayList<Student> listResult = new ArrayList<Student>();
        if (!checkIsEmpty()) {
            System.out.println("Enter student name (just some character) : ");
            String name = scan.nextLine();
            for (Student student : listStudents) {
                if (name.length() <= student.getName().length()) {
                    // Find full name
                    if (student.getName().indexOf(name) >= 0) {
                        listResult.add(student);
                        break;
                    }
                    // Find firstName & lastName
                    String start = student.getName().substring(0, name.length());
                    String end = student.getName().substring(student.getName().indexOf(" ") + 1,
                            student.getName().length());

                    if (name.endsWith(end) || name.startsWith(start)) {
                        listResult.add(student);
                    }
                }
            }
        }
        return listResult;
    }
    

    // public void sortDescByMark(){
    //     ArrayList<Student> listResult = new ArrayList<Student>();
    //     listResult.sort(new Comparator<StudentList>() {

    //         @Override
    //         public int compare(StudentList arg0, StudentList arg1) {
                
    //             return 0;
    //         }});
    // }
}
