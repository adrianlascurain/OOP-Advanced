package generations.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import generation.exceptions.CourseNotFoundException;
import generation.exceptions.StudentNotFoundException;

public class StudentService {
	
    private HashMap<String, Course> courseList = new HashMap<>();
    private HashMap<String, Student> students = new HashMap<>();
    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();
	private int studentCounter;


    public StudentService() {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    } // Public StudentService

    public void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException{
        
    	// Check if course exists
    	if(!courseList.containsKey(courseName)) {
    		throw new CourseNotFoundException();
    	}
    	
    	// Check if student exists
    	if(!students.containsKey(studentID)) {
    		throw new StudentNotFoundException();
    	}
    	
    	// Get course
    	Course course = courseList.get( courseName );
//    	Student student = students.get(studentID);
//    	boolean alreadyEnrolled = false;
    	
        if ( !coursesEnrolledByStudents.containsKey( studentID ) ) {
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        
        if(!coursesEnrolledByStudents.get(studentID).contains(course)) {
        	students.get(studentID).addCourse(course);
            coursesEnrolledByStudents.get( studentID ).add( course );
        }
        
        // Forma más larga y complicada de resolver el problema 
//        for(Course studentCourse : student.getCourseList()) {
//        	if(studentCourse.getName().equals(courseName)) {
//        		alreadyEnrolled = true;
//        		break;
//        	};
//        }
//        
//        if(!alreadyEnrolled) {
//            students.get(studentID).addCourse(course);
//            coursesEnrolledByStudents.get( studentID ).add( course );
//        }
        
    } // Public enrollStudents

    public void unEnrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException {
    	// Check if course exists
    	if(!courseList.containsKey(courseName)) {
    		throw new CourseNotFoundException();
    	}
    	
    	// Check if student exists
    	if(!students.containsKey(studentID)) {
    		throw new StudentNotFoundException();
    	}
    
    	// Get course
    	Course course = courseList.get( courseName );

    	// Unenroll student
        if ( coursesEnrolledByStudents.containsKey( studentID )){
            coursesEnrolledByStudents.get( studentID ).remove( course );
            students.get(studentID).deleteCourse(course);
        }
    } // Public unEnrollStudents

    public void showEnrolledStudents(String courseId) {

    	System.out.println("Students enrolled in " + courseId + ":");
    	
    	this.studentCounter = 0;
    	// Iterate over hash map
    	coursesEnrolledByStudents.forEach((studentID, courseList) -> {
    		for(Course course: courseList) {
    			// If student is enrolled in the course, show his or her name and id
    			if(course.getName().equals(courseId)) {
    				this.studentCounter++;
    				System.out.println(this.studentCounter + ". " + students.get(studentID).getName() + "(ID: " + studentID + ")");
    				break;
    			}    			
    		}
    	});
    	
    	if(this.studentCounter == 0) {
    		System.out.println("- No students enrolled");
    	}
    	
    	
    } // Public showEnrolledStudents

    public void showAllCourses() {
    	System.out.println("Courses available: ");
        for(Course course :courseList.values()) {
        	System.out.println(course);
        }
    	
    } // Public showAllCourses

    
    // Getters and setters
    
	public HashMap<String, Course> getCourseList() {
		return courseList;
	} // getCourseList

	public void setCourseList(HashMap<String, Course> courseList) {
		this.courseList = courseList;
	} // setCourseList

	public HashMap<String, Student> getStudents() {
		return students;
	} // getStudents

	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	} // setStudents

	public HashMap<String, List<Course>> getCoursesEnrolledByStudents() {
		return coursesEnrolledByStudents;
	} // getCoursesEnrolledByStudents

	public void setCoursesEnrolledByStudents(HashMap<String, List<Course>> coursesEnrolledByStudents) {
		this.coursesEnrolledByStudents = coursesEnrolledByStudents;
	} // setCoursesEnrolledByStudents
    
    
} // Class StudentService