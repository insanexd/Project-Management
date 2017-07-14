import java.util.Calendar;

public class Deliverable extends ProjectItem {

    private long materialCost;
    private double productionTime;
    private Calendar date;

    public Deliverable(String name, String details, double rate, long materialCost, double productionTime, Calendar date)
            throws NullPointerException, IllegalArgumentException {
        super(name, details, rate);
        if(name == null || details == null || date == null) throw new NullPointerException();
        if(name == "" || details == "") throw new IllegalArgumentException();
        if(materialCost < 0) throw new IllegalArgumentException("material cost shouldnt be negative");
        if(productionTime <= 0) throw new IllegalArgumentException("production time should be positive");



        this.materialCost = materialCost;
        this.productionTime = productionTime;
        this.date = date;

    }

    public double getTimeRequired() {
        return productionTime;
    }

    public long getMaterialCost() {
        return this.materialCost;
    }

    public Calendar getDate() {
        return this.date;
    }


}
