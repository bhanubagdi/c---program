import java.util.Objects;

public class Parent {
    String companyName;
    int stockPrice;
    int year;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return  year == parent.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockPrice, year);
    }

    @Override
    public String toString() {
        return "Parent{" +
                "companyName='" + companyName + '\'' +
                ", stockPrice=" + stockPrice +
                ", year=" + year +
                '}';
    }
}
