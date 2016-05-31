import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filepath=args[0];
        File file = new File(filepath);
        readFile(file);
    }


    public static void readFile(File file) {
        String line = null;
        double sum =0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String pattern1 = "amount:";
                String pattern2 = "PLN";
                Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
                Matcher m = p.matcher(line);
                while (m.find()) {
                   // System.out.println(m.group(1));
                    String amountWithComma = m.group(1).replaceAll(",", ".");
                    System.out.println(amountWithComma);
                    sum=Double.parseDouble(amountWithComma);

                }

            }
            bufferedReader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }

}
