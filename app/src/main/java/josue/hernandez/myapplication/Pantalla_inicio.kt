package josue.hernandez.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pantalla_inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtnombre = findViewById<EditText>(R.id.txtNombre)
        val txtcontra = findViewById<EditText>(R.id.txtContrasena)
        val txtedad = findViewById<EditText>(R.id.txtEdad)
        val txtcorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtdui = findViewById<EditText>(R.id.txtDui)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)


        btnAgregar.setOnClickListener {
            if (txtnombre.text.isEmpty()
                || txtcontra.text.isEmpty()
                || txtedad.text.isEmpty()
                || txtcorreo.text.isEmpty()
                || txtdui.text.isEmpty()
                )
            {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            }
            else{
                if(!txtedad.text.matches(("[0-9]+").toRegex())){
                    Toast.makeText(this, "La edad debe ser un numero", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}