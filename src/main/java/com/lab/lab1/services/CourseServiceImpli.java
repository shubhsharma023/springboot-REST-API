package com.lab.lab1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lab.lab1.entities.Course;

@Service
public class CourseServiceImpli implements CourseService {

	List<Course> list;
	public CourseServiceImpli() {
		list=new ArrayList<>();
		list.add(new Course(201, "English", " This course contains basis of english grammer"));
		list.add(new Course(306, "Sanskrit", " This course contains Sanskrit to its core"));
		list.add(new Course(430, "Spring", " This course contains Spring boot for beginner level"));
		list.add(new Course(457, "Postman", " This course contains Postman functioning for beginner to advanced level"));
		
		
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
		list.forEach(e ->{
			if (e.getId()==course.getId()) {  
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}
	@Override
	public void deleteCourse(Long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}

}
