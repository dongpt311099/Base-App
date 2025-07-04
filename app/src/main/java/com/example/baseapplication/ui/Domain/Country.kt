package com.example.baseapplication.ui.Domain

import android.icu.util.Currency
import com.example.baseapplication.R

enum class Country(val currency:String, val cur_symbol: String, val iconRes:Int) {
    VIETNAM("VietNamDong","VND", R.drawable.ic_vietnam),
    USA("USD","$",R.drawable.img_usa),
}