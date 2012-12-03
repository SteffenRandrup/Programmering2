import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CatFiles {

	public static void main(String[] args) {

		try {
			if (args.length < 3) {
				
				throw new ParameterError();
				
			} else {
				
				FileWriter writer = new FileWriter(args[args.length - 1]);
				
				for (int i = 0; i < args.length - 1; i++) {

					try {
						BufferedReader reader = new BufferedReader(
								new FileReader(args[i]));

						String line = reader.readLine();
						String previousLine = line;
						
						while (line != null) {
							previousLine = line;
							writer.write(line + "\n");
							line = reader.readLine();
							
							if(line == null && !previousLine.equals("\n")){
								writer.write("\n");
							}
						}
						
						reader.close();

					} catch (FileNotFoundException e) {
						System.out.println("File not found: " + e);
					} catch (Exception e) {
						System.out.println("Didn't see that error comming: " + e);
					}
				}
				
				writer.close();
			}
		} catch (ParameterError e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("Input/Output error: " + e);
		} catch (Exception e) {
			System.out.println("Didn't see that error comming: " + e);
		}

	}

}
