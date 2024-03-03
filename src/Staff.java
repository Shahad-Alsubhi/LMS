

public class Staff {
	
	private String firstName;
    private String lastName;
    private int id;
    private int office;
    private int number = 0;
    Course [] courses = new Course[3];

   public Staff() {
    }

    public Staff(String firstName, String lastName, int id, int office )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.office = office;
    }

   

	public int getId() {
		return id;
	}

	
	public Course[] getCourses(){
		return courses;		
	}

	
	public int getNumber() {
		return number;
	}


	public String getFullName() 
	{
		return this.firstName + " " + this.lastName;
	}
	
	
	public void addCourse(Course course) 
	{
		this.courses[number] = course;
		this.number++;
	}

	public void instructorSchedule() 
	{
		String day;
		System.out.println("Sunday Courses: ");
	    //get the number of courses that instructor has
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
        return "Staff{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", office=" + office +
                '}';
    }

}	 
		
	

