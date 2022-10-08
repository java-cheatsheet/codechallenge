package hackerrank.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpRequests {

    public static InputStream get(String url)
            throws IOException {
        InputStream inputStream = null;
        URL urlObject = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setRequestMethod("GET");
        inputStream = conn.getInputStream();

        return inputStream;
    }
}
