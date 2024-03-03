public class Room {
	
	    private int roomNumber;
    	private int capacity;
	    private int number = 0;  
	    private Course [] courses = new Course[50];
	    
	    public Room() {	    	
	    }

	    public Room(int roomNumber,int capacity ) {
	        this.roomNumber = roomNumber;
	        this.capacity = capacity;
	    }
	    
	    
	    public int getRoomNumber() {
			return roomNumber;
		}


		public int getCapacity() {
			return capacity;
		}


		public Course []  getCourses() {
			return courses;
		}

		
		public int getNumber() {
			return number;
		}
	
		
		public void AddCourse(Course course) {
			this.courses[this.number] = course;
			this.number++;
		}
	
		public void RoomSchedule() 
		{
		String day;
		System.out.println("Sunday Courses: ");
	    //get the number of courses that room has
		for(int i = 0; i< number; i++) 
		{
			 day=this.courses[i].getDay();
			//printing the courses on Sunday 
			  if (day.equals("Sun"))
			 {	 
				 System.out.println(courses[i]);
			}	
			}
		
		System.out.println("\nMonday Courses: "); 
		for(int i = 0; i< number; i++) 
		{
			 day=this.courses[i].getDay();
			//printing the courses on Monday 
			 if (day.equals("Mon"))
			    {
				  System.out.println(courses[i]);
				 }
			 }
		 System.out.println("\nTuesday Courses: ");		
		for(int i = 0; i< number; i++) 
		{
			 day=this.courses[i].getDay();
			//printing the courses on Tuesday 
			 if (day.equals("Tue"))
			 {
				System.out.println(courses[i]);
				 }
			 } 				
        System.out.println("\nWednesday Courses: ");
		for(int i = 0; i< number; i++) 
		{
			 day=this.courses[i].getDay();
			//printing the courses on Wednesday 
			 if (day.equals("Wed"))
			 {
				 System.out.println(courses[i]);
			 }} 
			
	 
		
	}
		@Override
	    public String toString() {
	        return "Room{" +
	                "roomNumber=" + roomNumber +
	                ", capacity=" + capacity +
	                '}';
	    }

}