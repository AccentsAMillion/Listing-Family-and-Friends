package com.woodward.chris.friendsandfamily;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer images[] = {R.drawable.ninjagaiden,R.drawable.ninjagaiden1,R.drawable.ninjagaiden2,
                        R.drawable.ninjagaiden3,R.drawable.ninjagaiden4,R.drawable.ninjagaiden5};

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView =(GridView)findViewById(R.id.gridView);
        final ImageView pic =(ImageView)findViewById(R.id.imageView);
        gridView.setAdapter(new TheSexyAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),"Selected Item: " + (i + 1), Toast.LENGTH_LONG);
                pic.setImageResource(i);
            }
        });
    }

        public class TheSexyAdapter extends BaseAdapter{

            private Context c;
            public TheSexyAdapter(Context c){
                this.c = c;
            }

            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                pic = new ImageView(c);
                pic.setImageResource(images[i]);
                pic.setScaleType(ImageView.ScaleType.FIT_XY);
                pic.setLayoutParams(new GridView.LayoutParams(250,300));

                return pic;
            }
        }
    }



