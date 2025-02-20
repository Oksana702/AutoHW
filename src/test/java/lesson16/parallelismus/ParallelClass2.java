package lesson16.parallelismus;

import org.testng.annotations.Test;

public class ParallelClass2 {

    @Test
    public void parallel6() {
        System.out.println("Executing parallel6 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel7() {
        System.out.println("Executing parallel7 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel8() {
        System.out.println("Executing parallel8 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel9() {
        System.out.println("Executing parallel9 - " + Thread.currentThread().getId());
    }

    @Test
    public void parallel10() {
        System.out.println("Executing parallel10 - " + Thread.currentThread().getId());
    }
}
