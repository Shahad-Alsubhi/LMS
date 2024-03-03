public class Student {
	
	private String firstName;
    private String lastName;
    private int id;
    private double GPA;
    private int number = 0;
    private Course [] courses = new Course[4];

   public Student() {
    	
   }
    
    public Student(String firstName, String lastName, int id, double GPA) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.GPA = GPA;
    }



	public int getId() {
		return id;
	}


	public double getGPA() {
		return GPA;
	}


	public Course[] getCourses() {
		return courses;
	}



	public int getNumber() {
		return number;
	}

	public void addCourse(Course course) 
	{				
		// assign the course to the student
		this.courses[number] = course;
		this.number++;
	}
	
	
	public void removeCourse(Course course) 
	{
		int index = -1;
		
		// search for the course
		
		for(int i=0;i<this.courses.length;i++) 
		{
			if(this.courses[i] == course) 
			{
				index = i;
				break;
			}
		}
		
		if(index == -1) 
		{
			System.out.println("Course Not Found");
		}
		
		else {
			
			for(int i = index; i< number; i++) 
			{
				courses[i] = courses[i+1];
			}
		}
		
	}
	
	
	public String getFullName() 
	{
		return this.firstName + " " + this.lastName;
	}
	
	
	public void StudentSchedule() 
	{

		String day;
		System.out.println("Sunday Courses: ");
	    //get the number of courses that student has
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
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", GPA=" + GPA +
                '}';
    }

	

}