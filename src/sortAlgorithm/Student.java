package sortAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student>{
    int age;
    int score;
    String name;

    public Student(int age, int score, String name) {
        this.age = age;
        this.score = score;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    @Override
    public int compareTo(Student o) {
        int result = Integer.compare(this.age, o.getAge());
        if (result!=0)
            return result;
        return Integer.compare(this.getScore(), o.getScore());
    }
}

class Main{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(20, 100,"WHT"));
        students.add(new Student(18, 80,"JZY"));
        students.add(new Student( 22,76,"CJL"));
        students.add(new Student( 22,78,"SGJ"));
        // 使用 Comparator.comparing 结合 Lambda 表达式按年龄升序排序
//        students.sort(Comparator.comparing(Student::getAge));
        //或者
        // 使用 Lambda 表达式实现 Comparator 接口，按年龄升序排序
//        Comparator<Student> comparator = Comparator.comparingInt(Student::getAge).thenComparingInt(Student::getScore);
//        students.sort(comparator);
        Collections.sort(students);
        // 打印排序后的学生列表
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
