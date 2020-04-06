
package coursemanagementsystem;


public class Course {
    private String name, id ;
    private int credit;

    public Course() {
    }

    public Course(String name, String id, int credit) {
        this.name = name;
        this.id = id;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getCredit() {
        return credit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public int compareTo (Course o){
        if(this.getId().equalsIgnoreCase(o.getId()) && this.getName().equalsIgnoreCase(o.getName())) {
            return 1;
        }
        else return 0;
    }
    
    
}
