import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doctor_advice)
        val advice=intent.getStringExtra("advice")
         val string=advice
        val sd=findViewById<TextView>(R.id.txt)
        sd.text=string

    }
}