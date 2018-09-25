import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteToCSV {
	
	
	DirWalker obj = new DirWalker();
	
	public void FileWritermethod(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j) throws IOException {
		FileWriter writer;
		try {
			
			String tempfile = "/home/student_2018_fall/r_gupta/MCDA5510_Assignments/output.csv";
			File check = new File(tempfile);
			if(!check.exists()) {
				writer = new FileWriter(tempfile);
				writer.write("First Name,Last Name,Street Number,Street,City,Province,Postal Code,Country,Phone Number,email Address, Date\n");
				writer.close();
			}
			writer = new FileWriter(tempfile, true);
			
			writer.write(a + "," + b + "," + c + "," + d + "," + e + "," + f + "," + g + "," + h + "," + i + "," + j + "," + obj.Date() + "\n");
			writer.flush();	
			writer.close();
		}
		catch (Exception q) {
			Logger.getLogger("Main").log(Level.INFO,q.getMessage() + "\n");
		}
	}
}