package spring_8;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private String fileName = "src/spring_8/fortune-data.txt";
    private List<String> fortunes;

    private Random myRandom = new Random();

    @PostConstruct
    private void loadTheFortunesFile() {

        System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

        File theFile = new File(fileName);

        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        // initialize array list
        fortunes = new ArrayList<String>();
        try{
        FileReader fr = new FileReader(theFile);
        BufferedReader br = new BufferedReader(fr);
        String tempLine;
        while((tempLine = br.readLine()) != null){
            fortunes.add(tempLine);
        }
        fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }


        // read fortunes from file
//        try(BufferedReader br = new BufferedReader(new FileReader(theFile))) {
//            String tempLine;
//            while (br.readLine() != null) {
//                fortunes.add(br.readLine());
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
    }


    @Override
    public String getFortune() {
        return fortunes.get(myRandom.nextInt(fortunes.size()));
    }
}
