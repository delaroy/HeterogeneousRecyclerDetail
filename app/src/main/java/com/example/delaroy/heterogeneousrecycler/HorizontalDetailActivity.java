package com.example.delaroy.heterogeneousrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.delaroy.heterogeneousrecycler.adapter.MainAdapter;

/**
 * Created by delaroy on 1/2/18.
 */

public class HorizontalDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_IMAGES = "imgaes";
    public static final String EXTRA_PUBDATE = "publisheddate";

    ImageView imageView;
    TextView title, description, publisheddate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ImageView) findViewById(R.id.horiImage);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        publisheddate = (TextView) findViewById(R.id.published_date);

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(EXTRA_TITLE)){

            String extTitle = getIntent().getExtras().getString(EXTRA_TITLE);
            String extDesc = getIntent().getExtras().getString(EXTRA_DESCRIPTION);
            String extPub = getIntent().getExtras().getString(EXTRA_PUBDATE);
            int extImage = getIntent().getExtras().getInt(EXTRA_IMAGES);

            //  nameOfMovie.setText(movieName);
            title.setText(extTitle);
            description.setText(extDesc);
            publisheddate.setText(extPub);

            //Toast.makeText(this, "Image " + extImage, Toast.LENGTH_SHORT).show();
            imageView.setImageResource(extImage);

            setTitle(extTitle);

        }else{
            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();
        }


    }
}
