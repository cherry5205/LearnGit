package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射综合案例：执行任意一个类的任意方法
 */
public class ReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        Properties pro = new Properties();
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        String methodParam = pro.getProperty("methodParam");
        System.out.println(methodParam.getClass());
        Class cls = Class.forName(className);
        Method method = cls.getDeclaredMethod(methodName,methodParam.getClass());
        method.setAccessible(true);
        method.invoke(cls.newInstance(),"政治");
    }

}
