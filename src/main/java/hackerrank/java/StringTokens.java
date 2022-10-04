package hackerrank.java;

/**
 * Clean token in string
 */
public class StringTokens {

    /**
     * String content to be cleaned
     */
    private final String sentence;

    /**
     *
     * @return String
     */
    public String getSentence() {
        return sentence;
    }
    /**
     * Set string to be cleaned
     * @param sentence
     */
    public StringTokens(final String sentence) {
            this.sentence = sentence;
    }

    /**
     * Filter tokens
     *
     * @return String
     */
    public String[] tokenFilter() {

        return sentence == null || sentence.isEmpty() ?
                new String[]{}
        : sentence.trim().split("[,\\s\\'\\?\\_\\@\\!\\.]+");
    }
}
