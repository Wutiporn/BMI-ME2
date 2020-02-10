package th.ac.su.bmime2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val height = intent.getDoubleExtra("height", -1.0)
        val weight = intent.getDoubleExtra("weight", -1.0)

        var yourBmi = findViewById<TextView>(R.id.yourBmi)
        var health = findViewById<TextView>(R.id.health)
        var heightWeight = findViewById<TextView>(R.id.heightWeight)
        var btnClose = findViewById<TextView>(R.id.btnClose)
        var heightformcm: Double = 0.0
        var result: Double = 0.0

        btnClose.setOnClickListener {
            finish()
        }

        heightformcm = height / 100
        result = weight / (heightformcm * heightformcm)

        yourBmi.setText(result.round(2).toString())

        var Health = "None"

        if (result < 18.50) {
            Health = "(Underweight)"

        } else if (result >= 18.50 && result <= 25.00) {
            Health = "(Healthy)"

        } else if (result > 25.00 && result <= 30.00) {
            Health = "(Overweight)"

        } else if (result > 30) {
            Health = "(Obese)"

        }

        health.setText(Health.toString())
        heightWeight.setText("height :" + height.toString() + "weight :" + weight.toString())

        var btnShared = findViewById<Button>(R.id.btnShared)
        btnShared.setOnClickListener {

            val value = ("My BMI is : " + result.round(2) + Health)

            var intent = Intent();
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, value)
            intent.type = "text/plan"

            startActivity(Intent.createChooser(intent, "share info"))

        }
    }
}
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}

