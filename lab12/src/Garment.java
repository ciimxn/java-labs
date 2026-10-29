import java.util.Objects;

public class Garment {
    private String name;
    private int id;
    private String size;

    public Garment(String name, int id, String size) {
        this.name = name;
        this.id = id;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garment garment = (Garment) o;
        return id == garment.id && Objects.equals(name, garment.name) && Objects.equals(size, garment.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, size);
    }

    @Override
    public String toString() {
        return "Garment{id=" + id + ", name='" + name + "', size='" + size + "'}";
    }
}
