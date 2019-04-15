package hackerrank.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The solution is correct. The question was a bit misleading.
 * It mentioned "private class", so I was trying to give the
 * "private" attribute or an inner class implementation.
 *
 * The question simply meant was to make a separate class.
 */
public class MyRegexMain {

    public static HashMap<String, Boolean> mapIPValidity = new HashMap<>();

    public static void main(String[] args) {
        MyRegex objMyRegex = new MyRegex(new MyRegexMain());

//        List<String> inputLines = objMyRegex.readLines();

        List<String> inputLines = objMyRegex.getTestLines();

        inputLines.forEach((ipaddress) -> objMyRegex.checkIPAddressWithRegex(ipaddress));

        mapIPValidity.forEach((key,value) -> System.out.println( key+":"+value ));
    }

}

class MyRegex {
    //read number of lines for input
    //define Regex for IP address
    //check for individual line
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    MyRegexMain myRegexMain;

    public MyRegex(MyRegexMain myRegexMainRef){
        myRegexMain = myRegexMainRef;
    }


    public void checkIPAddressWithRegex(String sentence){
//            String validIPRegex = "\\d{1,3}\\.{1}\\d{1,3}\\.{1}\\d{1,3}\\.{1}\\d{1,3}";
        String validIPRegex= "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";

        try {

            myRegexMain.mapIPValidity.put(sentence, sentence.matches(validIPRegex));

        } catch (Exception e) {
            //Log Exception
            System.out.println("Exception " + e.getMessage());
        }
    }

    public List<String> readLines(){
        String inputLine;
        List<String> inputLines = new ArrayList<>();

        try {
            while ((inputLine = bufferedReader.readLine()) != null
                    && inputLine.length() != 0) {
                inputLines.add(inputLine);
            }
        } catch (Exception e) {
            // Log exception
        }

        return inputLines;
    }

    public List<String> getTestLines(){
        return List.of("11331.111.144411.111", "asdafasd.asdasd.dasd..", "001.0.01.1", "255.255.255.255");
    }
}