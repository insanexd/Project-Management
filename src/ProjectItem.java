import java.util.ArrayList;
import java.util.List;

public abstract class ProjectItem {

    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate) throws NullPointerException, IllegalArgumentException {
        if(name == null || details == null) throw new NullPointerException();
        if(name == "" || details == "") throw new IllegalArgumentException();
        if(rate < 0) throw new IllegalArgumentException("rate shouldnt be negative");

        this.name = name;
        this.details = details;
        this.rate = rate;

    }

    public void setDetails(String details) throws NullPointerException, IllegalArgumentException {
        if(details == null) throw new NullPointerException();
        if(details.equals("")) throw new IllegalStateException();
        this.details = details;
    }

    public long getCostEstimate() {
        return Math.round((this.getTimeRequired() * this.rate + this.getMaterialCost()));
    }

    public abstract double getTimeRequired();

    public abstract long getMaterialCost();

}
