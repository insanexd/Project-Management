import java.util.ArrayList;
import java.util.List;

public class Task extends ProjectItem {

    private List<ProjectItem> projectItems = new ArrayList<>();



    public Task(String name, String details, double rate) throws NullPointerException, IllegalArgumentException {
        super(name, details, rate);
        if(name == null || details == null) throw new NullPointerException();
        if(name.equals("") || details.equals("")) throw new IllegalStateException();
    }

    public double getTimeRequired() {
        double totalTimeRequired = 0;
        for(ProjectItem pi : projectItems) {
            totalTimeRequired = totalTimeRequired + pi.getTimeRequired();
        }

        return totalTimeRequired;

    }

    public long getMaterialCost() {
        long totalMaterialCost = 0;
        for(ProjectItem pi : projectItems) {
            totalMaterialCost = totalMaterialCost + pi.getMaterialCost();
        }
        return totalMaterialCost;
    }

    public void addProjectItem(ProjectItem pi) throws NullPointerException {
        if(pi == null) throw new NullPointerException();
        List<Deliverable> myList = new ArrayList<>();
        if(pi instanceof Deliverable) {
            this.projectItems.add(pi);
        } else if(pi instanceof Task) {
            myList = ((Task) pi).allDeliverables();
            for(Deliverable d : myList) {
                this.addProjectItem(d);
            }
        }
    }

    public void removeProjectItem(ProjectItem pi) throws NullPointerException {
        if(pi == null) throw new NullPointerException();
        this.projectItems.remove(pi);
    }

    public List<Deliverable> allDeliverables() {
        List<Deliverable> myList = new ArrayList<>();
        for(ProjectItem pi : this.projectItems) {
            if(pi instanceof Deliverable) {
                myList.add((Deliverable) pi);
            }
        }
        System.out.println(myList);
        return myList;

    }



}
