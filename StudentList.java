import java.util.ArrayList;
import java.util.Collections;


public class StudentList {
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

    // * Methods
    public void addStudents(Student student) {
        this.listStudents.add(student);
    }

    public Boolean isEmpty() {
        return this.listStudents.isEmpty();
    }

    public Student isExist(Integer id, Long code) {
        for (Student student : listStudents) {
            if (student.getId() == id) {
                return student;
            }
            if (student.getCode() == code) {
                return student;
            }
        }
        return null;
    }

    public void displayStudent(Student student) {
        System.out.println(student.toObjectString());
        System.out.println();
    }

    public void displayStudents() {
        System.out.println("Id\t" + "Code" + "\t" + "\t" + "Name" + "\t" + "\t" + "\tBirth" + "\t" + "\t"
                + "Average Mark");
        for (Student student : listStudents) {
            System.out.println(student.toString());
        }
    }

    public int getTotalStudents() {
        return listStudents.size();
    }

    public void clearAll() {
        this.listStudents.clear();
    }

    public float averageMarkOfClass() {
        float totalMark = 0;
        for (Student student : listStudents) {
            totalMark += student.getMark();
        }
        return totalMark / this.getTotalStudents();
    }

    public void removeStudent(Integer id) {
        for (Student student : listStudents) {
            if (student.getId() == id) {
                App.clearConsole();
                System.out.println("Deleting .........\n");
                listStudents.remove(listStudents.indexOf(student));

                for (Student studentAbove : listStudents) {
                    if (student.getId() < studentAbove.getId())
                        studentAbove.setId(studentAbove.getId() - 1);
                }
                break;
            }
        }
    }

    public void updateStudent(Long code, String name, Short birth, Float mark, Integer id) {
        Student student = isExist(id, null);
        student.setCode(code);
        student.setName(name);
        student.setBirth(birth);
        student.setMark(mark);
    }

    public ArrayList<Student> searchName(String name) {
        ArrayList<Student> listResult = new ArrayList<Student>();
        for (Student student : listStudents) {
            if (name.length() <= student.getName().length()) {

                // Find full name
                if (student.getName() == name) {
                    listResult.add(student);
                    break;
                }

                // Find by words
                // --- Method 1 : find by firstName & lastName
                String start = student.getName().substring(0, name.length());
                String end = student.getName().substring(student.getName().indexOf(" ") + 1,
                        student.getName().length());

                if (name.endsWith(end) || name.startsWith(start) || student.getName().contains(name)) {
                    listResult.add(student);
                }

                // ---- Method 2 : built-in method of String
                // if ( student.getName().contains(name)) {
                //     listResult.add(student);
                // }

            }
        }
        return listResult;
    }

    public ArrayList<Student> sortDescByMark() {

        // Selection Sort
        ArrayList<Student> listResult = listStudents;
        int sizeList = listResult.size(), minIndex;
        
        for (int i = 0; i < sizeList - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < sizeList; j++) {
                if (listResult.get(j).getMark() < listResult.get(minIndex).getMark()) {
                    minIndex = j;
                }
            }
            Collections.swap(listResult, minIndex, i);
        }

        // New id
        for (int i = 0; i < sizeList; i++) {
            listResult.get(i).setId(i+1);
        }
        return listResult;
    }

}