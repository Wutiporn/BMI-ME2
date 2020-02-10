package th.ac.su.bmime2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val show = findViewById<TextView>(R.id.heading)
        val heightInput = findViewById<EditText>(R.id.inputHeight)
        val weightInput = findViewById<EditText>(R.id.inputWeight)
        val calBtn = findViewById<Button>(R.id.btnCal)

        calBtn.setOnClickListener {
            var intent = Intent(this@MainActivity,SecondActivity::class.java)
            intent.putExtra("height",heightInput.text.toString().toDouble())
            intent.putExtra("weight",weightInput.text.toString().toDouble())

            startActivity(intent)
        }
       }
    }

