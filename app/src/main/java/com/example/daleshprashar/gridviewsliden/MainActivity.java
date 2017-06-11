package com.example.daleshprashar.gridviewsliden;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gview);
        ClassAdapter classAdapter = new ClassAdapter(this);
        gridView.setAdapter(classAdapter);
    }
}
class collectionImageTitle
{
    int  images;
    String  titlesjava;
    collectionImageTitle(int  images , String  titlesjava)
    {
        this.images = images;
        this.titlesjava = titlesjava;
    }
}
class ClassAdapter extends BaseAdapter
{
    ArrayList<collectionImageTitle> arrayListObject;
    Context context;
    ClassAdapter(Context context){
        this.context = context;
      Resources resources= context.getResources();

        String [] titlejava = resources.getStringArray(R.array.titleJava);
        int[] imagejava = {R.drawable.a , R.drawable.b , R.drawable.c , R.drawable.d , R.drawable.e , R.drawable.f};
   for (int i =0 ; i <= 5 ; i++)
   {
       collectionImageTitle objecollectionImageTitle = new collectionImageTitle(imagejava[i] ,titlejava[i]);
       arrayListObject.add(objecollectionImageTitle);
   }

    }

    @Override
    public int getCount() {
        return arrayListObject.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListObject.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ImageSaving
    {
        ImageView imageViewobj;
        ImageSaving(View view)
        {
            //one time got the imageview in imageviewobj.
            imageViewobj = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row= view;
         ImageSaving objimagesaving = null;
        if(row == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             row = inflater.inflate(R.layout.bxml , viewGroup ,false);
           //as row was null . now it contains that relative layout of the xml of bxml
            objimagesaving = new ImageSaving(row);
            // i am getting imageview saved indirectly.
            // focus it as setter and getter Tag of object. of view directly.
            row.setTag(objimagesaving);

        }else
        {
            objimagesaving= (ImageSaving) row.getTag();
        }

        // int position(in getview method) is what we need . it is zero for the first position.


        // very difficult to understand the below.
        collectionImageTitle temporaryimagesave2 = arrayListObject.get(i);
        objimagesaving.imageViewobj.setImageResource(temporaryimagesave2.images);
        return row;



    }
}
