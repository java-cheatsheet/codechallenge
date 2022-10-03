package hackerrank.java;

public class StringToken {
    private String sentence;

    public StringToken(final String sentence) {
            this.sentence = sentence;
    }

    public String[] tokenFilter() {

        if( sentence == null || sentence.isEmpty()
                || sentence.trim().isEmpty()) {
            return new String[]{};
        }
        String[] splitStr = sentence.trim().split("[,\\s\\'\\?\\_\\@\\!\\.]+");

        return splitStr;
    }
}
