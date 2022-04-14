package com.best.a76k

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textBtn)
        getDetails()
    }

    private fun getDetails() {
        val text = "Please, visit this link https://github.com/AlisherDaminov1994"
        val spannable = SpannableString(text)
        val pattern = Pattern.compile("((http?|https|ftp|file)://)?(([Ww]){3}.)?[a-zA-Z0-9]+\\.[a-zA-Z]+").matcher(text)
        while (pattern.find()) {
            spannable.setSpan(ForegroundColorSpan(Color.BLUE), pattern.start(), pattern.end(), 0)
        }
        textView.text = spannable
    }
}