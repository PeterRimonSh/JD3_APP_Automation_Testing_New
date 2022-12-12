package api;



import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpUtil {

    static int statusCode;

    /**
     * Send a get request
     * @return response
     */
    static public String get(String url) throws IOException {
        return get(url, null);
    }

    /**
     * Send a get request
     * @param url         Url as string
     * @param headers     Optional map with headers
     * @return response   Response as string
     */
    static public String get(String url,
                             Map<String, String> headers) throws IOException {
        return fetch("GET", url, null, headers);
    }

    /**
     * Send a post request
     * @param url         Url as string
     * @param body        Request body as string
     * @param headers     Optional map with headers
     * @return response as string
     */
    static public String post(String url, String body,
                              Map<String, String> headers) throws IOException {
        return fetch("POST", url, body, headers);
    }

    static public String postAuth(String url, String body,
                              Map<String, String> headers,String userName,String pass) throws IOException {
        return fetch("POST", url, body, headers,userName,pass);
    }

    /**
     * Send a post request
     * @param url         Url as string
     * @param body        Request body as string
     * @return response as string
     */
    static public String post(String url, String body) throws IOException {
        return post(url, body, null);
    }

    /**
     * Post a json string
     * @param url         Url as string
     * @param jsonStr     a json string
     * @return response as string
     */


    /**
     * Post a form with parameters
     * @param url         Url as string
     * @param params      map with parameters/values
     * @return response as string
     */
    static public String postForm(String url, Map<String, String> params)
            throws IOException {
        return postForm(url, params, null);
    }

    /**
     * Post a form with parameters
     * @param url         Url as string
     * @param params      Map with parameters/values
     * @param headers     Optional map with headers
     * @return response as string
     */
    static public String postForm(String url, Map<String, String> params,
                                  Map<String, String> headers) throws IOException {
        // set content type
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put("Content-Type", "application/x-www-form-urlencoded");

        // parse parameters
        String body = "";
        if (params != null) {
            boolean first = true;
            for (String param : params.keySet()) {
                if (first) {
                    first = false;
                }
                else {
                    body += "&";
                }
                String value = params.get(param);
                body += URLEncoder.encode(param, StandardCharsets.UTF_8) + "=";
                body += URLEncoder.encode(value, StandardCharsets.UTF_8);
            }
        }

        return post(url, body, headers);
    }

    /**
     * Send a put request
     * @param url         Url as string
     * @param body        Request body as string
     * @param headers     Optional map with headers
     * @return response as string
     */
    static public String put(String url, String body,
                             Map<String, String> headers) throws IOException {
        return fetch("PUT", url, body, headers);
    }

    /**
     * Send a put request
     * @param url         Url as string
     * @return response as string
     */
    static public String put(String url, String body) throws IOException {
        return put(url, body, null);
    }

    /**
     * Send a delete request
     * @param url         Url as string
     * @param headers     Optional map with headers
     * @return response as string
     */
    static public String delete(String url,
                                Map<String, String> headers) throws IOException {
        return fetch("DELETE", url, null, headers);
    }

    /**
     * Send a delete request
     * @param url         Url as string
     * @return response as string
     */
    static public String delete(String url) throws IOException {
        return delete(url, null);
    }

    /**
     * Append query parameters to given url
     * @param url         Url as string
     * @param params      Map with query parameters
     * @return url with query parameters appended
     */
    static public String appendQueryParams(String url,
                                           Map<String, String> params) throws IOException {
        String fullUrl = url;
        if (params != null) {
            boolean first = (fullUrl.indexOf('?') == -1);
            for (String param : params.keySet()) {
                if (first) {
                    fullUrl += '?';
                    first = false;
                }
                else {
                    fullUrl += '&';
                }
                String value = params.get(param);
                fullUrl += URLEncoder.encode(param, StandardCharsets.UTF_8) + '=';
                fullUrl += URLEncoder.encode(value, StandardCharsets.UTF_8);
            }
        }

        return fullUrl;
    }

    /**
     * Retrieve the query parameters from given url
     * @param url         Url containing query parameters
     * @return params     Map with query parameters
     */
    static public Map<String, String> getQueryParams(String url)
            throws IOException {
        Map<String, String> params = new HashMap<String, String>();

        int start = url.indexOf('?');
        while (start != -1) {
            // read parameter name
            int equals = url.indexOf('=', start);
            String param = "";
            if (equals != -1) {
                param = url.substring(start + 1, equals);
            }
            else {
                param = url.substring(start + 1);
            }

            // read parameter value
            String value = "";
            if (equals != -1) {
                start = url.indexOf('&', equals);
                if (start != -1) {
                    value = url.substring(equals + 1, start);
                }
                else {
                    value = url.substring(equals + 1);
                }
            }

            params.put(URLDecoder.decode(param, StandardCharsets.UTF_8),
                    URLDecoder.decode(value, StandardCharsets.UTF_8));
        }

        return params;
    }

    /**
     * Returns the url without query parameters
     * @param url         Url containing query parameters
     * @return url without query parameters
     */
    static public String removeQueryParams(String url)
            throws IOException {
        int q = url.indexOf('?');
        if (q != -1) {
            return url.substring(0, q);
        }
        else {
            return url;
        }
    }

    /**
     * Send a request
     * @param method      HTTP method, for example "GET" or "POST"
     * @param url         Url as string
     * @param body        Request body as string
     * @param headers     Optional map with headers
     * @return response as string
     */
    static public String fetch(String method, String url, String body,
                               Map<String, String> headers) throws IOException {
        // connection
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)u.openConnection();
        conn.setConnectTimeout(120000);
        conn.setReadTimeout(120000);

        // method
        if (method != null) {
            conn.setRequestMethod(method);
        }

        // headers
        if (headers != null) {
            for(String key : headers.keySet()) {
                conn.addRequestProperty(key, headers.get(key));
            }
        }

        // body
        if (body != null) {
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(body.getBytes());
            os.flush();
            os.close();
        }

        // response
        InputStream is = conn.getInputStream();
        String response = streamToString(is);
        setStatusCode(conn.getResponseCode());
        // handle redirects
        if (conn.getResponseCode() == 301) {
            String location = conn.getHeaderField("Location");
            return fetch(method, location, body, headers);
        }

        return response;
    }

   static public String fetch(String method, String url, String body,
                               Map<String, String> headers,String userName ,String pass) throws IOException {
       // connection
       URL u = new URL(url);
       HttpURLConnection conn = (HttpURLConnection) u.openConnection();
       conn.setDoOutput(true);
       conn.setRequestMethod(method);
       conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
       String userpass = userName + ":" + pass;
       String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
       conn.setRequestProperty ("Authorization", basicAuth);
       if (headers != null) {
           for(String key : headers.keySet()) {
               conn.addRequestProperty(key, headers.get(key));
           }
       }
       if (body != null) {
           conn.setDoOutput(true);
           OutputStream os = conn.getOutputStream();
           os.write(body.getBytes());
           os.flush();
           os.close();
       }
       BufferedReader br = new BufferedReader(new InputStreamReader(
               (conn.getInputStream())));

       System.out.println("Output from Server .... \n");
       String output = br.lines().collect(Collectors.joining());
       conn.disconnect();
       return output;
   }

    /**
     * Read an input stream from conn into a string
     */
    static public String streamToString(InputStream in) throws IOException {
        InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        String data;
        StringBuilder out = new StringBuilder();
        while ((data = br.readLine()) != null) {
            out.append(data);
        }
        br.close();
        return out.toString();
    }

    public static String AlgoliaRequest(String url, String encode) throws IOException {
        URL algoliaUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) algoliaUrl.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("X-Algolia-API-Key", "2bbce1340a1cab2ccebe0307b1310881");
        conn.setRequestProperty("X-Algolia-Application-Id", "H9X4IH7M99");

        OutputStream os = conn.getOutputStream();
        os.write(encode.getBytes());
        os.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        System.out.println("Output from Server .... \n");
        String output = br.lines().collect(Collectors.joining());
        conn.disconnect();
        return output;
    }
    public static int getStatusCode() {
        return statusCode;
    }

    public static void setStatusCode(int statusCode) {
        HttpUtil.statusCode = statusCode;
    }
}