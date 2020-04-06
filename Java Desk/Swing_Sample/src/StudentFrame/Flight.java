
package StudentFrame;


public class Flight {
    
    private String code, departure, arrival;
    private double fare;
    private boolean bussiness;

    public Flight(String code, String departureString, String arrival, double fare, boolean bussiness) {
        this.code = code;
        this.departure = departureString;
        this.arrival = arrival;
        this.fare = fare;
        this.bussiness = bussiness;
    }

    public String getCode() {
        return code;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public double getFare() {
        return fare;
    }

    public boolean isBussiness() {
        return bussiness;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setBussiness(boolean bussiness) {
        this.bussiness = bussiness;
    }
    
    public Object[] toDataRow(){
        return new Object[]{code, departure, arrival, fare, bussiness};
    }
}
