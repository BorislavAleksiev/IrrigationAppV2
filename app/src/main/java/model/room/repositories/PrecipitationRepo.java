package model.room.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import api.MyRetrofit;
import model.room.dao.HumidityDao;
import model.room.dao.PrecipitationDao;
import model.room.entity.Humidity;
import model.room.entity.Precipitation;
import model.room.entity.apiDataModelClimate.Root;
import model.room.roomdatabase.MyRoomDatabase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrecipitationRepo {
    private MyRetrofit retrofit;
    private PrecipitationDao Dao;


    public PrecipitationRepo(Application application){
        retrofit = new MyRetrofit();
        MyRoomDatabase db = MyRoomDatabase.getDatabase(application);
        Dao = db.precipitationDao();
    }

    public void getPrecipitation(String location){
        String locationCode = "0";
        if(location == "Horsens"){
            locationCode = "06102";
        }

        Call<Root> call3 = retrofit.api.getClimate("metObs/collections/observation/items?stationId="+locationCode+"&parameterId=weather&period=latest&api-key=14cc5e73-90a5-463b-a221-68e503b2a396");
        call3.enqueue(new Callback<Root>(){
            String convertedValue = "";
            @Override
            public void onResponse (Call <Root> call, Response<Root> response){
                if (response.body().features.get(0).properties.value== 100.0){
                    convertedValue = "Clouds not observed";
                }
                System.out.println("Value is :"+ convertedValue);
                insert(new Precipitation(0,convertedValue));
            }
            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                t.printStackTrace();
                System.out.println("Failed at Login");
                System.out.println(t.getMessage());
            }
        });
    }

    public void insert(Precipitation obj) {
        MyRoomDatabase.databaseWriteExecutor.execute(() -> {
            Dao.insertPrecipitation(obj);
        });
    }

    //delete all climates
    public void emptyPrecipitationRepo(){
        MyRoomDatabase.databaseWriteExecutor.execute(() -> {
            Dao.deleteAll();
        });

    }

    // return a list of all climate to the viewmodel
    public LiveData<List<Precipitation>> getPrecipitationList(){
        return Dao.getPrecipitationList();
    }

}
