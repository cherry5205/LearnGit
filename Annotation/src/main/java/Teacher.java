package domain;

public class Teacher {
    private String name;
    private int age;
    //0代表男，1代表女
    private int sex;
    public int a;
    protected int b;
    int c;
    private int d;
    public void teach1()
    {
        System.out.println("老师教......公有方法");
    }
    private void teach2()
    {
        System.out.println("老师教...私有方法");
    }
    public void teach3(String course)
    {
        System.out.println("老师教..." + course);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setD(int d) {
        this.d = d;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public Teacher() {
    }

    public Teacher(String name, int age, int sex, int a, int b, int c, int d) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
