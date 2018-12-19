package com.ricky.com.gosalon.Rest;

import com.ricky.com.gosalon.Customer.PostPutDelCustomer;
import com.ricky.com.gosalon.Model.ResultCustomer;
import com.ricky.com.gosalon.Model.ResultLayanan;
import com.ricky.com.gosalon.Model.ResultSalon;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    // Login

    @FormUrlEncoded
    @POST("Login")
    Call<PostPutDelCustomer> getLogin(@Field("nama_cust") String nama_cust,
                                      @Field("password") String password);

    //Salon
    @GET("Salon")
    Call<ResultSalon> GetSalon();

    //layanan
    @GET("layanan")
    Call<ResultLayanan> GetLayanan();

    @FormUrlEncoded
    @POST("Layanan/detaillayanan")
    Call<ResultLayanan> detaillayanan(@Field("id") String id);

    @Multipart
    @POST("layanan")
    Call<ResultLayanan> postLayanan(@Part MultipartBody.Part file,
                                    @Part("id_salon") RequestBody id_salon,
                                    @Part("nama_layanan") RequestBody nama,
                                    @Part("deskripsi") RequestBody deskripsi,
                                    @Part("harga") RequestBody harga,
                                    @Part("status") RequestBody status,
                                    @Part("action") RequestBody action);

    @Multipart
    @POST("layanan")
    Call<ResultLayanan> putLayanan(@Part MultipartBody.Part file,
                                   @Part("id_salon") RequestBody id_salon,
                                   @Part("nama_layanan") RequestBody nama,
                                   @Part("deskripsi") RequestBody deskripsi,
                                   @Part("harga") RequestBody harga,
                                   @Part("status") RequestBody status);
    @Multipart
    @POST("layanan")
    Call<ResultLayanan> deleteLayanan(@Part("id_layanan") RequestBody idLay,
                                      @Part("action") RequestBody action);

}