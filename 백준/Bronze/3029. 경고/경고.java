import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));

        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);

        String S = br.readLine();
        String T = br.readLine();

        Date d1= f.parse(S);
        Date d2 = f.parse(T);

        long diff = d2.getTime() - d1.getTime();
        if(d1.after(d2)){
            diff += 1000*60*60*24;
        } else if(diff == 0) {
            System.out.println("24:00:00");
            return;
        }

        long diffSec = (diff/1000)%60;
        long diffMin = (diff/(60*1000))%60;
        long diffHours = diff/(60*60*1000);
        System.out.printf("%02d:%02d:%02d", diffHours, diffMin, diffSec);
    }
}
