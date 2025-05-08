package com.gabrielly.aula2

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.gabrielly.aula2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Configura o Spinner
        val generos = listOf("Masculino", "Feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerGenero.adapter = adapter



        // Listener do botão
        binding.btnCalcular.setOnClickListener {
            val sexo = binding.spinnerGenero.selectedItem as String
            var idade = binding.editIdade.text.toString().toLongOrNull()
            var resultado: Long = 0
            if (idade != null) {
                if (sexo.trim() == "Masculino") {
                    if (idade <= 64) {
                        resultado = 65 - idade
                        binding.textResultado.text = "Faltam $resultado anos para você se aposentar"

                    } else {
                        binding.textResultado.text = "Está na idade de aposentar!"
                    }

                } else {
                    if (idade <= 62) {
                        resultado = 62 - idade
                        binding.textResultado.text = "Faltam $resultado anos para você se aposentar"
                    } else {
                        binding.textResultado.text = "Já está na idade de aposentar!"
                    }
                }
            } else {
                binding.textResultado.text = "Por favor, insira sua idade"

            }
        }
    }
}
