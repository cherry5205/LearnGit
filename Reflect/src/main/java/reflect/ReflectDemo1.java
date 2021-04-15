package reflect;

import domain.Teacher;

import java.lang.reflect.Field;

public class ReflectDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cls = Teacher.class;
        Field[] fields= cls.getFields();
        for (Field field:fields)
        {
            //打印Teacher类里的所有public修饰的成员方法
            System.out.println(field);
        }
        //获取Teacher类里的成员方法a
        Field a = cls.getDeclaredField("age");
        System.out.println(a);
        Teacher teacher = new Teacher();
        //获取Teaher类里的成员方法a的值
        a.setAccessible(true);
        Object value = a.get(teacher);
        System.out.println(value);
        //设置Teacher类里的成员方法a的值
        a.setInt(teacher,8);
        System.out.println(a.get(teacher));


        /
    }
}
