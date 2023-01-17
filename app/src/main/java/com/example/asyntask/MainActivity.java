package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Listener, View.OnClickListener{

    TextView tv;
    ImageView img;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);
        img = findViewById(R.id.imageView3);
        bt = findViewById(R.id.button);

        bt.setOnClickListener(this);
    }

    @Override
    public void onImageDownload(Bitmap bitmap) {
        img.setImageBitmap(bitmap);
        tv.setText("Download thanh cong");
    }

    @Override
    public void onError() {
        tv.setText("Download that bai");
    }

    @Override
    public void onClick(View v) {
        new AsyncTask(this, this)
                .execute("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4HtmaPWDFwVXLtxyl5FNQ9jN9z-ahaSAO3moQnfzlgsIpNp0UM3229XnQQnjfpFQ1hlg&usqp=CAU");
    }
}