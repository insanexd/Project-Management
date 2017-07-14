import java.util.ArrayList;
import java.util.List;

public class Adapter implements IProject{

    private Task myTask;
    private String name;
    private String details;
    double rate;


    public Adapter(String name, String details, double rate) throws NullPointerException, IllegalArgumentException {
        if(name == null | details == null) throw new NullPointerException();
        if(name.equals("") || details.equals("")) throw new IllegalArgumentException();
        if(rate < 0) throw new IllegalArgumentException("rate shouldnt be negative");

        this.name = name;
        this.details = details;
        this.rate = rate;

    }


    @Override
    public void setTask(Task newTask) throws NullPointerException {
        if(newTask == null) throw new NullPointerException();
        this.myTask = newTask;

    }

    @Override
    public double getDuration() {
        return myTask.getTimeRequired();
    }

    @Override
    public long getTotalCost() {
        return myTask.getCostEstimate();
    }

    @Override
    public List<Deliverable> getDeliverables() {
       return myTask.allDeliverables();
    }
}
