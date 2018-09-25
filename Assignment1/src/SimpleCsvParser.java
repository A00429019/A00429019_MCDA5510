import java.io.FileReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleCsvParser {
		public static int skip = 0;
		public static int rec = 0;

	public void CSVParsermethod (String path) {

	    WriteToCSV write = new WriteToCSV();
		
		Reader in;
		try {
			in = new FileReader(path);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
			for (CSVRecord record : records) {
				
			    String Fname = record.get(0);
			    String Lname = record.get(1);
			    String StNo = record.get(2);
			    String Street = record.get(3).indexOf(",") >=0 ? "\""+record.get(3)+"\"" : record.get(3);
			    String City = record.get(4).indexOf(",") >=0 ? "\""+record.get(4)+"\"" : record.get(4);
			    String Province = record.get(5).indexOf(",") >=0 ? "\""+record.get(5)+"\"" : record.get(5);
			    String PostalCode = record.get(6);
			    String Country = record.get(7);
			    String PhNo = record.get(8);
			    String email = record.get(9);
			    
			    if (Fname.isEmpty() || Lname.isEmpty() || StNo.isEmpty() || Street.isEmpty() || City.isEmpty() || Province.isEmpty() || PostalCode.isEmpty() || Country.isEmpty() || PhNo.isEmpty() || email.isEmpty()) {
			    	skip++;
			    }
			    else {
			    	write.FileWritermethod(Fname, Lname, StNo, Street, City, Province, PostalCode, Country, PhNo, email);
			    	rec++;
			    }		    
			}			
			
		} catch ( Exception q) {
			Logger.getLogger("Main").log(Level.INFO,q.getMessage() + "\n");
		}
	}
}
