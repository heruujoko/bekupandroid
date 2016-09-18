package com.bits.bekup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView _list;
    String[] data;
    List<String> dinamis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _list = (ListView) findViewById(R.id.list);
        data = new String[6];
        data[0] = "Hello";
        data[1] = "Android";
        data[2] = "Is";
        data[3] = "Great";
        data[4] = "!!!!";
        data[5] = "test";

        dinamis = new ArrayList<String>();
        dinamis.add("Hello");
        dinamis.add("Android");
        dinamis.add("is");
        dinamis.add("test");

        dinamis.set(1,"Android 4");

        _list.setAdapter(new CustomAdapter(this,dinamis));
        _list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),dinamis.get(i),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class CustomAdapter extends ArrayAdapter<String>{
        Context context;
        List<String> adapterdata;

        public CustomAdapter(Context context,List<String> data) {
            super(context, R.layout.row_view ,data);
            this.context = context;
            this.adapterdata = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.row_view,parent,false);
            TextView text = (TextView) rowView.findViewById(R.id.row_text);
            ImageView img = (ImageView) rowView.findViewById(R.id.pic);
            text.setText(adapterdata.get(position));
            if((position % 2) == 0){
                img.setImageResource(R.drawable.php7);
            } else {

            }

            return rowView;
        }
    }

}
