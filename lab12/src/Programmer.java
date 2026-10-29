import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Programmer {
    private int id;
    private String name;
    private String language;
    private int level;
    private List<Integer> codeReviews;

    public Programmer(int id, String name, String language, int level, List<Integer> codeReviews) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.level = level;
        this.codeReviews = codeReviews != null ? new ArrayList<>(codeReviews) : new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Integer> getCodeReviews() {
        return codeReviews;
    }

    public void setCodeReviews(List<Integer> codeReviews) {
        this.codeReviews = codeReviews != null ? new ArrayList<>(codeReviews) : new ArrayList<>();
    }

    public double getAverageReview() {
        if (codeReviews == null || codeReviews.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int r : codeReviews) {
            sum += r;
        }
        return (double) sum / codeReviews.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programmer that = (Programmer) o;
        return id == that.id && level == that.level && Objects.equals(name, that.name) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, language, level);
    }

    @Override
    public String toString() {
        return String.format("Programmer{id=%d, name='%s', language='%s', level=%d, avgReview=%.2f, reviews=%s}",
                id, name, language, level, getAverageReview(), codeReviews);
    }
}
