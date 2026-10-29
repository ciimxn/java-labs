import java.util.Objects;

public class Transport {
    private String type;
    private String brand;
    private int year;
    private int capacity;
    private double fuelConsumption;
    private boolean serviced;
    private boolean defective;

    public Transport(String type, String brand, int year, int capacity, double fuelConsumption)
            throws InvalidTransportDataException {
        if (type == null || type.trim().isEmpty()) {
            throw new InvalidTransportDataException("Тип транспорта не может быть пустым.");
        }
        if (brand == null || brand.trim().isEmpty()) {
            throw new InvalidTransportDataException("Бренд транспорта не может быть пустым.");
        }
        if (year <= 1900) {
            throw new InvalidTransportDataException("Год выпуска должен быть больше 1900 (передано: " + year + ").");
        }
        if (capacity <= 0) {
            throw new InvalidTransportDataException("Вместимость должна быть больше 0 (передано: " + capacity + ").");
        }
        if (fuelConsumption <= 0) {
            throw new InvalidTransportDataException("Расход топлива должен быть больше 0 (передано: " + fuelConsumption + ").");
        }
        this.type = type.trim();
        this.brand = brand.trim();
        this.year = year;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.serviced = false;
        this.defective = false;
    }

    public void service() throws MaintenanceException {
        if (defective) {
            throw new MaintenanceException("Ошибка обслуживания " + brand + " (" + type + "): обнаружена неустранимая неисправность двигателя!");
        }
        if (year < 1980) {
            throw new MaintenanceException("Ошибка обслуживания " + brand + " (" + type + "): модель " + year + " года снята с сервисной поддержки.");
        }
        this.serviced = true;
    }

    public double calculateFuel(double distance) throws InvalidTransportDataException {
        if (distance < 0) {
            throw new InvalidTransportDataException("Дистанция не может быть отрицательной (передано: " + distance + ").");
        }
        return (distance * fuelConsumption) / 100.0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InvalidTransportDataException {
        if (type == null || type.trim().isEmpty()) {
            throw new InvalidTransportDataException("Тип транспорта не может быть пустым.");
        }
        this.type = type.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws InvalidTransportDataException {
        if (brand == null || brand.trim().isEmpty()) {
            throw new InvalidTransportDataException("Бренд транспорта не может быть пустым.");
        }
        this.brand = brand.trim();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidTransportDataException {
        if (year <= 1900) {
            throw new InvalidTransportDataException("Год выпуска должен быть больше 1900 (передано: " + year + ").");
        }
        this.year = year;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws InvalidTransportDataException {
        if (capacity <= 0) {
            throw new InvalidTransportDataException("Вместимость должна быть больше 0 (передано: " + capacity + ").");
        }
        this.capacity = capacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) throws InvalidTransportDataException {
        if (fuelConsumption <= 0) {
            throw new InvalidTransportDataException("Расход топлива должен быть больше 0 (передано: " + fuelConsumption + ").");
        }
        this.fuelConsumption = fuelConsumption;
    }

    public boolean isServiced() {
        return serviced;
    }

    public void setServiced(boolean serviced) {
        this.serviced = serviced;
    }

    public boolean isDefective() {
        return defective;
    }

    public void setDefective(boolean defective) {
        this.defective = defective;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return year == transport.year && capacity == transport.capacity &&
                Double.compare(transport.fuelConsumption, fuelConsumption) == 0 &&
                Objects.equals(type, transport.type) &&
                Objects.equals(brand, transport.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, brand, year, capacity, fuelConsumption);
    }

    @Override
    public String toString() {
        return String.format("Transport{тип='%s', бренд='%s', год=%d, вместимость=%d чел/т, расход=%.1f л/100км, ТО=%s, неисправен=%s}",
                type, brand, year, capacity, fuelConsumption, (serviced ? "пройдено" : "не пройдено"), (defective ? "да" : "нет"));
    }
}
