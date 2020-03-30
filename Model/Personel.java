package Model;
import java.util.ArrayList;

	import java.sql.ResultSet;

import DAL.DataAccess;

	
	public class Personel extends Person {
		//data members
		private String PersonelId;
		
		
		public String getPersonelId() {
			return PersonelId;
		}
		public void setPersonelId(String personelId) {
			PersonelId = personelId;
		}
		// Methods
		public int addPersonel(Personel p) throws Exception
		{
			DataAccess da = new DataAccess();
			String query = "insert into Personel(Name,Surname,Email,Password,PersonelId) values("+"'"+p.getName()+ "','"+p.getSurname()+"','"+p.getEmail()+"','"+p.getPassword()+"','"+p.getPersonelId()+"')";
			System.out.println(query);
			return da.ExecuteUpdate(query);
		}
		public int  deletePersonel(String PersonelId) throws Exception {
			String query =String.format("delete from Personel where Personelid = %s",PersonelId);
			DataAccess da = new DataAccess();
			return da.ExecuteUpdate(query);
		}
		public int  updatePersonel(Personel p) throws Exception {
			String query =String.format("update Personel set Name=%s " + 
					",Surname=%s,Email=%s,Password=%s" + 
					" where personelId =%s",
					p.getName()
					+p.getSurname()
					+p.getPassword()
					+p.getPersonelId());
			DataAccess da = new DataAccess();
			return da.ExecuteUpdate(query);
		}
		
		public ResultSet  loginPersonel(String Email,String Password) throws Exception {
			String query =String.format("select * from Personel where email= '%s' and password='%s'", Email, Password);
			//System.out.println(query);
			DataAccess da = new DataAccess();
			return da.ExecuteQuery(query);
		}
		public ResultSet  searchByName(String name) throws Exception
		{
			DataAccess da = new DataAccess();
			String query = "select * from personel where Name like '" + name + "%'"; // select from student mý?
			return da.ExecuteQuery(query);
		}
		public ResultSet searchPersonelByPersonelId(String PersonelId) throws Exception
		{
			DataAccess da = new DataAccess();
			String query = "select * from Personel where PersonelId like '" + PersonelId + "%'";
			return da.ExecuteQuery(query);
		}
		public ResultSet viewPersonel() throws Exception
		{
			DataAccess da = new DataAccess();
			String query = "select * from personel";
			return da.ExecuteQuery(query);
		}
		/*public ResultSet listPersonel() throws Exception
		{
			DataAccess da = new DataAccess();
			String sql = "select * from Personel";
			return da.ExecuteQuery(sql);
		}*/
	}

