package viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import model.room.entity.Account;
import model.room.entity.Temperature;
import model.room.repositories.AccountRepo;
import model.room.repositories.TemperatureRepo;

public class AccountRepoViewModel extends AndroidViewModel {
    private AccountRepo accountRepo;

    public AccountRepoViewModel(@NonNull Application application){
        super(application);
        accountRepo = new AccountRepo(application);
    }
    public void addAccount(Account acc){
        accountRepo.accountInsert(acc);
    }
    public LiveData<List<Account>> getCurrentAccount(){
        return accountRepo.getCurrentAccountList();
    }
}