import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import com.csvreader.CsvWriter;


public class exTest {

	public static void createKMLFile(File file) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		ArrayList<String> a = new ArrayList<String>();
		String str = raf.readLine();
		String[] dataSplit = null;
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<kml xmlns=\"http://earth.google.com/kml/2.2\">\n";
		String kmlelement = null;
		String kmlend = null;
		String time = null;
		Scanner sc = new Scanner(System.in);
		while(str != null){
			a.add(str);
			str = raf.readLine();
		}	
		raf.seek(0);
		raf.readLine();
		str = raf.readLine();
		System.out.println("Chose the folowing options: 1.All data\t"
				+ "2.Time\t"
				+ "3.ID\t"
				+ "4.Coordinates");
		int choise = sc.nextInt();
			switch(choise){
			case 1:
				dataSplit = str.split(",");
				while(dataSplit.length > 4){
					kmlelement ="\t<Placemark>\n" +
							"\t<name>"+dataSplit[1]+"</name>\n" +
							"\t<description>"+dataSplit[0]+"</description>\n" +
							"\t<Point>\n" +
							"\t\t<coordinates>"+dataSplit[2]+","+dataSplit[3] + "</coordinates>\n" +
							"\t</Point>\n" +
							"\t</Placemark>\n";
					kmlend = "</kml>";
					str = raf.readLine();
					dataSplit = str.split(",");
					ArrayList<String> content = new ArrayList<String>();
					content.add(0,kmlstart);
					content.add(1,kmlelement);
					content.add(2,kmlend);

					String kmltest = content.get(0) + content.get(1) + content.get(2);


					File testexists = new File("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
					Writer fwriter;

					if(!testexists.exists()){
						try {
							fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
							fwriter.write(kmltest);	
							fwriter.flush();
							fwriter.close();
						}catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}   
					}
					else{
						String filecontent ="";
						ArrayList<String> newoutput = new ArrayList<String>();;

						try {
							BufferedReader in = new BufferedReader(new FileReader(testexists));
							while((filecontent = in.readLine()) !=null)
								
								newoutput.add(filecontent + "\n");

						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						newoutput.add(2,kmlelement);

						String rewrite ="";
						for(String s : newoutput){
							rewrite += s;
						}

						try {
							fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
							fwriter.write(rewrite);
							fwriter.flush();
							fwriter.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;
			case 2:
				System.out.println("Enter Time:");
				sc = new Scanner(System.in);
				time = sc.nextLine();
				dataSplit = str.split(",");
				while(dataSplit.length > 4){
					dataSplit = str.split(",");
					if(dataSplit[0].equals(time)){
						kmlelement ="\t<Placemark>\n" +
								"\t<name>"+dataSplit[1]+"</name>\n" +
								"\t<description>"+dataSplit[0]+"</description>\n" +
								"\t<Point>\n" +
								"\t\t<coordinates>"+dataSplit[2]+","+dataSplit[3]+ "</coordinates>\n" +
								"\t</Point>\n" +
								"\t</Placemark>\n";
						kmlend = "</kml>";
						str = raf.readLine();
						ArrayList<String> content = new ArrayList<String>();
						content.add(0,kmlstart);
						content.add(1,kmlelement);
						content.add(2,kmlend);

						String kmltest = content.get(0) + content.get(1) + content.get(2);


						File testexists = new File("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
						Writer fwriter;

						if(!testexists.exists()){
							try {
								fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
								fwriter.write(kmltest);	
								fwriter.flush();
								fwriter.close();
							}catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}   
						}
						else{
							String filecontent ="";
							ArrayList<String> newoutput = new ArrayList<String>();;

							try {
								BufferedReader in = new BufferedReader(new FileReader(testexists));
								while((filecontent = in.readLine()) !=null)
									
									newoutput.add(filecontent + "\n");

							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							newoutput.add(2,kmlelement);

							String rewrite ="";
							for(String s : newoutput){
								rewrite += s;
							}

							try {
								fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
								fwriter.write(rewrite);
								fwriter.flush();
								fwriter.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else{
						str = raf.readLine();
						dataSplit = str.split(",");
					}
				}
				break;
			case 3:
				System.out.println("Enter ID:");
				sc = new Scanner(System.in);
				String id = sc.nextLine();
				dataSplit = str.split(",");
				while(dataSplit.length > 4){
					if(dataSplit[1].equals(id)){
						kmlelement ="\t<Placemark>\n" +
								"\t<name>"+dataSplit[1]+"</name>\n" +
								"\t<description>"+dataSplit[0]+"</description>\n" +
								"\t<Point>\n" +
								"\t\t<coordinates>"+dataSplit[2]+","+dataSplit[3]+"</coordinates>\n" +
								"\t</Point>\n" +
								"\t</Placemark>\n";
						kmlend = "</kml>";
						str = raf.readLine();
						dataSplit = str.split(",");
						ArrayList<String> content = new ArrayList<String>();
						content.add(0,kmlstart);
						content.add(1,kmlelement);
						content.add(2,kmlend);

						String kmltest = content.get(0) + content.get(1) + content.get(2);


						File testexists = new File("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
						Writer fwriter;

						if(!testexists.exists()){
							try {
								fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
								fwriter.write(kmltest);	
								fwriter.flush();
								fwriter.close();
							}catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}   
						}
						else{
							String filecontent ="";
							ArrayList<String> newoutput = new ArrayList<String>();;

							try {
								BufferedReader in = new BufferedReader(new FileReader(testexists));
								while((filecontent = in.readLine()) !=null)
									
									newoutput.add(filecontent + "\n");

							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							newoutput.add(2,kmlelement);

							String rewrite ="";
							for(String s : newoutput){
								rewrite += s;
							}

							try {
								fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
								fwriter.write(rewrite);
								fwriter.flush();
								fwriter.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else{
						str = raf.readLine();
						dataSplit = str.split(",");
					}
				}
				break;
			case 4:
				System.out.println("Enter Coordinates:");
				sc = new Scanner(System.in);
				String cord = sc.nextLine();
				dataSplit = str.split(",");
				while(dataSplit.length > 4){
					dataSplit = str.split(",");
					if(dataSplit[2].equals(cord)||dataSplit[3].equals(cord)||dataSplit[4].equals(cord)){
						kmlelement ="\t<Placemark>\n" +
								"\t<name>"+dataSplit[1]+"</name>\n" +
								"\t<description>"+dataSplit[0]+"</description>\n" +
								"\t<Point>\n" +
								"\t\t<coordinates>"+dataSplit[2]+","+dataSplit[3]+"</coordinates>\n" +
								"\t</Point>\n" +
								"\t</Placemark>\n";
						kmlend = "</kml>";
						str = raf.readLine();
						ArrayList<String> content = new ArrayList<String>();
						content.add(0,kmlstart);
						content.add(1,kmlelement);
						content.add(2,kmlend);

						String kmltest = content.get(0) + content.get(1) + content.get(2);


						File testexists = new File("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
						Writer fwriter;

						if(!testexists.exists()){
							try {
								fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
								fwriter.write(kmltest);	
								fwriter.flush();
								fwriter.close();
							}catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}   
						}
						else{
							String filecontent ="";
							ArrayList<String> newoutput = new ArrayList<String>();;

							try {
								BufferedReader in = new BufferedReader(new FileReader(testexists));
								while((filecontent = in.readLine()) !=null)
									
									newoutput.add(filecontent + "\n");

							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							newoutput.add(2,kmlelement);

							String rewrite ="";
							for(String s : newoutput){
								rewrite += s;
							}

							try {
								fwriter = new FileWriter("C:/Users/IsraelPC/workspace/Ex0/kmlTest1.kml");
								fwriter.write(rewrite);
								fwriter.flush();
								fwriter.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							str = raf.readLine();
						}
					}
					else{
						str = raf.readLine();
						dataSplit = str.split(",");
					}

				}
				break;
			}
	} 

	public static File WriteFile(Path fileP,int[] maxCh) throws IOException{
		File file = new File("C:/Users/IsraelPC/Desktop/שנה ב'/מונחה עצמים/WigleWifi_20171030132655.csv");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String str = null;
		String outputFile = "Test1.csv";
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
		String[] dataVal = null;
		String[] header = null;
		raf.readLine();		
		str=raf.readLine();
		header = str.split(",");
		csvOutput.write(header[3]);
		csvOutput.write(header[2]);
		csvOutput.write(header[6]);
		csvOutput.write(header[7]);
		csvOutput.write(header[8]);
		csvOutput.write(header[10]);
		csvOutput.endRecord();
		str = raf.readLine();
		int i = 0;

		while(str != null && i < maxCh.length){
			dataVal = str.split(",");
			if (Integer.parseInt(dataVal[5])==maxCh[i]){

				csvOutput.write(dataVal[3]);
				csvOutput.write(dataVal[2]);
				csvOutput.write(dataVal[6]);
				csvOutput.write(dataVal[7]);
				csvOutput.write(dataVal[8]);
				csvOutput.write(dataVal[10]);
				csvOutput.endRecord();
				i++;
				raf.seek(0);raf.readLine();raf.readLine();
				str = raf.readLine();	
			}
			else str = raf.readLine();
		}

		i=0;
		raf.seek(0);raf.readLine();raf.readLine();
		str = raf.readLine(); int count = 0;
		while(str != null && i < maxCh.length){
			dataVal = str.split(",");
			if (Integer.parseInt(dataVal[5])==maxCh[i]){
				if(count==0){
					csvOutput.write(header[1]);
					csvOutput.write(header[0]);
					csvOutput.write(header[4]);
					csvOutput.write(header[5]);
				}
				csvOutput.endRecord();
				csvOutput.write(dataVal[1]);
				csvOutput.write(dataVal[0]);
				csvOutput.write(dataVal[4]);
				csvOutput.write(dataVal[5]);

				i++;count=1;
				raf.seek(0);raf.readLine();raf.readLine();
				str = raf.readLine();
			}

			else str = raf.readLine();
		}
		csvOutput.close();
		raf.close();
		File file2 = new File("C:/Users/IsraelPC/workspace/Ex0/Test1.csv");
		return file2;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/IsraelPC/Desktop/שנה ב'/מונחה עצמים/WigleWifi_20171030132655.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			raf.readLine();raf.readLine();
			int[] maxCh = new int[10];
			int temp = -100 , i=0;
			br.readLine();br.readLine();
			String str = br.readLine();
			String str2 = str;
			String[] dataVal = null;

			while(str != null){	
				dataVal = str.split(",");
				for(;str2 != null&& i < maxCh.length;str2=raf.readLine()){
					if(Integer.parseInt(dataVal[5]) > temp){
						if(i>0)
							if(Integer.parseInt(dataVal[5]) < maxCh[i-1]){
								maxCh[i] = Integer.parseInt(dataVal[5]);
								temp=maxCh[i];
							}
						if(i==0) {
							maxCh[i] = Integer.parseInt(dataVal[5]);
							temp=maxCh[i];
						}	
					}
					dataVal = str2.split(",");
				}
				i++; temp = -100;
				raf.seek(0);
				raf.readLine();raf.readLine();
				str2 = raf.readLine();
				str = br.readLine();
				br.readLine();
			}
			raf.close();
			System.out.println("/////////////////////////////////////////////////////////////////////");
			System.out.println(Arrays.toString(maxCh));
			i=0;

			br.close();

			Path newfile = Paths.get("C:/Users/IsraelPC/Desktop/שנה ב'/מונחה עצמים/test.csv");
			File file2 = WriteFile(newfile, maxCh);			
			createKMLFile(file2);

		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
