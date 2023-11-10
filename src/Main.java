public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = System.getProperty("user.home") + "/Test.java";
        Finder finder = new Finder(fileName);
        System.out.println(finder.getStringCount("sth to find"));
    }
}