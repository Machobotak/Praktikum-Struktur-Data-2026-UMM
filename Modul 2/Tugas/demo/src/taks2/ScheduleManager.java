package taks2;

import java.util.Iterator;
import java.util.LinkedList;

public class ScheduleManager {
    private LinkedList<Schedule> schedules;

    public ScheduleManager() {
        schedules = new LinkedList<>();
    }

    public void addFirst(Schedule schedule) {
        schedules.addFirst(schedule);
    }

    public void addLast(Schedule schedule) {
        schedules.addLast(schedule);
    }

    public void removeFirst() {
        if (!schedules.isEmpty()){
            schedules.removeFirst();
        }
    }
    public void removeLast() {
        if (!schedules.isEmpty()){
            schedules.removeLast();
        }
    }

    public void searchRoute(String keyword){
        boolean found = false;

        for  (Schedule s : schedules) {
            if (s.getOrigin().equalsIgnoreCase(keyword)|| s.getDestination().equalsIgnoreCase(keyword)) {
                s.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Rute tidak di temukan");
        }
    }

    public void displayAll(){
        Iterator<Schedule> it = schedules.iterator();
        while (it.hasNext()){
            Schedule s =  it.next();
            s.displayInfo();
        }
    }

    public void removeById(int id){
            Iterator<Schedule> it = schedules.iterator();
            while (it.hasNext()){
                Schedule s =  it.next();
                if(s.getScheduleId() == id){
                    it.remove();
                    System.out.println("Schedule dengan ID "+ id+" dihapus");
                    return;
                }
            }
        System.out.println("Schedule tidak di temukan");
    }
}
