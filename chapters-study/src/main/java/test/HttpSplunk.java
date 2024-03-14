package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpSplunk {

    private static String BASE_URL = "https://logs.devcerner.com/serviceNS/search/jobs/sid123";
    private static String USER_NAME = "JG099825";
    private static String PASSWORD = "C3rn3rJ@gv202204";





    public static void execute1(){
        try {
            HttpClient client = HttpClients.createDefault();
            URIBuilder builder = new URIBuilder(BASE_URL);
            String listSplunkUri = builder.build().toString();
            HttpGet getJobMethod = new HttpGet(listSplunkUri);
            HttpResponse splunkResponse = client.execute(getJobMethod);



        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
