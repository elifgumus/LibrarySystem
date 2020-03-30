package Model;

import java.sql.ResultSet; // 
 import java.util.ArrayList;

import DAL.DataAccess;

public class Student extends Person {
	private String StudentId;
	
	
	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	public int addStudent(Student std) throws Exception
	{
		
		String query = "insert into Student(Name,Surname,Email,Password,StudentId) values("+"'"+std.getName()+ "','"+std.getSurname()+"','"+std.getEmail()+"','"+std.getPassword()+"','"+std.getStudentId()+"')";
		System.out.println(query);
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int  deleteStudent(String StudentId) throws Exception {
		String query =String.format("delete from Student where Studentid = %s",StudentId);
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}

	public int  updateStudent (Student  std) throws Exception {
		String query =String.format("UPDATE Student SET Email="+std.getEmail()+","+
						"Password='"+std.getPassword()+"' WHERE StudentId="+std.getStudentId());
				
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public ResultSet  loginStudent(String Email,String Password) throws Exception {
		String query =String.format("select * from Student where email= '%s' and password='%s'", Email, Password);
		//System.out.println(query);
		DataAccess da = new DataAccess();
		return da.ExecuteQuery(query);
	}

	public ResultSet  searchByName(String name) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from Student where Name like '" + name + "%'"; // select from student mý?
		return da.ExecuteQuery(query);
	}
	public ResultSet searchStudentByStudentId(String StudentId) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from Student where StudentId like '" + StudentId + "%'";
		return da.ExecuteQuery(query);
	}
	
	public ResultSet viewStudent() throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from student";
		return da.ExecuteQuery(query);
	}
	/*public ResultSet listStudent() throws Exception
	{
		DataAccess da = new DataAccess();
		String sql = "select * from Student";
		return da.ExecuteQuery(sql);
	}*/


}