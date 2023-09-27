package air.texnodev.aphorismsapp.network;

import air.texnodev.aphorismsapp.model.Quote;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CallApi {


    @GET("random")
    Call<Quote> getAphorisms();

}
