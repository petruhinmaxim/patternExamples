package myExamples.objectMethods.ObjectCloneTest;

import java.util.ArrayList;

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
