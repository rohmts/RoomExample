package com.example.rohmts.roomexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by rohmts on 06/05/18.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DataAccessObject dataAccessObject();
}
