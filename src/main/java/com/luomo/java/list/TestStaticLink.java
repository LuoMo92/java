package com.luomo.java.list;

/**
 * @author LiuMei
 * @date 2019/5/23 0023
 */
public class TestStaticLink {

    public static void main(String[] args) throws Exception {
        StaticLinkList<Student> students = new StaticLinkList<>();
        System.out.println("——————————插入1到5,并读取内容——————————");
        Student[] stus = {new Student("小A", 11), new Student("小B", 12), new Student("小C", 13),
                new Student("小D", 14), new Student("小E", 151)};
        for (int i = 1; i <= 5; i++) {
            students.insert(i, stus[i - 1]);
        }
        System.out.println("表长：" + students.size());
        Student stu;
        for (int i = 1; i <= 5; i++) {
            stu = students.get(i);
            System.out.println("第" + i + "个位置为：" + stu.name);
        }
        System.out.println("——————————删除小B、小E——————————");
        students.delete(2);
        students.delete(4);
        System.out.println("当前表长：" + students.size());
        for (int i = 1; i <= students.size(); i++) {
            stu = students.get(i);
            System.out.println("第" + i + "个位置为：" + stu.name);
        }
        System.out.println("表长：" + students.size());
    }

}

class Student {
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;
}
