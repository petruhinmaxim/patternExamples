package myExamples.objectMethods;
//производитель не может добавить товар когда на складе их 3, освобождает монитор и ожидает команды notify.
//аналогично и ведёт себя покупатель.

public class ObjectWaitTest {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Maker maker = new Maker(stock);
        Consumer consumer = new Consumer(stock);
        new Thread(maker).start();
        new Thread(consumer).start();
    }
}

    class Stock {
        private int countProduct = 0;

        public synchronized void getProduct() {
            while (countProduct < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Что то пошло не так");
                }
            }
            countProduct--;
            System.out.println("плкупатель купил 1 товар");
            System.out.println("НА складе осталось: " + countProduct);
            notify();
        }

        public synchronized void putProduct() {
            while (countProduct > 3) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("опасность");
                }
            }
            countProduct++;
            System.out.println("На слад добавили 1 товар");
            System.out.printf("На складе %d товаров %n", countProduct);
            notify();
        }
    }

    class Maker implements Runnable{
        Stock stock;
        Maker(Stock stock){
            this.stock=stock;
        }

        @Override
        public void run() {
            for (int i=1; i<6;i++)
                stock.putProduct();
        }
    }
    class Consumer implements Runnable{
        Stock stock;
        Consumer(Stock stock){
            this.stock=stock;
        }

        @Override
        public void run() {
            for (int i=1;i<6;i++){
                stock.getProduct();
            }
        }
    }

