package com.example.caculator_itmc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Numbers
        btn_0.setOnClickListener { appendVal("0", true) }
        btn_1.setOnClickListener { appendVal("1", true) }
        btn_2.setOnClickListener { appendVal("2", true) }
        btn_3.setOnClickListener { appendVal("3", true) }
        btn_4.setOnClickListener { appendVal("4", true) }
        btn_5.setOnClickListener { appendVal("5", true) }
        btn_6.setOnClickListener { appendVal("6", true) }
        btn_7.setOnClickListener { appendVal("7", true) }
        btn_8.setOnClickListener { appendVal("8", true) }
        btn_9.setOnClickListener { appendVal("9", true) }
        btn_phay.setOnClickListener { appendVal(".", true) }

        // Operators
        //btn_ac.setOnClickListener { appendVal("", true) }
        btn_chia.setOnClickListener { appendVal(" / ", false) }
        btn_nhan.setOnClickListener { appendVal(" * ", false) }
        btn_tru.setOnClickListener { appendVal(" - ", false) }
        btn_cong.setOnClickListener { appendVal(" + ", false) }

        btn_ac.setOnClickListener {
            tvExpression.text = ""
            tvketqua.text = ""
        }

        //btn_back.setOnClickListener {
        //    tvketqua.text = tvketqua.text.toString().subSequence(0, tvketqua.text.length - 1)
        //}

        btn_bang.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvketqua.text = longResult.toString()
                    tvExpression.text = ""
                } else {
                    tvketqua.text=result.toString()
                    tvExpression.text = ""
                }
                  } catch (e: Exception) {
                }
            }
        }


    fun appendVal(string: String, isClear: Boolean) {
        if (tvketqua.text.isNotEmpty()) {
            tvExpression.text = ""
        }
        if (isClear){
            tvketqua.text = ""
            tvExpression.append(string)
        }else {
            tvExpression.append(tvketqua.text)
            tvExpression.append(string)
            tvketqua.text=""
        }
    }
}
