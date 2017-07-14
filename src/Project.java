import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

    //Attributes
    private String name;
    private String description;
    private Task mainTask;

    //Methods
    public Project(String name, String description, double rate) throws NullPointerException, IllegalArgumentException {
        if(name == null || description == null) throw new NullPointerException();
        if(name.equals("") || description.equals("")) throw new IllegalArgumentException();
        if(rate < 0) throw new IllegalArgumentException("rate shouldnt be negative");
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setTask(Task newTask) throws NullPointerException {
        if(newTask == null) throw new NullPointerException();
        this.mainTask = newTask;
        //System.out.println(this.getDuration());
    }

    public String getDescription() {
        return this.description;
    }

    public double getDuration() {
        return mainTask.getTimeRequired();

    }

    public long getTotalCost() {
        System.out.println(this.mainTask.getCostEstimate());
        return mainTask.getCostEstimate();
    }

    public Map<Calendar, List<Deliverable>> allDeliverables() {
        Map<Calendar, List<Deliverable>> deliverables = new HashMap<>();
        List<Deliverable> myList = mainTask.allDeliverables();
        for(Deliverable del : myList) {
            deliverables.put(del.getDate(), myList);
        }


        return deliverables;

    }




}
