package Model;

	import DAL.DataAccess;
	import java.sql.ResultSet;
	public class Kitap {
		
	private String Book;
	private String Author;
	private String Publisher;
	private String BookTypes; 
	private String YearOfIssue;
	private String ShelfNumber;
	private String BookId;


	public int addKitap(Kitap k) throws Exception
	{
	DataAccess da = new DataAccess();
	String query = "insert into Kitap(Book,Author,Publisher,BookTypes,YearOfIssue,ShelfNumber,BookId) values("+"'"+k.getBook()+ "','"+k.getAuthor()+"','"+k.getPublisher()+"','"+k.getBookTypes()+"','"+k.getYearOfIssue()+"','"+k.getShelfNumber()+"','"+k.getBookId()+"')";
	return da.ExecuteUpdate(query);
	}
	public int  updateKitap (Kitap k) throws Exception {
		String query =String.format("UPDATE Kitap SET Publisher="+k.getPublisher()+","+
						"ShelfNumber='"+k.getShelfNumber()+"' WHERE BookId="+k.getBookId());
				
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public int  deleteKitap(String BookId) throws Exception {
		String query =String.format("delete from Kitap where Bookid = %s",BookId);
		DataAccess da = new DataAccess();
		return da.ExecuteUpdate(query);
	}
	

	public String getBook() {
		return Book;
	}
	public void setBook(String book) {
		Book = book;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getBookTypes() {
		return BookTypes;
	}
	public void setBookTypes(String bookTypes) {
		BookTypes = bookTypes;
	}
	public String getYearOfIssue() {
		return YearOfIssue;
	}
	public void setYearOfIssue(String yearOfIssue) {
		YearOfIssue = yearOfIssue;
	}
	public String getShelfNumber() {
		return ShelfNumber;
	}
	public void setShelfNumber(String shelfNumber) {
		ShelfNumber = shelfNumber;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public ResultSet searchKitapByBookId(String BookId) throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from Kitap where BookId like '" + BookId + "%'";
		return da.ExecuteQuery(query);
	}
	

	public ResultSet searchKitapByBook(String Book) throws Exception
	{
		DataAccess da = new DataAccess();
		//String query = String.format("select * from department where Name like '%s%'",name);
		
		String query = "select * from kitap where Book like '" + Book + "%'";
		//JOptionPane.showMessageDialog(null,query);
		return da.ExecuteQuery(query);
	}
	
	public ResultSet viewKitap() throws Exception
	{
		DataAccess da = new DataAccess();
		String query = "select * from kitap";
		return da.ExecuteQuery(query);
	}

	public ResultSet listKitap() throws Exception
	{
		DataAccess da = new DataAccess();
		String sql = "select * from Kitap";
		return da.ExecuteQuery(sql);
	}
	}
