package com.example.android.shahniz_1202150279_modul3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends Activity {
    private int mLiter = 0;
    private TextView mLiterText;
    private ImageView mBottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mineralTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView mineralImage = (ImageView)findViewById(R.id.mineralImageDetail);

        mLiterText = findViewById(R.id.liter);
        mBottle = findViewById(R.id.bottleImage);

        //Set the text from the Intent extra
        mineralTitle.setText(getIntent().getStringExtra("title"));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(mineralImage);

    }

    public void decreaseBottle(View view) {
        if(mLiter==0){Toast.makeText(this,"Air Sedikit",Toast.LENGTH_SHORT).show();
        return;
        }
        mBottle.setImageLevel(--mLiter);
        mLiterText.setText(String.valueOf(mLiter+"L"));
    }

    public void increaseBottle(View view) {
        if(mLiter==6){
            Toast.makeText(this,"Air Sudah Penuh",Toast.LENGTH_SHORT).show();
            return;
        }
        mBottle.setImageLevel(++mLiter);
        mLiterText.setText(String.valueOf(mLiter+"L"));
    }
}
