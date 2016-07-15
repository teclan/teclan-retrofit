package teclan.retrofit.example;

import java.io.InputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teclan.spark.service.handle.Handle;

public class ExampleHandle implements Handle {
    private final Logger LOGGER = LoggerFactory.getLogger(ExampleHandle.class);
    private int          status = 200;

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public boolean status(int status) {
        return this.status == status;
    }

    @Override
    public String handle(Map<String, String> paramataersAndValues) {
        return Body.whitelistPolicies;
    }

    @Override
    public <T> String handle(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> String handle(Object object, String method) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String handle(InputStream input, String originPath) {
        // TODO Auto-generated method stub
        return null;
    }

}
