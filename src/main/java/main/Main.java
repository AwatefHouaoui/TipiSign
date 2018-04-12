/**
 * 
 */
package main;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author awatef
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String string = "2014-07-01T14:59:55.711Z";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		Date date = format.parse(string);
		Timestamp timestamp = new Timestamp(date.getTime());
		System.out.println(timestamp); // Sat Jan 02 00:00:00 GMT 2010

	}

}
