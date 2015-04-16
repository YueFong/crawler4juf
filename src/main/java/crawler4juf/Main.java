package crawler4juf;
//import java.io.IOException;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Parsing("https://tw.stock.yahoo.com/q/q?s=2002");
//		ReadCSV("/Users/jufdata/Desktop/temp.csv");
//		WriteCSV("/Users/jufdata/Desktop/tempW.csv");
	}
	public static void ReadCSV(String csvFilename) throws Exception {
	
	CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
	String[] row = null;
	while((row = csvReader.readNext()) != null) {
	    System.out.println(row[0]
	              + " # " + row[1]
	              + " #  " + row[2]);
	}
	//...
	csvReader.close();
	}
	public static void WriteCSV(String csvFilename) throws Exception {
		
	
	CSVWriter writer = new CSVWriter(new FileWriter(csvFilename));
	 
	String [] country = "India#China#United States".split("#");
	 
	writer.writeNext(country);
	 
	writer.close();
	}
	public static void Parsing(String URLs) throws Exception {
		URL url = new URL(URLs); 
		Document xmlDoc =  Jsoup.parse(url, 3000); //使用Jsoup jar 去解析網頁
		//(要解析的文件,timeout)
		//Elements title = xmlDoc.select("title"); //要解析的tag元素為title
		Elements happy = xmlDoc.select("td");  //要解析的tag元素為td
			
//		System.out.println("Title is "+title.get(0).text()); //得到title tag的內容
		System.out.println("股票： "+happy.get(26).text()); //得到td tag的內容
		System.out.println("成交： "+happy.get(28).text()); //得到td tag的內容
		
		//注意: 因為有好多個td 我想要取得的是<td>樂</td> 是第2個td 所以填get(1)

	}
	
//
//	public static void processPage(String URL) throws SQLException, IOException{
//		//check if the given URL is already in database
//		String sql = "select * from Record where URL = '"+URL+"'";
//		ResultSet rs = db.runSql(sql);
//		if(rs.next()){
//
//		}else{
//			//store the URL to database to avoid parsing again
//			sql = "INSERT INTO  `Crawler`.`Record` " + "(`URL`) VALUES " + "(?);";
//			PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			stmt.setString(1, URL);
//			stmt.execute();
//
//			//get useful information
//			Document doc = Jsoup.connect("http://www.mit.edu/").get();
//
//			if(doc.text().contains("research")){
//				System.out.println(URL);
//			}
//
//			//get all links and recursively call the processPage method
//			Elements questions = doc.select("a[href]");
//			for(Element link: questions){
//				if(link.attr("href").contains("mit.edu"))
//					processPage(link.attr("abs:href"));
//			}
//		}
//	}
}