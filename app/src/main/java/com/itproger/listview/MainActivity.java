package com.itproger.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editTextShortRef;
    private EditText editTextFulltRef;
    private Button button;
    private TextView info_app;
    ArrayList<RefMap> list;
    SimpleAdapter adapter;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получаем экземпляр элемента ListView
        ListView listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        editTextShortRef = findViewById(R.id.editTextShortRef);
        editTextFulltRef = findViewById(R.id.editTextFullRef);

        info_app = findViewById(R.id.info_app);

        ArrayList<RefMap> list = new ArrayList<>();
        // Заполняем данными
        list.add(new RefMap("ggl", "https://www.google.com"));
        list.add(new RefMap("hk", "https://id.heroku.com/"));
        list.add(new RefMap("yt", "https://www.youtube.com/watch?v=pb4wOqcFayE"));
        list.add(new RefMap("zen", "https://www.asus.com/ua-ua/laptops/for-home/zenbook/asus-zenbook-15-ux534/"));

         adapter = new SimpleAdapter(this, list, R.layout.ref_list_row,
                new String[]{RefMap.SHORTREF, RefMap.FULLREF}, new int[]{
                R.id.textShortRef, R.id.textURL});
        listView.setAdapter(adapter);

        message = "";
        info_app.setText(message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_app.setText("");
                String shortRef = editTextShortRef.getText().toString();
                String fullRef = editTextShortRef.getText().toString();
                if(shortRef.isEmpty() && shortRef.isEmpty()) {
                    message = "Заполните поля!!!";
                    // Создаем анимацию: мигание надписи
                    info_app.setText(message);
                    GoAnimation();
                   // info_app.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_info_text));
                /*} else if(list.contains(shortRef)) {
                    message = "Введите другое сокращение";
                } else {
                    for (Map.Entry<String, String> item : RefMap.entrySet()) {

                        System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());*/
                    } else {
                    list.add(new RefMap(editTextShortRef.getText().toString(),
                            editTextFulltRef.getText().toString()));
                    editTextShortRef.setText("");
                    editTextFulltRef.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
//                                    long id) {
//                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void GoAnimation() {
        // Создаем анимацию: мигание надписи
        //info_app.setText(message);
        info_app.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_info_text));
    }

//    public void addRef(View view){
//        String shortRef = editTextShortRef.getText().toString();
//        String fullRef = editTextShortRef.getText().toString();
//        if(shortRef.isEmpty() && shortRef.isEmpty()) {
//            message = "Заполните поля!!!";
//            // Создаем анимацию: мигание надписи
//            info_app.setText(message);
//            info_app.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_info_text));
//        }else {
//            list.add(new RefMap(editTextShortRef.getText().toString(),
//                    editTextFulltRef.getText().toString()));
//            editTextShortRef.setText("");
//            editTextFulltRef.setText("");
//            adapter.notifyDataSetChanged();
//        }
//    }

}


// используем адаптер данных
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, catNames);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, catNames);
//        listView.setAdapter(adapter);

        // Прослушиваем нажатия клавиш
//        editText.setOnKeyListener(new View.OnKeyListener() {
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (event.getAction() == KeyEvent.ACTION_DOWN)
//                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
//                        catNames.add(0, editText.getText().toString());
////                        adapter.notifyDataSetChanged();
//                        editText.setText("");
//                        return true;
//                    }
//                return false;
//            }
//        });
