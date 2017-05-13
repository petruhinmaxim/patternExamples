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
        original.integer=115;
        original.list.add(999);
        System.out.println("Изменения оригинала" + "\n" + original + "\n" + clone);


    }
}

class TestClass implements Cloneable {
    public int primitive;
    public String textclone;
    public Integer integer;
    public ArrayList<Integer> list;

    public TestClass(int primitive, String textclone, Integer object, ArrayList<Integer> list) {
        this.primitive = primitive;
        this.textclone = textclone;
        this.list = list;
        this.integer = object;
    }

    public TestClass clone() throws CloneNotSupportedException {
        TestClass resalt = (TestClass) super.clone();
//        resalt.list = new ArrayList<>();
//        resalt.list.addAll(list);
        return resalt;
    }

    @Override
    public String toString() {
        String resalt = primitive + textclone + integer + list.toString();
        return resalt;
    }
}
