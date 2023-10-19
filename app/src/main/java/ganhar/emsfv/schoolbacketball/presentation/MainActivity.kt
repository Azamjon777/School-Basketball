package ganhar.emsfv.schoolbacketball.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ganhar.emsfv.schoolbacketball.APP
import ganhar.emsfv.schoolbacketball.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APP = this
    }
}