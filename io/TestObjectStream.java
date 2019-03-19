package io;

import java.io.*;

public class TestObjectStream {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Huxz", 18, 100);
        Student s2 = new Student("Liucy", 30, 60);

        FileOutputStream fos = new FileOutputStream("student.dat");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(s1);
        out.writeObject(s2);
        out.close();

        FileInputStream fis = new FileInputStream("student.dat");
        ObjectInputStream in = new ObjectInputStream(fis);
        Student o1 = (Student)in.readObject();
        Student o2 = (Student)in.readObject();
        in.close();

        System.out.println(s1);
        System.out.println(s2);

    }

    static class Student implements Serializable{
        private String name;
        private int age;
        private transient double score;

        public Student(String name, int age, double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
        @Override
        public String toString(){
            return "name=" + name + " age=" + age + " score=" + score;
        }

    }
}
