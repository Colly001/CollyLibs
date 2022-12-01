package;

import java.util.Vector;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.lang.NullPointerException;

public class CollyLibs
{
	public String firstLineOf(String tUser)
	{
		try{
			try{
				String path1 = tUser;
				File filerefe = new File(path1);
				if(!filerefe.exists()){
					File yourFile = new File(path1);
					yourFile.createNewFile();
					FileOutputStream oFile = new FileOutputStream(yourFile, false);
				}
				FileReader file = new FileReader(path1);
				BufferedReader buffer = new BufferedReader(file);
				String line = buffer.readLine();
				System.out.println(line);
				if(line != null){
					return line;
				}
			}catch(FileNotFoundException er){}
		}catch(IOException e){}
		return null;
	}
	
	public void addInFile(String thisUser, String toUser)
	{
		var toUserPath = toUser;
		File filerefer = new File(toUserPath);
		if(filerefer.exists()){
			try{
			frdata = thisUser;
			final Writer writer = new FileWriter(toUser, true);
			writer.append(thisUser + "\n");
			writer.close();
		}catch(IOException e){}
		}
	}
	
	public void removeLineFromFile(String file, String lineToRemove) {
		try {
			Fle inFile = new File(file);
		if (!inFile.isFile()) {
			System.out.println("Parameter is not an existing file");
			return;
		}
		File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
		BufferedReader br = new BufferedReader(new FileReader(file));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
		String line = null;
		while ((line = br.readLine()) != null) {
		if (!line.trim().equals(lineToRemove)) {
			pw.println(line);
			pw.flush();
		}
		}
		pw.close();
		br.close();
		if (!inFile.delete()) {
			System.out.println("Could not delete file");
			return;
		}
		if (!tempFile.renameTo(inFile))
			System.out.println("Could not rename file");
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}