
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class hebergement {
    private int id;
    private String type;
    private String lieu;
    private String features;
    private int pricePerDay;

    public hebergement( String type, String model, int hebergement_id) {
        this.id = hebergement_id;
        this.type = type;
        this.lieu = lieu;
        this.pricePerDay = pricePerDay;
    }

    public int gethebergement_id() {
        return id;
    }

    public void sethebergement_id(int hebergement_id) {
        this.id = hebergement_id;
    }

    public String getmake() {
        return type;
    }

    public void setmake(String hebergementMake) {
        this.type = type;
    }





    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable(Date startDate, Date endDate, List<Orders> orders) {
        for (Orders order : orders) {
            if (order.getEndDate().after(startDate) && order.getStartDate().before(endDate)) {
                return false;
            }
        }
        return true;
    }

    public int getTotalPrice(Date startDate, Date endDate) {
        int numDays = (int) TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
        return numDays * pricePerDay;
    }
}