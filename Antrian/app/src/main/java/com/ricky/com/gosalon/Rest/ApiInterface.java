package com.ricky.com.gosalon.Rest;

import com.ricky.com.gosalon.Model.ResultCustomer;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by alhamdulillah on 10/23/16.
 */
public interface ApiInterface {

    /************************************/
    @GET("customer")
    Call<ResultCustomer> getCustomer();

    @Multipart
    @POST("customer")
    Call<ResultCustomer> postCustomer(@Part MultipartBody.Part file,
                                      @Part("nama_cust") RequestBody nama,
                                      @Part("alamat") RequestBody alamat,
                                      @Part("jenis_kelamin") RequestBody jenis_kelamin,
                                      @Part("password") RequestBody password,
                                      @Part("action") RequestBody action);
    @Multipart
    @POST("customer")
    Call<ResultCustomer> putCustomer(@Part MultipartBody.Part file,
                                     @Part("nama_cust") RequestBody nama,
                                     @Part("alamat") RequestBody alamat,
                                     @Part("jenis_kelamin") RequestBody jenis_kelamin,
                                     @Part("password") RequestBody password,
                                     @Part("action") RequestBody action);
    @Multipart
    @POST("customer")
    Call<ResultCustomer> deleteCustomer(@Part("id_cust") RequestBody idCust,
                                        @Part("action") RequestBody action);

}