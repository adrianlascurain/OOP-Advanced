package generations.classes;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class Student {
	
    private String name;
    private String id;
    private int age;

    private final List<Course> courseList = new ArrayList<>();

    public Student( String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    } // Public student

    // Getters and setters
	public String getName() {
		return name;
	} // getName

	public void setName(String name) {
		this.name = name;
	} // setName

	public String getId() {
		return id;
	} // getId

	public void setId(String id) {
		this.id = id;
	} // setId

	public int getAge() {
		return age;
	} // getAge

	public void setAge(int age) {
		this.age = age;
	} // setAge

	public List<Course> getCourseList() {
		return courseList;
	} // getCourseList
	
	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	public void deleteCourse(Course course) {
		courseList.remove(course);
	}
    
    
    
} // Class Student
