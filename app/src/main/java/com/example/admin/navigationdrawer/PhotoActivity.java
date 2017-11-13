package com.example.admin.navigationdrawer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PhotoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    int REQUEST_IMAGE_CAPTURE = 1;
    int pictureTakeCounter = 1;
    ImageView photo1;
    ImageView photo2;
    ImageView photo3;
    ImageView photo4;
    ImageView photo5;
    ImageView photo6;
    ImageView photo7;
    ImageView photo8;
    ImageView photo9;
    ImageView photo10;
    ImageView photo11;
    ImageView photo12;
    NavigationView nv;
    private String TAG = "PhotoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_photo);
        bindViews();
        nv.setNavigationItemSelectedListener(this);

    }

    public void bindViews()
    {
        photo1 = findViewById(R.id.photo1);
        photo2 = findViewById(R.id.photo2);
        photo3 = findViewById(R.id.photo3);
        photo4 = findViewById(R.id.photo4);
        photo5 = findViewById(R.id.photo5);
        photo6 = findViewById(R.id.photo6);
        photo7 = findViewById(R.id.photo7);
        photo8 = findViewById(R.id.photo8);
        photo9 = findViewById(R.id.photo9);
        photo10 = findViewById(R.id.photo10);
        photo11 = findViewById(R.id.photo11);
        photo12 = findViewById(R.id.photo12);
        nv = findViewById(R.id.navigationView);
    }

    public void takePicture(View view)
    {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (pictureTakeCounter > 12)
            {
                pictureTakeCounter = 1; //we only have 12 pictures in the album, so if the 13th picture is taken, start overwriting from pic1
            }
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

           // iview.setImageBitmap(imageBitmap);
            switch (pictureTakeCounter) {
                case 1:
                    photo1.setImageBitmap(imageBitmap);
                    photo1.setSaveEnabled(true);
                    break;
                case 2:
                    photo2.setImageBitmap(imageBitmap);
                    break;
                case 3:
                    photo3.setImageBitmap(imageBitmap);
                    break;
                case 4:
                    photo4.setImageBitmap(imageBitmap);
                    break;
                case 5:
                    photo5.setImageBitmap(imageBitmap);
                    break;
                case 6:
                    photo6.setImageBitmap(imageBitmap);
                    break;
                case 7:
                    photo7.setImageBitmap(imageBitmap);
                    break;
                case 8:
                    photo8.setImageBitmap(imageBitmap);
                    break;
                case 9:
                    photo9.setImageBitmap(imageBitmap);
                    break;
                case 10:
                    photo10.setImageBitmap(imageBitmap);
                    break;
                case 11:
                    photo11.setImageBitmap(imageBitmap);
                    break;
                case 12:
                    photo12.setImageBitmap(imageBitmap);
                    break;
            }
            SaveIamge(imageBitmap);
            pictureTakeCounter++; //after the picture has been taken and we saved it to the album, increment counter
        }
    }
   private void SaveIamge(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/saved_images");
        myDir.mkdirs();
        String fname = "photo"+ pictureTakeCounter +".jpg";
        File file = new File (myDir, fname);
       // if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            Log.d(TAG, "SaveIamge: saved file: " + file.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        //we're going to check for images now and load them if they exist
        int index = 1;
        Bitmap bitmap = null;
        String root = Environment.getExternalStorageDirectory().toString();
        while (index < 13) {
            File myDir = new File(root + "/saved_images");
            myDir.mkdirs();
            String fname = "photo" + index + ".jpg";
            File file = new File(myDir, fname);
            if (file.exists()) {
                Log.d(TAG, "onResume: file--" + file.getName() + " exists.");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                try {
                    bitmap = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                switch (index) {
                    case 1:
                        photo1.setImageBitmap(bitmap);

                        break;
                    case 2:
                        photo2.setImageBitmap(bitmap);
                        break;
                    case 3:
                        photo3.setImageBitmap(bitmap);
                        break;
                    case 4:
                        photo4.setImageBitmap(bitmap);
                        break;
                    case 5:
                        photo5.setImageBitmap(bitmap);
                        break;
                    case 6:
                        photo6.setImageBitmap(bitmap);
                        break;
                    case 7:
                        photo7.setImageBitmap(bitmap);
                        break;
                    case 8:
                        photo8.setImageBitmap(bitmap);
                        break;
                    case 9:
                        photo9.setImageBitmap(bitmap);
                        break;
                    case 10:
                        photo10.setImageBitmap(bitmap);
                        break;
                    case 11:
                        photo11.setImageBitmap(bitmap);
                        break;
                    case 12:
                        photo12.setImageBitmap(bitmap);
                        break;
                }


            }
                index++;

        }
    }
    private void goToNbaActivity()
    {
        Intent intent = new Intent(this, NbaActivity.class);
        startActivity(intent);
    }
    private void goToCalculatorActivity()
    {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
    private void goToPhotoActivity()
    {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }
    private void goToGoogleActivity()
    {
        Intent intent = new Intent(this, GoogleActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: this is called before being destroyed!");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }



    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected: in PhotoActivity you hit a menu item..");
        if (item.getItemId() == R.id.home)
        {

        }
        if (item.getItemId() == R.id.nba)
        {
            goToNbaActivity();
        }
        if (item.getItemId() == R.id.calculator)
        {
            goToCalculatorActivity();
        }
        //if (item.getItemId() == R.id.photo)
      //  {
      //      goToPhotoActivity();
      //  }
        if (item.getItemId() == R.id.google)
        {
            goToGoogleActivity();
        }

        return false;
    }
}
