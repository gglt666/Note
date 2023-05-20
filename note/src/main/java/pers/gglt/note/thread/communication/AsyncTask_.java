package pers.gglt.note.thread.communication;

import android.os.AsyncTask;

public class AsyncTask_ extends AsyncTask {

    /**调用顺序*/
    // onPreExecute
    // doInBackground
    // onPostExecute
    //

    /**原理*/
    // 有两个线程池，一个用于任务排队，一个用于执行任务
    // 有一个 Handler，用于将执行环境从线程池切换到主线程


    protected void onPreExecute() {
        super.onPreExecute();
    }
    protected Object doInBackground(Object[] objects) {
        return null;
    }
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }
}
