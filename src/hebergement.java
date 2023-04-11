
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

    public int getcar_id() {
        return id;
    }

    public void setcar_id(int car_id) {
        this.id = car_id;
    }

    public String getmake() {
        return type;
    }

    public void setmake(String carMake) {
        this.type = type;
    }





    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable(Date startDate, Date endDate, List<Orders> orders) {
        // Check if the car has any orders that overlap with the given date range
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