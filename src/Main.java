



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	
	//create object from other classes
	static Staff[] staffs = new Staff[7];
    static Student[] students = new Student[50];
    static Course[] courses = new Course[20];
    static Room[] rooms = new Room[9];
    
    
    
    
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        
      //print message to express the program
		   String message="** Welcome to Computer Science department  **";
	       System.out.println(message);
       
        
	       //read data from room file
	           try 
	           {
	               File file = new File("Rooms.txt");
	              Scanner read = new Scanner(file);
	               for (int i = 0; i < 9; i++) 
	               {
	                   String room = read.nextLine();
	                   String[] data = room.split(" ");
	                   Room r = new Room(Integer.valueOf(data[0]), Integer.valueOf(data[1]));
	                   Main.rooms[i] = r;
	               }
	               read.close();
	           } 
	           catch (FileNotFoundException e)
	           {
	               System.out.println("Rooms File Not Found");
	           }
	      

	       
	      //read staff data from File
	       
	           try 
	           {
	               File file = new File("Staff.txt");
	              Scanner read = new Scanner(file);
	               for (int i = 0; i < 7; i++) 
	               {
	                   String member =read.nextLine();
	                   String[] data = member.split(" ");
	                   Staff s = new Staff(data[0], data[1], Integer.valueOf(data[2]), Integer.valueOf(data[3]));
	                   Main.staffs[i] = s;
	               } read.close();
	           } 
	           catch (FileNotFoundException e)
	           {
	               System.out.println("Staff File Not Found");
	           }
	      
	       
	       
	      // read Student data from File
	       
	           try {
	               File file = new File("Students.txt");
	               Scanner read = new Scanner(file);
	               for (int i = 0; i < 50; i++) {
	                   String student = read.nextLine();
	                   String[] data = student.split(" ");
	                   Student s = new Student(data[0], data[1], Integer.valueOf(data[2]), Double.valueOf(data[3]));
	                   Main.students[i] = s;
	               } read.close();
	           } catch (FileNotFoundException e) {
	               System.out.println("Students File Not Found");
	           }
	       
	       
	       
	       //read Courses data from File
	        
	           try {
	               File file = new File("Courses.txt");
	               Scanner read = new Scanner(file);
	               for (int i = 0; i < 20; i++) {
	                   String course = read.nextLine();
	                   String[] ob = course.split(" ");
	                   Course course1 = new Course(Integer.valueOf(ob[0]), ob[1], Integer.valueOf(ob[2]), Integer.valueOf(ob[3]), Integer.valueOf(ob[4]));
	                   courses[i] = course1;
	               } read.close();
	           } catch (FileNotFoundException e) {
	               System.out.println("Courses File Not Found");
	           }
	      
       
        
        int choice = 0;
        do {
         //display the menu.
        	String  menu="choose from the menu, please enter the number :\n 1-Add menu \n 2-Delete Student from a course \n 3-Search \n 4-Sort \n 5-Print Schedule \n 6-Exit";
		      System.out.print(menu);
		      
            choice = input.nextInt();
            switch (choice)
            {
                case 1:
           	//display the add list.
                    System.out.println("choose from the menu, please enter the number :\n 1-Allocate a course To room \n 2-Assign a course to an instructor \n 3-Add a course to a student");
                    
                
                    do {
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                          	//get the course code
                            	
                                System.out.println("Enter The Course Code: ");
                                int code = input.nextInt();
                                Course course = getCourseViaCode(code);
                           //check if the course was found
                                
                                while (course == null) {
                                    System.out.println("Course Not Found.");
                                    code = input.nextInt();
                                    course = getCourseViaCode(code);
                                }
                                
                                AllocateCourseToRoom(course);
                                break;
                            case 2:{
                            //get the course code
                            	
                                System.out.println("Enter The Course Code: ");
                           int     code1 = input.nextInt();
                               Course course1 = getCourseViaCode(code1);
                          //check if the course was found
                                while (course1 == null) {
                                    System.out.println("Course Not Found.");
                                    code1 = input.nextInt();
                                    course1 = getCourseViaCode(code1);
                                }
                                AssignCourseToInstructor(course1);
                                break;
                        }
                               
                            case 3:{
                                System.out.println("Enter The Course Code: ");
                                int code2 = input.nextInt();
                                Course course2 = getCourseViaCode(code2);
                                while (course2 == null) {
                                    System.out.println("Course Not Found.");
                                    code2 = input.nextInt();                                    
                                    course2 = getCourseViaCode(code2);
                                }
                         //Calculating the number of student in the course
                                int number=0;
                                for(int i=0;i<50;i++) 
                                {
                                	int cor=students[i].getCourses().length;
                                	for(int j=0;j<cor;j++) 
                                	{
                                		if (students[i].getCourses()[j]==course2) {
                                		number++;
                                		}
                                	}
                                }
                                
                            //Check the capacity of the course 
                                if (number == course2.getCapacity()) 
                                {
                                    System.out.println("The course is full");
                                  
                                    break;
                           //Check if the course has room
                                }
                                else if (course2.getRoom() == null ) {
                                        System.out.println("The Course doesn't have room");
                                     
                                        break;
                          //Check if the course has instructor
                                    }
                                	else if(course2.getInstructor() == null){
                                		 System.out.println("The Course doesn't have instructor");	
                                	}
                                	else {
                                		addCourseToStudent(course2);
                                	}
                                }
                                break;
                                
                                                             
                            default:{
                                System.out.println("Enter a correct choice");
                                }
                        }
                    }
                    while (choice< 1 || choice > 3);
                    	
                    
                    
                    break;
                case 2:
               	//get the student id
                    System.out.println("Enter The Student ID: ");
                    int id = input.nextInt();
                    Student student = getStudentViaID(id);
               //get the course code
                    System.out.println("Enter The Course Code: ");
                    int code = input.nextInt();
                    Course course = getCourseViaCode(code);
                    
             //Check the number of courses the student has
                    if (student.getNumber() <= 2)
                    {
                        System.out.println("the student cannot delete,because he has a minimum number of courses");
                     
                        break;
                    }
                    if(student.getNumber()==0){
                        System.out.println("The student has not been added to any course");
                     
                        break;
                    }
                    student.removeCourse(course);
                    System.out.println("student deleted successfully.");
                
                    break;
                case 3:
                	System.out.println("choose from the menu, please enter the number :\n 1- Search for student by id and print data if found \n 2- Search for students greater than specific GPA \n 3- Search for students in a specific course");
  		            choice = input.nextInt();
  		            
                    while (choice < 1 || choice > 3) 
                    {
                        System.out.println("Enter a correct choice : ");
                        choice = input.nextInt();
                    }
                    
                    switch (choice) {
                        case 1:
                    	//get the student id
                            System.out.println("Enter the student id: ");
                            id = input.nextInt();
                            student = getStudentViaID(id);
                       //check if the student was found
                            while (student == null) 
                            {
                                System.out.println("Student Not Found, please enter a valid id: ");
                                id = input.nextInt();
                                student = getStudentViaID(id);
                            }
                            
                            System.out.println(getStudentViaID(id));
                            break;
                            
                        case 2:{
                       	//get the gpa
                            System.out.println("Enter the gpa: ");
                            Scanner keyboard=new Scanner(System.in);
                          String gpaa=keyboard.nextLine();
                            Double  gpa = Double.parseDouble(gpaa);
                       //check the gpa is available
                           while (gpa < 0 || gpa > 4) 
                           {
                                System.out.println("Enter a correct gpa: ");
                                gpaa=keyboard.nextLine();
                                gpa = Double.parseDouble(gpaa);
                            }
                     //print the student whose gpa is higher than the specified gpa
                            
                            System.out.println("Students with GPA more than " + gpa + " are : ");
                            for (int i = 0; i < students.length ; i++) 
                            { 
                                if (students[i].getGPA() > gpa)
                                {
                                    System.out.println(students[i]);
                                }
                               
                            }
                            break;
                            }
                        
                        case 3:
                        //get the course code
                            System.out.println("Enter The Course Code: ");
                            code = input.nextInt();
                            course = getCourseViaCode(code);
                       //check if the course was found
                            while (course == null) {
                                System.out.println("Course Not Found");
                                code = input.nextInt();
                                course = getCourseViaCode(code);
                            }
                     //get the instructor of the course
                            System.out.println("The instructor of the course is DR : " + course.getInstructor().getFullName());
                    //get the room of the course
                            System.out.println(" Room number : " + course.getRoom().getRoomNumber());
                   //get the students in the course
                            System.out.println("Students in the course : ");
                         
                            for(int i=0;i<50;i++) 
                            {
                        	//get the students in the course
                            	int Studentcourses=students[i].getCourses().length;
                            	for(int j=0;j<Studentcourses;j++) 
                            	{
                            		if (students[i].getCourses()[j]==course) 
                            		{
                            			System.out.println(students[i]);
                            		}
                            	}
                            }
                    }
                    break;
                case 4:
                	System.out.println("choose from the menu, please enter the number :\n 1-Sort the students in an ascending order according to the ID numbers \n 2-Sort the students in descending order according to the GPA");
		              choice = input.nextInt();
                    while (choice < 1 || choice > 2) {
                        System.out.println("Enter a correct choice : ");
                        choice = input.nextInt();
                    }
                    
                    switch (choice) {
                    case 1:
                        System.out.println("Students Sorted in ascending order By id");
                        sortToId();
                        break;
                    case 2:
                        System.out.println("Students Sorted in descending order by gpa");
                        sortToGPA();
                       
                    }
                    break;
                case 5:
                    ScheduleMenu();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Incorrect choice. ");
            }
        } while (choice != 6);
        
    }
    
    
    /////////////////////////////////////////////////////////
    	
  //method returns  student data by id
    
    public static Student getStudentViaID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (Main.students[i].getId() == id) {
                return Main.students[i];
            }
        }
        return null;
    }
         
  //method returns staff data by id

    public static Staff getStaffViaID(int id) {
        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i].getId() == id) {
                return staffs[i];
            }
        }
        return null;
    }

  //method returns  course data by course code
    
    public static Course getCourseViaCode(int code) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCourseCode() == code) {
                return courses[i];
            }
        }
        return null;
    }

  //method returns room data by number
    
    public static Room getRoomByNumber(int id) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getRoomNumber() == id) {
                return rooms[i];
            }
        }
        return null;
    }
      
  //method returns true if there are conflict between tow courses
    
    public static boolean CheckCourses(Course course1, Course course2)
    {
        return (course1.getDay().equals(course2.getDay()) &&
                ((course1.getStartTime() <= course2.getStartTime() + course2.getHours() &&
                        course1.getStartTime() >= course2.getStartTime()) ||
                        (course2.getStartTime() <= course1.getStartTime() + course1.getHours() &&
                                course2.getStartTime() >= course1.getStartTime())));
    
    }
    
  //method to sort the Students in ascending order By id
    
    public static void sortToId() {
  	  
		  for (int i = 0; i < 50; i++) {
			  for (int j=i+1 ; j < 50; j++) {
				  if(students[i].getId()>=students[j].getId()) {
					Student  temp=students[j];
					students[j]=students[i];
					students[i]=temp;
				  }
			  }
		  }
    
	
	  for (int i = 0; i < 50; i++) {
		  System.out.println(students[i]+"\n");
	  }
}
  //method to sort the student in descending order by gpa
    
    public static void sortToGPA() {
  	  
  	  for (int i = 0; i < 50; i++) {
  		  for (int j=i+1 ; j < 50; j++) {
  			  if(students[i].getGPA()<=students[j].getGPA()) {
  				Student  temp=students[j];
  				students[j]=students[i];
  				students[i]=temp;
  			  }
  		  }
  	  }
    
  
    for (int i = 0; i < 50; i++) {
  	  System.out.println(students[i]+"\n");
    }
  }
  //method Allocated course to room 

    public static void AllocateCourseToRoom(Course course)
    {
       
    	boolean num=false,num2=false;
       
        for (int i = 0; i < rooms.length; i++) 
        {
     	//ckeck if the room capacity is suitable for the course capacity
        	if (rooms[i].getCapacity() >= course.getCapacity()) 
        	{
       //get the number of courses in the room
        		if(rooms[i].getNumber()>0) 
                    
                {
        			for (int j = 0; j <rooms[i].getNumber();  j++) 
        			{
    	//check that there is no conflict
        				if (CheckCourses(course, rooms[i].getCourses()[j])) 
        				{
        				      num=true;	
        				}
        			else {
        				      num2=false;
        			     }
        		    }
        				if((num||num2)!=true) {
        					
        				rooms[i].AddCourse(course);
                        course.setRoom(rooms[i]);
                        
                        System.out.println("Course Allocated to this Room successfully in "+rooms[i].getRoomNumber());
                        break;
                                           
        	          }
        				
       		}
        			
                
        		else {
        		rooms[i].AddCourse(course);
                course.setRoom(rooms[i]);
                
                System.out.println("Course Allocated to this Room successfully in "+rooms[i].getRoomNumber());	
               break;
        	         }
        		
        	}
        	else  {
        	
        	}      
        }
		
        
    }
    public static void ScheduleMenu() 
    {
        Scanner input = new Scanner(System.in);
        int choice1 =0;
        do {
            System.out.println("choose from the menu, please enter the number :\n 1-Print student schedule \n 2-Print room schedule \n 3-Print instructor schedule ");
         
            choice1=input.nextInt();
            switch (choice1)
            {
                case 1:
                    System.out.println("Enter student ID: ");
                    int id = input.nextInt();
                    Student student = getStudentViaID(id);
                    while (student == null)
                    {
                        System.out.println("Enter a correct ID: ");
                        id = input.nextInt();
                    }
                    System.out.println("Student Name : " + student.getFullName() + ",  ID: " + student.getId() + ",   Gpa: " + student.getGPA());
                    System.out.println("Student Schedule :");
                    
                    student.StudentSchedule();
                    break;
                case 2:
                    System.out.println("Enter the room number: ");
                    int number = input.nextInt();
                    Room room = getRoomByNumber(number);
                    while (room == null) 
                    {
                        System.out.println("Enter a correct room number: ");
                        number = input.nextInt();
                        room = getRoomByNumber(number);
                    }
                    System.out.println("Room Number : " + room.getRoomNumber());
                    System.out.println("Room Schedule: ");
                    room.RoomSchedule();
                    break;
                case 3:
                    System.out.println("Enter the instructor id: ");
                    int id1 = input.nextInt();
                    Staff instructor = getStaffViaID(id1);
                    while (instructor == null) {
                        System.out.println("Enter a correct id : ");
                        id1 = input.nextInt();
                        instructor = getStaffViaID(id1);
                    }
                    System.out.println("The Schedule of the instructor is: ");
                    System.out.println("The instructor: " + instructor.getFullName() + " table is: ");
                    instructor.instructorSchedule();
            }
            
        } while (choice1 < 1 || choice1 > 3);
    }


    public static void  addCourseToStudent(Course course)
    {
    	boolean num=false;
    	boolean num2=false;
    	
    
  	  for (int i = 0; i <students.length; i++) 
  	  {  
  		Student student = students[i];
  		  if(student.getNumber()>0)
  		  {
  	//Check that the student dose not have more than 4 courses
  			  if(student.getNumber()!=4) 
  		         {
  		         
  			  for (int j = 0; j <student.getNumber();  j++) 
  			  { 
   //check that there is no conflict 
  		 			if (CheckCourses(course,student.getCourses()[j])) 
  		 			{
  		 				num=true;
  		 			}
  		 			else 
  		 			{
  		 				num2=false;
  		 			}
  		 			
  		 		     }
  		 			if((num||num2)!=true) 
  		 			{
  		 				student.addCourse(course);
  		 		      
  		 		        System.out.println("Course Assigned successfully to the students "+student.getFullName());
  		 		        break;
  		 			}
  		         }
  			  else {}
  		  }  
  		  else {
  			student.addCourse(course);
  		      
  		        System.out.println("Course Assigned successfully to the students "+student.getFullName());
  		        break;}
  		  }
  	 
  	  }
  		   	      
    
    public static void AssignCourseToInstructor(Course course)
    {
    	boolean num=false;
    	boolean num2=false;
    	for (int i = 0; i <staffs.length; i++) 
    	{
    		Staff instructor = staffs[i];
    //get the number of instructor courses
    		if(instructor.getNumber()>0) 
    		{
   //Check that the instructor dose not have more than 3 courses
    		if(instructor.getNumber()!=3)
    		{
    			for (int j = 0; j <instructor.getNumber();  j++) 
			    {
  //check that there is no conflict
				if (CheckCourses(course,instructor.getCourses()[j])) 
				{
					num=true;
				}
				else 
				{
					num2=false;
				}
    			
    		     }
    			if((num||num2)!=true) 
    			{
    				instructor.addCourse(course);
    				course.addstaff(instructor);
    				
    			    System.out.println("Course Assigned successfully to the instructor "+instructor.getFullName());
    			    break;
    			}
    			else {
    				
    			}
    			
    	     }
    		
    		}
    		else {
    			instructor.addCourse(course);
    		 course.addstaff(instructor);
			
		    System.out.println("Course Assigned successfully to the instructor "+instructor.getFullName());
		    break;
    		}
         }
    	
    }

}