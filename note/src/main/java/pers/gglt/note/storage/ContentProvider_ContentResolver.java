package pers.gglt.note.storage;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

//https://cloud.tencent.com/developer/article/1421832?areaSource=103001.2&traceId=G9T7BxIejedc0QTNaPWwS
//https://cloud.tencent.com/developer/article/2052730?areaSource=103001.10&traceId=G9T7BxIejedc0QTNaPWwS

/**
 * 场景  操作其他 APP 的数据（音频、视频、图片、通讯录 ...）
 *
 * 内容提供者继承于ContentProvider基类，为其它应用程序取用和存储它管理的数据实现了一套标准方法，应用程序不直接调用这些方法，而是使用ContentResolver对象调用它的方法作为替代
 *
 * Uri  概念  待操作数据表的绝对路径
 *      示例  content://com.trampcr.contacts/people/（访问 people 表中所有记录）
 *           content://com.trampcr.contacts/people/5（访问 people 表中 id 为 5 的记录）
 *      要素  schema（固定为 content://）
 *           authority（标识一个 ContentProvider）
 *           path（数据库表）
 *           id（可选字段，数据项）
 *
 * MIME  概念  String 类型，类似扩展名（text/html、text/css、text/xml ）
 *
 */

// https://zhuanlan.zhihu.com/p/487226358?utm_id=0
public class ContentProvider_ContentResolver extends ContentProvider {
    /**ContentProvider*/
    // 概念 (提供接口,统一存取/读取数据)(公共存储区域,所有程序可见)
    // 作用 (获取/保存数据)     //许多系统数据（如视频,音频,图片,通讯录等）使用 ContentProvider 形式供开发者调用

    // 通过 ContentResolver 来访问 ContentProvider 提供的数据, resolver通过uri定位数据

    /**ContentResolver*/
    // 作用 (操作内容提供者中共享的数据)   //查询,插入,修改,删除
    // 使用 (getContentResolver)(调用api)

    /**Uri*/
    // 概念 (绝对路径,系统中资源/数据)
    // 要素 (前缀,content://)(标识)(路径)(id)


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null; //返回当前 Url 所代表数据的 MIME 类型
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        // 数据变化时通知注册在此URI上的访问者
        getContext().getContentResolver().notifyChange(uri, null);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }




    // 获取user表中所有记录
    void query() {
        Context context = null;
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
        Context context = null;
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://cn.scu.myprovider/user");

        ContentValues values = new ContentValues();
        values.put("name", "gg");

        Uri updateIdUri = ContentUris.withAppendedId(uri, 1);
        resolver.update(updateIdUri, values, null, null);
    }

    // 删除id为2的记录
    void delete() {
        Context context = null;
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://cn.scu.myprovider/user");
        Uri deleteIdUri = ContentUris.withAppendedId(uri, 2);
        resolver.delete(deleteIdUri, null, null);
    }
}
