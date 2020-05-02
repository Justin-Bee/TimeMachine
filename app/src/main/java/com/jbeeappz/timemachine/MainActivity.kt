package com.jbeeappz.timemachine

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var i = 0
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        val button: Button = findViewById<Button>(R.id.button)
        button?.setOnClickListener(){
            i = progressBar!!.progress
            Thread(Runnable {
                while (i < 100) {
                    i += 5
                    // Update the progress bar and display the current value
                    handler.post(Runnable {
                        progressBar!!.progress = i

                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }
            }).start()
            var str = "Welcome to your destination"
            Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG).show()
        }
    }


}
