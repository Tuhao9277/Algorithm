import java.util.Arrays;
import java.util.Comparator;

public class Comparators {
    public static class Student{
        private int id;
        private String name;
        private int grade;

        public Student(int id, String name, int grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }
    }
    public static class IDAscendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id-o2.id;
        }
    }
    public static class IDDescendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id-o1.id;
        }
    }
    public static class GradeAscendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.grade-o2.grade;
        }
    }
    public static class GradeDescendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.grade-o1.grade;
        }
    }
    public static void printArrays(Student[] arr){
        for (Student e :
                arr) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args){
        Student student1 = new Student(1,"a",21);
        Student student2 = new Student(2,"b",22);
        Student student3 = new Student(3,"c",23);
        Student[] students = new Student[]{student1,student2,student3};
        Arrays.sort(students,new IDAscendingComparator());
        printArrays(students);
        System.out.println("---------------------");
        Arrays.sort(students,new IDDescendingComparator());
        printArrays(students);
        System.out.println("---------------------");
        Arrays.sort(students,new GradeAscendingComparator());
        printArrays(students);
    }
}
