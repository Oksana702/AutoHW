package lesson14;

import org.openqa.selenium.WebElement;

public class ElementComparator {
    public static void compareElements(WebElement element1, WebElement element2) {
        int x1 = element1.getLocation().getX();
        int y1 = element1.getLocation().getY();
        int width1 = element1.getSize().getWidth();
        int height1 = element1.getSize().getHeight();
        int area1 = width1 * height1;

        int x2 = element2.getLocation().getX();
        int y2 = element2.getLocation().getY();
        int width2 = element2.getSize().getWidth();
        int height2 = element2.getSize().getHeight();
        int area2 = width2 * height2;

        // Сравнение по вертикальному положению
        if (y1 < y2) {
            System.out.println("Первый элемент выше второго");
        } else if (y1 > y2) {
            System.out.println("Второй элемент выше первого");
        } else {
            System.out.println("Оба элемента находятся на одной высоте");
        }

        if (x1 < x2) {
            System.out.println("Первый элемент левее второго");
        } else if (x1 > x2) {
            System.out.println("Второй элемент левее первого");
        } else {
            System.out.println("Оба элемента находятся на одной линии по горизонтали");
        }

        if (area1 > area2) {
            System.out.println("Первый элемент занимает большую площадь");
        } else if (area1 < area2) {
            System.out.println("Второй элемент занимает большую площадь");
        } else {
            System.out.println("Оба элемента имеют одинаковую площадь");
}
}


}
