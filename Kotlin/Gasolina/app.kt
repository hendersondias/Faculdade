import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcularButton = findViewById<Button>(R.id.calcularButton)
        calcularButton.setOnClickListener { view -> calcularGasto(view) }
    }

    private fun calcularGasto(view: View) {
        val distanciaInput = findViewById<EditText>(R.id.distanciaInput)
        val precoLitroInput = findViewById<EditText>(R.id.precoLitroInput)
        val autonomiaInput = findViewById<EditText>(R.id.autonomiaInput)
        val resultadoText = findViewById<TextView>(R.id.resultadoText)

        val distancia = distanciaInput.text.toString().toDouble()
        val precoLitro = precoLitroInput.text.toString().toDouble()
        val autonomia = autonomiaInput.text.toString().toDouble()

        val totalGasto = (distancia / autonomia) * precoLitro
        val formatado = NumberFormat.getCurrencyInstance().format(round(totalGasto * 100) / 100)

        resultadoText.text = "GASTO TOTAL SERÁ DE: $formatado"
    }
}
