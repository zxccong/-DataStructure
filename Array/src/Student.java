public class Student {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array2<Student> arr = new Array2<>();
        arr.addLast(new Student("A",100));
        arr.addLast(new Student("B",81));
        arr.addLast(new Student("C",90));
        arr.addLast(new Student("D",75));
        System.out.println("arr = " + arr);
    }
}
