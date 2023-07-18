public class Main {

    public String solution(String target) {
        String temp = target.toUpperCase();
        String replaced = temp.replaceAll("[^A-Z]", "");
        String reversed = new StringBuilder(replaced).reverse().toString();

        if (replaced.equals(reversed)) {
            return "YES";
        }
        return "NO";
}
