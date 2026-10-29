import java.util.Objects;

public class TShirt extends Garment {
    private String print;

    public TShirt(String name, int id, String size, String print) {
        super(name, id, size);
        this.print = print;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return Objects.equals(print, tShirt.print);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), print);
    }

    @Override
    public String toString() {
        return "TShirt{id=" + getId() + ", name='" + getName() + "', size='" + getSize() + "', print='" + print + "'}";
    }
}
