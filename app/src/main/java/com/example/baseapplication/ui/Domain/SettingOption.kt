package com.example.baseapplication.ui.Domain

import com.example.baseapplication.R

enum class SettingOption(val title:String, val iconRes:Int) {
    LANGUAGE("Language", R.drawable.ic_lang),
    RATE("Rate app",R.drawable.ic_rate),
    FEEDBACK("Feedback",R.drawable.ic_feedb),
    SHARE("Share app",R.drawable.ic_share),
    POLICY("Policy",R.drawable.ic_policy),
}