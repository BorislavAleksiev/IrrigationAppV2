package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MyRetrofit{

    public InterfaceAPI api;
    public Gson gson;


    public MyRetrofit(){
        gson = new GsonBuilder()
                .setLenient()
                //.registerTypeAdapterFactory(typeFactory)
                .create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dmigw.govcloud.dk/v2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.api = retrofit.create(InterfaceAPI.class);

    }
}
