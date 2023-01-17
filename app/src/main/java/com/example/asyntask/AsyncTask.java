package com.example.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTask extends android.os.AsyncTask<String, Void, Bitmap> {

    //Chuan bi thuc hien
    Listener mlistener;
    ProgressDialog progressDialog;
    public AsyncTask (Listener listener, Context context){
        this.mlistener = listener;
        this.progressDialog = new ProgressDialog(context);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Bat dau download");
        progressDialog.show();
    }
    //Thuc hien
    Bitmap bitmap = null;
    @Override
    protected Bitmap doInBackground(String... strings) {
        URL url;
        try {
            url = new URL(strings[0]);//lay ve duong dan anh
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    //Sau thuc hien
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if(bitmap!=null){
            mlistener.onImageDownload(bitmap);
        }
        else{
            mlistener.onError();
        }
    }
}
