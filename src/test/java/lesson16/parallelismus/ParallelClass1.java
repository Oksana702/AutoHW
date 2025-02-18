package lesson16.parallelismus;


import org.testng.annotations.Test;

public class ParallelClass1 {

    @Test
    public void parallel1() {
        System.out.println("Executing parallel1 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel2() {
        System.out.println("Executing parallel2 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel3() {
        System.out.println("Executing parallel3 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel4() {
        System.out.println("Executing parallel4 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel5() {
        System.out.println("Executing parallel5 - " + Thread.currentThread().getId());
    }
}
