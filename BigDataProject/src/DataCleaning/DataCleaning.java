package DataCleaning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataCleaning {

	public static String [] fileNames = new String [120];
	
	public DataCleaning(){
		String f = "Day";
		
		for(int i=0;i<120;i++){
			this.fileNames[i] = f+ Integer.toString(i)+".svm";
		}
	}

	public static void main(String[] args) throws IOException {
		
		
		DataCleaning d_clean = new DataCleaning();
		int [] indices = {4,5,6,8,11,16,17,18,19,21,22,23,30,33,35,39,41,43,55,57,59,61,
				63,65,67,69,71,73,75,77,79,81,83,85,87,89,91,93,95,97,99,101,103,105,107,109
				,111,113,120,126,132,134,136,138,140,142,144,146,148,150,161,194,270,7801};
		
		BufferedReader br = null;
		FileReader file_reader = null;
		
		int count = 0;
		int max = 0;
		while(count < fileNames.length){
			System.out.println("NEW FILE : " + count );
			String file_name = "Imp"+Integer.toString(count)+".csv";
			
			//System.out.println(file_name);
			
			File f = new File(file_name);
			FileWriter fr = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fr);
			
			int url = 1;
			String url_info = null;
			String value=null;
			String instance = null;
			int key=0;
			String [] features = null;
			int i=1; // debug purpose
			
			
			try {
				file_reader = new FileReader(fileNames[count]);
				br = new BufferedReader(file_reader);				
				
				while((url_info = br.readLine())!=null){
					
					features = url_info.split(" ");
					HashMap<Integer, String> dict = new HashMap<Integer, String>();
					
				try{
					
				
					for(i=1; i< features.length; i++){
						
						instance = features[i];
						String temp [] = instance.split(":");
						key = Integer.valueOf(temp[0]);
						
						if(key == 4 || key == 5 || key == 6 || key == 8
								|| key == 11 || key == 16 || key == 17 
								|| key == 18 || key == 19 || key ==21
								|| key == 22 || key == 23 || key == 30
								|| key == 33 || key == 35 || key == 39
								|| key == 41 || key == 43 || key == 55
								|| key == 57 || key == 59 || key == 61 || key == 63								
								|| key == 65 || key == 67 || key == 69
								|| key == 71 || key == 73 || key == 75
								|| key == 77 || key == 79 || key == 81
								|| key == 83 || key == 85 || key == 87
								|| key == 89 || key == 91 || key == 93
								|| key == 95 || key == 97 || key == 99
								|| key == 101 || key == 103 || key == 105
								|| key == 107 || key == 109 || key == 111
								|| key == 113 || key == 120 || key == 126
								|| key == 132 || key == 134 || key == 136
								|| key == 138 || key == 140 || key == 142
								|| key == 144 || key == 146 || key == 148
								|| key == 150 || key == 161 || key == 194
								|| key == 270 || key == 7801)
						{
							dict.put(key, temp[1]);
						}
					}
				}
				catch(Exception e){
					System.err.println("First try : " + instance + url_info);
				}
					
					try{
						
						if(dict.size() > 0){
							bw.write(features[0] + ", ");
							
							for(int j=0;j<indices.length;j++){
								value = dict.get(indices[j]);
								if(value!=null){
									bw.write( value + ", ");
								}
								else{								
									
									bw.write("0, ");
								}
							}
							bw.write("\n");
							//System.out.println(url+ " "+dict.size());							
						}
						
					}
					catch(Exception e){
						System.err.println("Second try: " + value);
					}
					if(dict.size()>max){
						max = dict.size();
					}
					//break;
					url++;
				}
				
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(url_info + " " + url);
				e.printStackTrace();
			}
			finally{
				bw.close();
				br.close();
				fr.close();
				
			}
			//System.out.println(max);
			//break;
			count++;
		}
		
	}
}
