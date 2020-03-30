package Model;
import DAL.DataAccess;
import java.sql.ResultSet;
public class Gazete {
	private String Gazete;
	private String BasimTarihi;
	private String RafNo;
    private String GazeteId;
	
	public String getGazete() {
		return Gazete;
	}
	public void setGazete(String gazete) {
		Gazete = gazete;
	}
	public String getBasimTarihi() {
		return BasimTarihi;
	}
	public void setBasimTarihi(String basimTarihi) {
		BasimTarihi = basimTarihi;
	}
	public String getRafNo() {
		return RafNo;
	}
	public void setRafNo(String rafNo) {
		RafNo = rafNo;
	}
	public String getGazeteId() {
		return GazeteId;
	}
	public void setGazeteId(String gazeteId) {
		GazeteId = gazeteId;
	}
	
	public int AddGazete(Gazete g) throws Exception
	{
	DataAccess da = new DataAccess();
	String query = "insert into Gazete(Gazete,BasimTarihi,RafNo,GazeteId) values("+"'"+g.getGazete()+ "','"+g.getBasimTarihi()+"','"+g.getRafNo()+"','"+g.getGazeteId()+"')";
	return da.ExecuteUpdate(query);
	}
	public int UpdateGazete(Gazete g) throws Exception
	{
		String query =String.format("update Gazete set Gazete=%s " + 
				",BasimTarihi=%s,RafNo=%s,GazeteEki=%s" + 
				" where GazeteId =%s",
				g.getGazete()
				+g.getBasimTarihi()
				+g.getRafNo()
				+g.getGazeteId());
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public int  deleteGazete(String GazeteId) throws Exception {
		String query =String.format("delete from Gazete where Gazeteid = %s",GazeteId);
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
/*	 public ResultSet searchGazeteByGazeteId(String GazeteId) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = String.format("select * from Gazete where Gazeteid like '" + GazeteId + "%'"; 
		return da.ExecuteQuery(query);
	} */
	public ResultSet searchGazeteByGazeteId(String GazeteId) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from Gazete where GazeteId like '" + GazeteId + "%'";
		return da.ExecuteQuery(query);
	}
	
	/*public ResultSet searchGazeteByName(String gazete) throws Exception
	{
		DataAccess da = new DataAccess();
		//String query = String.format("select * from book where Book like '%s%'",Book);
		
		String query = "select * from gazete where Dergi like '" + gazete + "%'"; // küçük book ? büyük book
		//JOptionPane.showMessageDialog(null,query);
		return da.ExecuteQuery(query);
	}*/
	public ResultSet searchGazeteByGazete(String Gazete) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from gazete where Gazete like '" + Gazete + "%'";
		//JOptionPane.showMessageDialog(null,query);
		return da.ExecuteQuery(query);
	}
	public ResultSet viewGazete() throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from gazete";
		return da.ExecuteQuery(query);
	}

	public ResultSet listGazete() throws Exception
	{
		DataAccess da = new DataAccess();
		String sql = "select 0 as gazeteId, 'Select gazete' as name union all  select * from Gazete";
		return da.ExecuteQuery(sql);
	}
	
	
	

}
