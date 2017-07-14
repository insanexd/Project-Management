import java.util.List;

public interface IProject {

    void setTask(Task newTask);
    double getDuration();
    long getTotalCost();
    List<Deliverable> getDeliverables();

}
