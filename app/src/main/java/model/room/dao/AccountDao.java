package model.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import model.room.entity.Account;
import model.room.entity.Electricity;


@Dao
public interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAccount(Account account);

    @Query("DELETE FROM Account")
    void deleteAll();

    @Query("SELECT * FROM Account ORDER BY UserID DESC Limit 1")
    LiveData<Account> getCurrentAccount();
}
