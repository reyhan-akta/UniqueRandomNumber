package com.example.atga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class RandomNumber extends AppCompatActivity {
  Button create_random_number;
  int click_counter, number_range = 60, create_random_num, random_num_created;
  int[] randArray;
  Random random;
  int
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        create_random_number = findViewById(R.id.producerandomnumber);

        random = new Random();
        randArray = new int[number_range];

       //butona tıklandığında & When press on the button
       create_random_number.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               //tıklama sayısı istenilen  üretim sınır sayısından küçük olup olmadığı kontorl ediliyor.
               //check the press counter that smaller then number count or not
               if (click_counter < number_range) {
                   int i = 0;
                   create_random_num = random.nextInt(number_range); //belirlenen aralıkta random sayısı üretildi & create a new random number in determined range

                   //Yeni üretilen sayının  while döngüsü ile teker teker üretilmiş sayılar dizi  elemanlardan birine eşit olup olmadığı test ediliyor.
                   //We r testing  by while loop that if there is any item of created(before) list equal to created new random number one by one.
                   while (i < random_num_created) {
                       if (create_random_num == randArray[i]) { //yeni üretilen sayının daha önce üretilmiş dizisindeki elemana eşit olup olmadığı kontrol ediyor & checking that if the new item created equal to item of created(before) list
                           create_random_num = random.nextInt(number_range); //bu durumda tekrardan random sayı üret & in this case create again another  random number.
                           i = 0;
                       } else { // if not
                           i++; //üretilmiş liste eleman sayısını bir arttır, increase the count of created(before) list items
                       }
                   }
                   randArray[random_num_created] = create_random_num; //üretilmiş dizinin sonunda yeni üretilmiş random sayısını ekle & add a new random number created into list of created(before) numbers
                   random_num_created++; //son olarak üretilmiş dizinin eleman sayısnı bir arttır & at the last increase one the count of created(before) number list.
               }


           }
       });
    }
}