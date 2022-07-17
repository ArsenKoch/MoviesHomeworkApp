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
// 1) переход(передвать данные),
// 2) отображать картинку и задний фон,название,описание и тд(в деталях)(библиотека Glide) ,
//  3) у актеров нужно доставать (картинку,имя,айдишник)
//TODO(примечания):
// 1) калькулятор для рейтинга(округляем в меньшую сторону*),
// 2) если нет актеров , то появляется надпись : "Здесь нет актеров"

