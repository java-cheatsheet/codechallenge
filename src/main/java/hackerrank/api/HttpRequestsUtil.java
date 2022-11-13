package hackerrank.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Process HTTP Requests
 *
 */
@SuppressWarnings("PMD.LawOfDemeter")
public final class HttpRequestsUtil {

    /**
     * To prevent initialization
     */
    private HttpRequestsUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * Process HTTP GET request
     *
     * @param url String
     * @return InputStream
     * @throws IOException``
     */
    public static InputStream get(final String url)
            throws IOException {
        final URL urlObject = new URL(url);
        final HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setRequestMethod("GET");

        return conn.getInputStream();
    }
}
