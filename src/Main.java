import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Car> cars = new ArrayList<>();
        List<String> carsInfo = new ArrayList<>();
        carsInfo.add("1, BigCar");
        carsInfo.add("2, NewCar");
        carsInfo.add("3, Truck");
        carsInfo.add("4, ClassicCar");
        carsInfo.add("5, BigCar");
        carsInfo.add("6, BigCar");
        carsInfo.add("7, NewCar");
        carsInfo.add("8, Truck");
        carsInfo.add("9, ClassicCar");
        carsInfo.add("10, BigCar");

        new Thread(() -> {
            for (int i = 0; i < carsInfo.size(); i++) {
                Car car = new Car();
                car.createCar(carsInfo.get(i));
                synchronized (cars) {
                    cars.add(car);
                    System.out.println("Автомобиль " + car +
                            "  произведён");
                    cars.notify();
                }
            }
        }).start();


        for (int i = 0; i < carsInfo.size(); i++) {
            int finalI = i;
            new Thread(() -> {
                Client client = new Client(finalI);
                synchronized (cars) {
                    System.out.println(client + " заходит в автосалон");
                    if (cars.isEmpty()) {
                        System.out.println("Машин нет");
                        try {
                            cars.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    client.buy(cars.remove(0));
                }
            }).start();
        }
    }
}