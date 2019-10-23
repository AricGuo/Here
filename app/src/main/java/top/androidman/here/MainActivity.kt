package top.androidman.here

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.realstudio.here.Here

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Here.init(this)

        Here.config {
            multiProcess  = true
            encryptKey = "encryptKey"
        }

        Here.put("text", 100)
        Toast.makeText(this, Here.getInt("text").toString(), Toast.LENGTH_SHORT).show()

        Here.bucket("user") {
            put("text", 300)
        }
        Toast.makeText(this, Here.bucket("user").getInt("text").toString(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, Here.getInt("text").toString(), Toast.LENGTH_SHORT).show()
    }
}
