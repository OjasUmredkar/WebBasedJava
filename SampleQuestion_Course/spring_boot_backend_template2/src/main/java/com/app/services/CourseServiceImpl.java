package com.app.services;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CourseCustomException;
import com.app.dto.CourseDto;
import com.app.entities.Course;
import com.app.repositories.CourseRespository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRespository courseRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CourseDto saveCourse(@Valid CourseDto courseDto) {
		if(courseDto.getEndDate().isBefore(courseDto.getStartDate())) {
			throw new CourseCustomException("End date cannot be before end date");
		}
		Course course=mapper.map(courseDto,Course.class);
		return mapper.map(courseRepo.save(course), CourseDto.class);
	}

	@Override
	public CourseDto updateTheCourse(@Valid CourseDto courseDto) {
		if(courseDto.getEndDate().isBefore(courseDto.getStartDate())) {
			throw new CourseCustomException("End date cannot be before start date");
		}
		Course course=mapper.map(courseDto, Course.class);
		return mapper.map(courseRepo.save(course),CourseDto.class );
	}

	@Override
	public CourseDto getCourse(String courseName) {
		Course course=courseRepo.getCourseByName(courseName);
		if(course==null) {
			throw new CourseCustomException("Enter valid course name");
		}
		return mapper.map(course, CourseDto.class);
	
	}
	
	
	

	
	
}
