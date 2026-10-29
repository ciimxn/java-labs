import java.util.Objects;

public class Jacket extends Garment {
    private String material;

    public Jacket(String name, int id, String size, String material) {
        super(name, id, size);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jacket jacket = (Jacket) o;
        return Objects.equals(material, jacket.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material);
    }

    @Override
    public String toString() {
        return "Jacket{id=" + getId() + ", name='" + getName() + "', size='" + getSize() + "', material='" + material + "'}";
    }
}
