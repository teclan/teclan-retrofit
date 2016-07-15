package teclan.retrofit.example;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import teclan.retrofit.model.Pixiu;
import teclan.retrofit.service.PixiuService;
import teclan.utils.GsonUtils;

public class UseRetrofitExample {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UseRetrofitExample.class);

    public static final String PIXIU_API_URL = "http://127.0.0.1:3770";

    public static void main(String[] args) {

        Webservice.run();

        GsonBuilder builder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss").setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(PIXIU_API_URL)
                // 增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(
                        GsonConverterFactory.create(builder.create()))
                .build();

        PixiuService pixiuService = retrofit.create(PixiuService.class);

        Call<Pixiu> call = pixiuService.getWhitelistPolicies();

        Pixiu pixiu;
        try {
            pixiu = call.execute().body();
            LOGGER.info(GsonUtils.toJson(pixiu));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

}
