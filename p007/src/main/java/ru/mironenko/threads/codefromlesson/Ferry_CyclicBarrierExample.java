package ru.mironenko.threads.codefromlesson;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by nikita on 25.06.2017.
 */
//Рассмотрим следующий пример. Существует паромная переправа.
// Паром может переправлять одновременно по три автомобиля.
// Чтобы не гонять паром лишний раз, нужно отправлять его,
// когда у переправы соберется минимум три автомобиля.

public class Ferry_CyclicBarrierExample {

    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());
    //Инициализируем барьер на три потока и таском, который будет выполняться, когда
    //у барьера соберется три потока. После этого, они будут освобождены.

    public static void main(String[] args) throws InterruptedException {
        
        for(int i = 0; i < 9; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }
    private static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try{
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили");
            } catch (InterruptedException e){}
        }
    }

    //Стороны, которые будут достигать барьера
    private static class Car implements Runnable{

        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try{
                System.out.printf("Автомобиль N%d подъехал к паромной переправе.\n", carNumber);
                //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                BARRIER.await();
                System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
            }catch (Exception e){}
        }
    }
}
