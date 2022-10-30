public class Car {
    int id;
    String name;


    public void createCar(String info) {
        String[] parts = info.split(", ");
        this.setId(Integer.parseInt(parts[0]));
        this.setName(parts[1]);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " \"" + name +
                "\" (№ " + id +
                ")";
    }
}
