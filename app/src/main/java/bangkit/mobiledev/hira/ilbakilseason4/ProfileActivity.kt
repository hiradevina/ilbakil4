package bangkit.mobiledev.hira.ilbakilseason4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var toolbar: Toolbar = findViewById(R.id.activityprofile_toolbar)
        setSupportActionBar(toolbar)

        Glide.with(this)
            .load(R.drawable.profile)
            .apply(RequestOptions().transform(CenterCrop()))
            .into(findViewById(R.id.profile_img))


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }
}