package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Gallery extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    class MyItem{
        int image;
        String name;
        public MyItem(int image, String name) {
            this.image = image;
            this.name = name;
        }
    }
    private MyItem myitems[] = {

            new MyItem(R.drawable.alpine,"Alpine"),
            new MyItem(R.drawable.ar,"Alfa Romeo"),
            new MyItem(R.drawable.mclaren,"McLarren"),
            new MyItem(R.drawable.rb,"RedBull"),
            new MyItem(R.drawable.ferrari,"Ferrari"),
            new MyItem(R.drawable.mercedes,"Mercedes"),


    };
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery2);
        textView = (TextView) findViewById(R.id.item_name);
        imageView = (ImageView) findViewById(R.id.item_picture);
        textView.setText(myitems[0].name);
        imageView.setImageResource(myitems[0].image);
        new TextThread().execute();
        new ImageThread().execute(currentIndex);

    }
    private class ImageThread extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            try {
                Thread.sleep(2000);
                return myitems[currentIndex].image;


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(Integer result){

            imageView.setImageResource(result);
            new ImageThread().execute(currentIndex++);
        }

    }
    private class TextThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            return myitems[currentIndex].name;
        }


        protected void onPostExecute(String result){

            textView.setText(result);
            new TextThread().execute();
        }

    }
}