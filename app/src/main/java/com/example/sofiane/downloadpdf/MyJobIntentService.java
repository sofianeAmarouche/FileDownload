package com.example.sofiane.downloadpdf;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Sofiane on 10/9/2018.
 */

public class MyJobIntentService extends JobIntentService {
    private static final String TAG= "Jobintent";
    DownloadManager dm;
    public static void enqueueWork(Context context,Intent intent){
        enqueueWork(context,MyJobIntentService.class,22,intent);
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG,"Created");
    }


    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG,"on handle intent");
        dm=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        //Uri ur= Uri.parse("http://www.africau.edu/images/default/sample.pdf");
        Uri ur= Uri.parse("https://www.downgraf.com/wp-content/uploads/2015/06/Superb-Movie-Posters-5.jpg");
        DownloadManager.Request request= new DownloadManager.Request(ur);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference= dm.enqueue(request);
        //write code

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"destroy");
        Toast.makeText(this,"Download complete", Toast.LENGTH_SHORT).show();

    }
}


