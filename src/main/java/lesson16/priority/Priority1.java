package lesson16.priority;

import jdk.incubator.vector.VectorOperators;
import org.testng.annotations.Test;

public class Priority1 {
    @Test(priority=7)
    public void g(){
        System.out.println("Test g");
    }
    @Test(priority=6)
    public void f(){
        System.out.println("Test f");
    }
    @Test(priority=5)
    public void e(){
        System.out.println("Test e");
    }
    @Test(priority=4)
    public void d(){
        System.out.println("Test d");
    }
    @Test(priority=3)
    public void c(){
        System.out.println("Test c");
    }
    @Test(priority=2)
    public void b(){
        System.out.println("Test b");
    }
    @Test(priority=1)
    public void a(){
        System.out.println("Test a");
    }




}
