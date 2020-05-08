package com.pedro.primer.certification.io;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilePioneer {
	
	private static void testFileMethods(){
		String path = "C:\\Users\\Pedro\\Pictures\\Trips and Visits\\reorganize-bitch";
		File directory = new File(path);
		
		System.out.println("does this exist? "+directory.exists());
		if(directory.exists()){
			System.out.println("id directory? "+directory.isDirectory());
			if(directory.isDirectory()){
				for(File file: directory.listFiles()){
					System.out.println("Name: "+file.getName() +" - Is file? "+file.isFile());
				}
			}
		}
	}
	
	public static void main (String ...args){
		userInsertCoin();
	}
	
	public static void playWithFileStreams() throws FileNotFoundException, IOException{
		//C:\Users\Pedro\Pictures\iPhone
		
		//String source="C:\\Users\\Pedro\\Pictures\\iPhone\\IMG_0604 - Copy.JPG";
		String source="C:\\Users\\Pedro\\Pictures\\iPhone\\IMG_0425.JPG";
		//String source="C:\\Users\\Pedro\\Pictures\\iPhone\\IMG_0604 Copy.JPG";
		String destination="C:\\Users\\Pedro\\Pictures\\iPhone\\ILoveThatWoman.JPG";
		File sourceFile = new File (source);
		File destinationFile = new File (destination);
		try(InputStream in = new FileInputStream(sourceFile);
				OutputStream out = new FileOutputStream(destinationFile)){
			int b;
			while ((b=in.read())!=-1){
				System.out.println("reading");
				out.write(b);
			}
		}
	}
	
	public static void userInsertCoin(){
		Console console = System.console();
		if(console!=null){
			String messagio = console.readLine("Si te gusta ella dime que si: ");
			if("si".equalsIgnoreCase(messagio)){
				System.out.println("LO SABIA");
			}else{
				System.out.println("DICHOSO TU, PERO LOCO");
			}
		}else{
			System.out.println("te jodes");
		}
	}

}
