package com.fei.myone.db;

import android.database.sqlite.SQLiteDatabase;

import org.litepal.tablemanager.Connector;

/**
 * Created by fei on 2018/3/29.
 */

public class DB_Server {
    private SQLiteDatabase database;
    /***
     * 单例模式
     */
    private static DB_Server instance = null;
    public static synchronized DB_Server getInstance() {
        // 这个方法比上面有所改进，不用每次都进行生成对象，只是第一次
        // 使用时生成实例，提高了效率！
        if (instance == null)
            instance = new DB_Server();
        return instance;
    }

    public DB_Server(){
        if(database == null) {
            database = Connector.getDatabase();
        }
    }




}
