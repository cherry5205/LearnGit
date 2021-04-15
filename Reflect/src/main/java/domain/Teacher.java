package reflect;

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
        System.out.println("老师教书......公有方法");
    }
    private void teach2()
    {
        System.out.println("老师教书...私有方法");
    }

}
