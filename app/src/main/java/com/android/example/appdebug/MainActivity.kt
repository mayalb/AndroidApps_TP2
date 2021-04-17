package com.android.example.appdebug

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double.parseDouble
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val util = Util()
        val fbButton = findViewById(R.id.fbButton) as Button
        val factButton = findViewById(R.id.factButton) as Button
        val avgButton = findViewById(R.id.avgButton) as Button
        val factEditText = findViewById(R.id.factEditText) as EditText
        val sizeEditText = findViewById(R.id.sizeEditText) as EditText
        // The facebook page URL
        val url  = "fb://page/218641444910278"
        // Onclick of the first button
        fbButton.setOnClickListener({
            util.openPage(this,url)
        })
        // Onclick of the second button

        factButton.setOnClickListener({
            var numeric = true
            try {
                val j= parseDouble (factEditText.text.toString())

            } catch (e: NumberFormatException) {
                numeric = false
            }
            if(numeric){

                if(factEditText.text.toString().toInt()<=0){
                    Toast.makeText(this,"Veuillez introduire un nombre supérieur à Zéro ",Toast.LENGTH_SHORT).show()
                }else{

                           val i = util.factorial(factEditText.text.toString().toInt())
                           Toast.makeText(this,"Le factoriel est: $i",Toast.LENGTH_SHORT).show()






                }


                //Toast.makeText(this,"ceci est un nb",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Erreur , Veuillez introduire un nombre",Toast.LENGTH_SHORT).show()
            }


        })
        // Onclick of the third button
        avgButton.setOnClickListener(
        {
            val nb=sizeEditText.text.toString()
            val bol=nb.isNullOrEmpty()
            if( bol){
                Toast.makeText(this,"Veuillez introduire un nombre",Toast.LENGTH_SHORT).show()
            }else{

                 val list = util.randomList(sizeEditText.text.toString().toInt())
                var sum = 0
                   for (item in list) {
                     sum+= item
                 }
                 Toast.makeText(this,"La moyenne de la liste est: ${sum/list.size}",Toast.LENGTH_SHORT).show()
            }

        })

    }
}
