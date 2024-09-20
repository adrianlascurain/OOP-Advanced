package generations.classes;


import generation.exceptions.CourseNotFoundException;
import generation.exceptions.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    
	    // Showing courses
	    studentService.showAllCourses();
        System.out.println("\n");
	    
        studentService.getStudents().put( "1030", new Student( "Carlos", "1030", 31 ) );
        studentService.getStudents().put( "1040", new Student( "Ian", "1020", 28 ) );
        studentService.getStudents().put( "1050", new Student( "Elise", "1020", 26 ) );
        studentService.getStudents().put( "1020", new Student( "Santiago", "1020", 33 ) );

        // Enrolling students
        System.out.println("=========Enrolling students============");
        try {
			studentService.enrollStudents( "Math", "1030" );
			studentService.enrollStudents( "Art", "1020" );
			studentService.enrollStudents( "Biology", "1020" );
			studentService.enrollStudents( "Art", "1050" );
			studentService.enrollStudents( "Biology", "1040" );
			studentService.enrollStudents( "Biology", "1030" );
			studentService.enrollStudents( "Biology", "1040" );
			studentService.enrollStudents( "Physics", "1040" );
			studentService.enrollStudents( "History", "1040" );
			studentService.enrollStudents( "History", "1040" );
			studentService.enrollStudents( "History", "1040" );
			studentService.enrollStudents( "History", "1040" );
		} catch (CourseNotFoundException e) {
			System.out.println("Course not found");
		} catch(StudentNotFoundException e) {
			System.out.println("Student not found");
		}
        
        // Showing enrolled students in each course       
        studentService.showEnrolledStudents("Math");
        System.out.println("\n");
        
        studentService.showEnrolledStudents("Art");
        System.out.println("\n");
        
        studentService.showEnrolledStudents("Biology");
        System.out.println("\n");

        studentService.showEnrolledStudents("Physics");
        System.out.println("\n");
        
        studentService.showEnrolledStudents("History");
        System.out.println("\n");
        
        // Unenrolling students
        System.out.println("=========Unenrolling students============");
        try {
			studentService.unEnrollStudents( "Math", "1030" );
			studentService.unEnrollStudents( "Art", "1020" );
			studentService.unEnrollStudents( "Physichs", "1100" );
		} catch (CourseNotFoundException e) {
			System.out.println("Course not found");
		} catch(StudentNotFoundException e) {
			System.out.println("Student not found");
		}
        
        // Showing enrolled students in each course       
        studentService.showEnrolledStudents("Math");
        System.out.println("\n");
        
        studentService.showEnrolledStudents("Art");
        System.out.println("\n");
        
        studentService.showEnrolledStudents("Biology");
        System.out.println("\n");

        studentService.showEnrolledStudents("Physics");
        System.out.println("\n");
        
        studentService.showEnrolledStudents("History");
        System.out.println("\n");
        
        for(Course course:studentService.getStudents().get("1030").getCourseList()) {
        	System.out.println(course);
        }

    }
}