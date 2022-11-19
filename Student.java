public class Student{
    private int id;
    private static int numInstance = 0;
    private long code;
    private String name;
    private short birth;
    private float mark;

    public Student() {
        id++;
    }
    
    public Student(Long code, String name, short birth, float mark) {
        this.code = code;
        this.name = name;
        this.birth = birth;
        this.mark = mark;
        this.id = ++numInstance;
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getBirth() {
        return this.birth;
    }

    public void setBirth(short birth) {
        this.birth = birth;
    }

    public float getMark() {
        return this.mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String toObjectString() {
        return "Student" +"\t\t:\t" + this.getName()
                + "\nId" + "\t\t:\t" + this.getId()
                + "\nBirth" + "\t\t:\t" + this.getBirth()
                + "\nAverage mark" + "\t:\t" + this.getMark();
    }
    @Override
    public String toString() {
        return getId() + "\t"+ this.getCode() + "\t" + "\t"+ this.getName() + "\t" + "\t" + this.getBirth() + "\t" +"\t" + this.getMark();
    }
}

   

