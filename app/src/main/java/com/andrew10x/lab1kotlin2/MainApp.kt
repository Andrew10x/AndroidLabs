package com.andrew10x.lab1kotlin2

import android.app.Application
import com.andrew10x.lab1kotlin2.db.MainDataBase

class MainApp: Application() {
    val database by lazy { MainDataBase.getDataBase(this)}
}