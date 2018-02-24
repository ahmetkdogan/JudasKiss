package judaskiss;


public class Card {
    private String name;
    private String group;
    private String status;
    private int point;
    
    public Card(String name,String group,String status,int point){
        this.name=name;
        this.group=group;
        this.status=status;
        this.point=point;
    }
    public Card(){
        this.name = "";
    }
    
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    
}
