import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirWalker {
	
	public static String DateExtract;
	
	public void walk( String path ) {
    	try {
    	SimpleCsvParser csvParse = new SimpleCsvParser();
        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {  
                walk( f.getAbsolutePath() );
            }
            else {
            	if (!f.getAbsolutePath().endsWith(".csv")) continue;
                
                // REGEX 
                Pattern ptrn = Pattern.compile("(\\d){4}[/](\\d){1,2}[/](\\d){1,2}");
                Matcher m = ptrn.matcher(f.getAbsolutePath());
                while (m.find()) {
                	DateExtract = m.group();
                }
                
                //CSVParser
                csvParse.CSVParsermethod(f.getAbsolutePath());
            }
        }
    }
    	catch (Exception q) {
    		Logger.getLogger("Main").log(Level.INFO,q.getMessage() + "\n");
    	}
    }
	
	public String Date() {
		return DateExtract;
	}

    public static void main(String[] args) {
    	
	      System.setProperty("java.util.logging.config.file",
	              "./logging.properties");
	      
    	final long startTime = System.currentTimeMillis();
    	
    	DirWalker fw = new DirWalker();
        fw.walk("/home/student_2018_fall/r_gupta/MCDA5510_Assignments/Sample Data");
        
//        System.out.println("Records " + SimpleCsvParser.rec);
//        System.out.println("Skipped " + SimpleCsvParser.skip);
        
        final long endTime = System.currentTimeMillis();
//        System.out.println("Total execution time: " + (endTime - startTime) +" ms");
        
        Logger.getLogger("Main").log(Level.INFO,"\nRecords: " + SimpleCsvParser.rec + "\nSkipped: " + SimpleCsvParser.skip + "\n");
        Logger.getLogger("Main").log(Level.INFO,"\nTotal execution time: " + (endTime - startTime) +" ms");
    }	

}