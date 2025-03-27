import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ইনপুট ফিল্ড
        val backPartTime = findViewById<EditText>(R.id.backPartTime)
        val frontPartTime = findViewById<EditText>(R.id.frontPartTime)
        val sleeveTime = findViewById<EditText>(R.id.sleeveTime)
        val officeHours = findViewById<EditText>(R.id.officeHours)
        val breakTime = findViewById<EditText>(R.id.breakTime)
        val machines = findViewById<EditText>(R.id.machines)

        // ক্যালকুলেট বাটন
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        calculateBtn.setOnClickListener {
            calculateSweaters()
        }
    }

    private fun calculateSweaters() {
        // ক্যালকুলেশন লজিক (আপনার JS কোড কনভার্ট করা)
        val back = findViewById<EditText>(R.id.backPartTime).text.toString().toDoubleOrNull() ?: 0.0
        val front = findViewById<EditText>(R.id.frontPartTime).text.toString().toDoubleOrNull() ?: 0.0
        val sleeve = findViewById<EditText>(R.id.sleeveTime).text.toString().toDoubleOrNull() ?: 0.0
        val office = findViewById<EditText>(R.id.officeHours).text.toString().toDoubleOrNull() ?: 0.0
        val breakT = findViewById<EditText>(R.id.breakTime).text.toString().toDoubleOrNull() ?: 120.0
        val machineCount = findViewById<EditText>(R.id.machines).text.toString().toIntOrNull() ?: 0

        val totalTime = (office * 60 - breakT)
        val sweaterTime = back + front + (sleeve * 2)
        val totalSweaters = if (sweaterTime > 0) (totalTime * machineCount / sweaterTime).toInt() else 0

        // রেজাল্ট শো করুন
        findViewById<TextView>(R.id.resultText).text = "মোট সয়টার: $totalSweaters পিস"
    }
}