import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    private final String path;

    public Finder(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        this.path = path;
    }

    public int getStringCount(String string) throws IOException {
        int counter = 0;
        String text = removeCommentsContent();
        Pattern pattern = Pattern.compile("\\s|^" + string + "\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    private String removeCommentsContent() throws IOException {
        String x;
        StringBuilder mod = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((x = bufferedReader.readLine()) != null) {
                x = x.replaceAll("(//).*", "");
                mod.append(x);
            }
        }
        mod = new StringBuilder(mod.toString().replaceAll("(/\\*).*(\\*/)", " ").replaceAll("/\\*\\*.*(\\*/)?", " "));
        return mod.toString();
    }
}

