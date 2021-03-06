package com.studentRest.studentDetails;

import java.lang.annotation.Repeatable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.DatabaseConnection;
import com.dto.StudentDetail;
import com.dto.StudentMarksheet;

@Path("/student")
public class StudentImpl implements Student
{
	DatabaseConnection databaseConnection = new DatabaseConnection();

	@GET
	@Path("/getAllStudent")
	@Produces( { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML } )
	@Override
	public List<StudentDetail> getAllStudent()
	{
		return databaseConnection.getAllStudent();
	}

	@POST
	@Path("/addStudent")
	@Consumes(MediaType.APPLICATION_XML)
	@Override
	public void addStudent(StudentDetail studentDetails)
	{
		String studentName = studentDetails.getStudentName();
		String studentAddress = studentDetails.getStudentAddress();
		databaseConnection.addStudent(studentName, studentAddress);	
	}

	@POST
	@Path("/addStudentMarksheet")
	@Consumes(MediaType.APPLICATION_XML)
	@Override
	public void addStudentMarksheet(StudentMarksheet studentMarksheet)
	{
		int history = studentMarksheet.getHistory();
		int geography = studentMarksheet.getGeography();
		int math = studentMarksheet.getMath();
		
		databaseConnection.addStudentMarksheet(history, geography, math);
		
	}

	@DELETE
	@Path("/deleteStudent")
	@Consumes(MediaType.APPLICATION_XML)
	@Override
	public void deleteStudent(StudentDetail studentDetail)
	{
		int rollNo = studentDetail.getRollNo();
		databaseConnection.deleteStudent(rollNo);	
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getStudentMarksheet")
	@Override
	public List<StudentMarksheet> getAllStudentMarsheet()
	{	
		return databaseConnection.getStudentMarksheet();	
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/UpdateStudent")
	@Override
	public void updateStudent(StudentDetail studentDetail)
	{
		String studentName = studentDetail.getStudentName();
		String studentAddress = studentDetail.getStudentAddress();
		int rollNo = studentDetail.getRollNo(); 
		databaseConnection.updateStudent(studentName, studentAddress, rollNo);
	}
	
}
