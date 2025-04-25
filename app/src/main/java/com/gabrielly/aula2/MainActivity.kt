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
            var resultado: Long
            if (idade != null) {
                if (sexo.trim()=="masclino"){
                    resultado = 65 - idade
                }else{
                    resultado = 62 - idade
                }
                binding.textResultado.text = "Faltam $resultado anos para você se aposentar"

            } else {
                binding.textResultado.text = "Por favor, insira sua idade."
            }
        }


    }
}
