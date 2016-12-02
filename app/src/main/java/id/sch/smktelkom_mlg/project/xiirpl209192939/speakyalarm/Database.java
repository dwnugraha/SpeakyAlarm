package id.sch.smktelkom_mlg.project.xiirpl209192939.speakyalarm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ira on 12/2/2016.
 */

public class Database  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbalarm.db";
    private static final int DATABASE_VERSION = 1;
    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql ="create table alarm (no integer primary key, jam date, tgl text,);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
        
    }
}
