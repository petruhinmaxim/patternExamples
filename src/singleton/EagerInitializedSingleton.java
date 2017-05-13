package singleton;

//инициализируется до момента вызова
public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // конструктор private, чтобы не было возможности создать экземпляр класса извне.
    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
