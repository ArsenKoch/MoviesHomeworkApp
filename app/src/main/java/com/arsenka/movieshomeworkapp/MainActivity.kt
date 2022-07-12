package com.arsenka.movieshomeworkapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
//TODO(изучить ВАЖНО):
// 1) разобраться с сериализацией(термин,библиотека kotlin.serialization),
// 2) разобраться с загрузкой картинок по URL(библиотека Glide) ,
// 3) разобраться как передавать объект с одного фрагмента на другой.
//TODO(примечания):
// 1) калькулятор для рейтинга(округляем в меньшую сторону*),
// 2) если нет актеров , то появляется надпись : "Здесь нет актеров"

