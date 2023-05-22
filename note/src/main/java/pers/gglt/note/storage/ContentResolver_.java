package pers.gglt.note.storage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.Nullable;


/**
 * 作用  访问内容提供者中共享的数据
 */
public class ContentResolver_ {
    /***/
    // 作用 (操作内容提供者中共享的数据)   //查询,插入,修改,删除
    // 使用 (getContentResolver)(调用api)

    Context context;

    // 获取user表中所有记录
    void query() {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://cn.scu.myprovider/user");

        ContentValues values = new ContentValues();
        values.put("name", "gg");
        values.put("age", 24);
        resolver.insert(uri, values);

        Cursor cursor = resolver.query(uri, null, null, null, "userid desc");
        while (cursor.moveToNext()) {
            // 操作
        }
    }

    // 把id为1的记录的name字段值更改新为gg
    void update() {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://cn.scu.myprovider/user");

        ContentValues values = new ContentValues();
        values.put("name", "gg");

        Uri updateIdUri = ContentUris.withAppendedId(uri, 1);
        resolver.update(updateIdUri, values, null, null);
    }

    // 删除id为2的记录
    void delete() {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://cn.scu.myprovider/user");
        Uri deleteIdUri = ContentUris.withAppendedId(uri, 2);
        resolver.delete(deleteIdUri, null, null);
    }
}
