package teclan.retrofit.example;

import static spark.Spark.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teclan.spark.service.DefaultRestApiService;
import teclan.spark.service.RestApiService;
import teclan.spark.service.handle.Handle;

public class Webservice extends DefaultRestApiService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(Webservice.class);

    private static Handle handle = new ExampleHandle();

    private static RestApiService restApiService = new Webservice();

    private static int PORT = 3770;

    public static void run() {
        port(PORT);
        LOGGER.info("BaseUrl: localhost:{}", PORT);

        restApiService.createGetRequestService("/whitelist_policies", handle);
    }

}
