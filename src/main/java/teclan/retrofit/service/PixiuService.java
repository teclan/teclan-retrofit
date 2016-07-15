package teclan.retrofit.service;

import retrofit2.Call;
import retrofit2.http.GET;
import teclan.retrofit.model.Pixiu;

public interface PixiuService {

    @GET("/whitelist_policies")
    Call<Pixiu> getWhitelistPolicies();

}
