public class Client {
    int id;

    public Client(int id) {
        this.id = id;
    }

    public void buy(Car car){
        System.out.println("Клиент" +
                this.id + " уехал на " + car);
    }

    @Override
    public String toString() {
        return "Клиент " +
                id;
    }
}
