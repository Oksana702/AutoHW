package lesson16.grouping;

import org.testng.annotations.Test;

public class Groups {

    @Test(groups="first")
    public void one(){
        System.out.println("Test one (group: first)");
    }

    @Test(groups = "second")
    public void two() {
        System.out.println("Test two (group: second)");
    }

    @Test(groups = "first")
    public void three() {
        System.out.println("Test three (group: first)");
    }

    @Test(groups = "second")
    public void four() {
        System.out.println("Test four (group: second)");
    }

    @Test(groups = "first")
    public void five() {
        System.out.println("Test five (group: first)");
    }

    @Test(groups = "second")
    public void six() {
        System.out.println("Test six (group: second)");
    }

    @Test(groups = "first")
    public void seven() {
        System.out.println("Test seven (group: first)");
    }

    @Test(groups = "second")
    public void eight() {
        System.out.println("Test eight (group: second)");
    }
}
