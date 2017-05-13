package myExamples.objectMethods.ObjectCloneTest;

import java.util.ArrayList;

//ссылочное поле list закомментировано, чтобы показать как работает клон с ссылками
public class ObjectCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Integer> list = new ArrayList();
        list.add(100);
        TestClass original = new TestClass(10, " Hellow clon ", 100, list);
        TestClass clone = original.clone();
        System.out.println("сразу после клоирования" + "\n" + original + "\n" + clone);
        original.primitive = 15;
        original.textclone = "By clone";
        original.integer = 115;
        original.list.add(999);
        System.out.println("Изменения оригинала" + "\n" + original + "\n" + clone);


    }
}

