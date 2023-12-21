import java.io.*;
import java.util.Scanner;

public class FilesApp {

    public static void writeToFile(String text, String path, boolean mode) {
        try(FileWriter writer = new
                FileWriter(path, mode)) {
            writer.write(text);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void readToFile(String path) {
        try(FileReader reader = new
                FileReader(path))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void checkInFile(String path,String dataToSeek, String data) {
        File f = new File(path);
        try
        {
            String ENDL = System.getProperty("line.separator");

            StringBuilder sb = new StringBuilder();

            BufferedReader br = new BufferedReader(new FileReader(f));
            String ln;
            while((ln = br.readLine()) != null)
            {
                sb.append(ln
                        .replace(dataToSeek, data)
                ).append(ENDL);
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(sb.toString());
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String path, data, dataToSeek;

        System.out.println("Write to file: ");

        System.out.println("Enter path: ");

        path = scn.next();

        System.out.println("Enter data: ");

        data = scn.next();


        writeToFile(data,path,false);

        System.out.println("Read from file: ");

        System.out.println("Enter path: ");

        path = scn.next();

        System.out.println("Info from file: ");

        readToFile(path);


        System.out.println("Replace data from file: ");

        path = scn.next();

        System.out.println("Enter what to seek: ");

        dataToSeek = scn.next();

        System.out.println("Enter with what to replace: ");

        data = scn.next();

        checkInFile(path,dataToSeek,data);

        System.out.println("Append to file: ");

        System.out.println("Enter path: ");

        path = scn.next();

        System.out.println("Append to file: ");

        data = scn.next();

        writeToFile(data,path,true);

        readToFile(path);
    }
}