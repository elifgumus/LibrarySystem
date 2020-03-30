package Model;
import DAL.DataAccess;
import java.sql.ResultSet;
public class Dergi {

	private String Dergi;
	private String DergiSayisi;
	private String DergiTuru; 
	private String BasimAyi;
	private String RafNo;
	private String DergiId;

	public String getDergi() {
		return Dergi;
	}
	public void setDergi(String dergi) {
		Dergi = dergi;
	}
	public String getDergiSayisi() {
		return DergiSayisi;
	}
	public void setDergiSayisi(String dergiSayisi) {
		DergiSayisi = dergiSayisi;
	}
	public String getDergiTuru() {
		return DergiTuru;
	}
	public void setDergiTuru(String dergiTuru) {
		DergiTuru = dergiTuru;
	}
	public String getBasimAyi() {
		return BasimAyi;
	}
	public void setBasimAyi(String basimAyi) {
		BasimAyi = basimAyi;
	}
	public String getRafNo() {
		return RafNo;
	}
	public void setRafNo(String rafNo) {
		RafNo = rafNo;
	}
	public String getDergiId() {
		return DergiId;
	}
	public void setDergiId(String dergiId) {
		DergiId = dergiId;
	}
	
	public int addDergi(Dergi d) throws Exception
	{
	DataAccess da = new DataAccess();
	String query = "insert into Dergi(Dergi,DergiSayisi,DergiTuru,BasimAyi,RafNo,DergiId) values("+"'"+d.getDergi()+ "','"+d.getDergiSayisi()+"','"+d.getDergiTuru()+"','"+d.getBasimAyi()+"','"+d.getRafNo()+"','"+d.getDergiId()+"')";
	return da.ExecuteUpdate(query);
	}
	public int UpdateDergi(Dergi d) throws Exception
	{
		String query =String.format("update Dergi set Dergi=%s " + 
				",DergiSayisi = %s,DergiTuru=%s,BasimAyi=%s,RafNo=%s" + 
				" where DergiId =%s",
				d.getDergi()
				+d.getDergiSayisi()
				+d.getDergiTuru()
				+d.getBasimAyi()
				+d.getRafNo()
				+d.getDergiId());
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public int  deleteDergi(String DergiId) throws Exception {
		String query =String.format("delete from Dergi where Dergiid = %s",DergiId);
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	/*public ResultSet searchDergiByDergiId(String DergiId) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = String.format("select * from Dergi where Dergiid = ",DergiId);
		return da.ExecuteQuery(query);
	}*/
	public ResultSet searchDergiByDergiId(String DergiId) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from Dergi where DergiId like '" + DergiId + "%'";
		return da.ExecuteQuery(query);
	}
	
	
	/*public ResultSet searchDergiByName(String dergi) throws Exception
	{
		DataAccess da = new DataAccess();
		//String query = String.format("select * from book where Book like '%s%'",Book);
		String query = "select * from dergi where Dergi like '" + dergi + "%'"; // küçük book ? büyük book
		//JOptionPane.showMessageDialog(null,query);
		return da.ExecuteQuery(query);
	}*/
	
	public ResultSet searchDergiByDergi(String Dergi) throws Exception
	{
		DataAccess da = new DataAccess();
		//String query = String.format("select * from department where Name like '%s%'",name);
		
		String query = "select * from dergi where Dergi like '" + Dergi + "%'";
		//JOptionPane.showMessageDialog(null,query);
		return da.ExecuteQuery(query);
	}
	
	public ResultSet viewDergi() throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from dergi";
		return da.ExecuteQuery(query);
	}

	public ResultSet listDergi() throws Exception
	{
		DataAccess da = new DataAccess();
		String sql = "select 0 as dergiId, 'Select dergi' as name union all  select * from Dergi";
		return da.ExecuteQuery(sql);
	}
}
