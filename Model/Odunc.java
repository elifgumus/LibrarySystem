package Model;
 //import java.util.Date;
import DAL.DataAccess;
import java.sql.ResultSet;
public class Odunc {
	private String OduncAlma;
	private String AlmaTarihi;
	private String OduncAlan;
	
	public String getOduncAlma() {
		return OduncAlma;
	}
	public void setOduncAlma(String oduncAlma) {
		OduncAlma = oduncAlma;
	}
	public String getAlmaTarihi() {
		return AlmaTarihi;
	}
	public void setAlmaTarihi(String almaTarihi) {
		AlmaTarihi = almaTarihi;
	}
	public String getOduncAlan() {
		return OduncAlan;
	}
	public void setOduncAlan(String oduncAlan) {
		OduncAlan = oduncAlan;
	}
	public int AddOdunc(Odunc o) throws Exception
	{
	DataAccess da = new DataAccess();
	String query = "insert into Odunc(OduncAlma,AlmaTarihi,OduncAlan) values("+"'"+o.getOduncAlma()+ "','"+o.getAlmaTarihi()+"','"+o.getOduncAlan()+"')";
	return da.ExecuteUpdate(query);
	}
	
	
	
	
	
}
