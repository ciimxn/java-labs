import java.util.Objects;

public class Pants extends Garment {
    private int length;

    public Pants(String name, int id, String size, int length) {
        super(name, id, size);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pants pants = (Pants) o;
        return length == pants.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    @Override
    public String toString() {
        return "Pants{id=" + getId() + ", name='" + getName() + "', size='" + getSize() + "', length=" + length + "}";
    }
}
