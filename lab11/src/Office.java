public class Office extends Building {
    private String companyName;

    public Office(String address, int floors, double area, String companyName) {
        super(address, floors, area);
        this.companyName = companyName;
    }

    @Override
    public String getPurpose() {
        return "Офис (" + companyName + ")";
    }

    public String getCompanyName() {
        return companyName;
    }
}
