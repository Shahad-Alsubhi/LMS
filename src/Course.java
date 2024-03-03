
public class Course {
	
	private int courseCode;
    private String day;
    private int startTime;
    private int hours;
    private int capacity;
    private Staff instructor;
    private Room room;

   public Course() {
    }

    public Course(int courseCode, String day, int startTime, int hours, int capacity ) 
    {
        super();
        this.courseCode = courseCode;
        this.day = day;
        this.startTime = startTime;
        this.hours = hours;
        this.capacity = capacity;
    }


    public int getCourseCode() {
        return courseCode;
    }


    public String getDay() {
        return day;
    }


    public int getStartTime() {
        return startTime;
    }


    public int getHours() {
        return hours;
    }


    public int getCapacity() {
        return capacity;
    }


    public Staff getInstructor() {
        return instructor;
    }


    public Room getRoom() {
        return room;
    }


    public void setRoom(Room room) {
        this.room = room;
    }
    
    
   public void addstaff(Staff staff) {
	   this.instructor =staff;
   }
   
 

    @Override
    public String toString() {
        return "Courses{" +
                "courseCode=" + courseCode +
                ", day='" + day + '\'' +
                ", startTime=" + startTime +
                ", hours=" + hours +
                ", capacity=" + capacity +
                '}';
    }

}