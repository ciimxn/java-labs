public class Building {
    protected String address;
    protected int floors;
    protected double area;

    public Building(String address, int floors, double area) {
        this.address = address;
        this.floors = floors;
        this.area = area;
    }

    public void build() {
        System.out.println("Строю здание по адресу " + address);
    }

    public void build(int floors) {
        System.out.println("Строю здание по адресу " + address + " с " + floors + " этажами");
    }

    public void build(String material) {
        System.out.println("Строю здание по адресу " + address + " из " + material);
    }

    public String getPurpose() {
        return "Неизвестно";
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("%s [Адрес: %-25s | Этажей: %2d | Площадь: %,7.1f м² | Назначение: %s]",
                getClass().getSimpleName(), address, floors, area, getPurpose());
    }
}
