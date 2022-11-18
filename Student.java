public class Student {
    private Long id;
    private static Long numInstance = 0l;
    private Long code;
    private String name;
    private short birth;
    private float averageMark;

    public Student() {
        id++;
    }
    
    public Student(Long code, String name, short birth, float averageMark) {
        this.code = code;
        this.name = name;
        this.birth = birth;
        this.averageMark = averageMark;
        this.id = ++numInstance;
    }

    public Long getCode() {
        return this.code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public float getAverageMark() {
        return this.averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public String toObjectString() {
        return "Student" +"\t\t:\t" + this.getName()
                + "\nId" + "\t\t:\t" + this.getId()
                + "\nBirth" + "\t\t:\t" + this.getBirth()
                + "\nAverage mark" + "\t:\t" + this.getAverageMark();
    }
    @Override
    public String toString() {
        return getId() + "\t"+ this.getCode() + "\t" + "\t"+ this.getName() + "\t" + "\t" + this.getBirth() + "\t" +"\t" + this.getAverageMark();
    }

}

   

