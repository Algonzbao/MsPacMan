package main;

import java.io.*;

public class Reader {
	
	private static final String path1 = "../MsPackmanEngine/src/main/resources/data/mazes/a.txt";
	private static final String paths[] = {"../a.txt", "../b.txt", "../c.txt"};
	
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		reader.readFile(path1);
		// reader.createFiles();
		// reader.readFiles();
	}
	private void createFiles() throws IOException {
		for (String path : paths)
			createFile(path);
	}
	private void createFile(String path) throws IOException{
		File file = new File(path);
		if (file.exists())
			System.out.println("El fichero ya existe.");
		else {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("Lorem ipsum");
			bw.write('\n');
			bw.write("Lorem ipsum");
			bw.close();
			System.out.println("El fichero se ha creado.");
		}
	}
	private void readFiles() throws IOException {
		for (String path : paths)
			readFile(path);
	}
	private void readFile(String path) throws IOException {
		BufferedReader bufReader = new BufferedReader(new FileReader(new File(path)));
		String string;
		while ((string = bufReader.readLine()) != null) {
			System.out.println(string);
		}
	}
}
