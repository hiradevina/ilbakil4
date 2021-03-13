package bangkit.mobiledev.hira.ilbakilseason4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions


class MemberDetailActivity : AppCompatActivity() {
    companion object {
        const val NAME = "name"
        const val ALIAS = "alias"
        const val DESCRIPTION = "description"
        const val IMAGE = "image"
        const val COLOR = "color"
        const val URL = "url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_detail)

        val imageView: ImageView = findViewById(R.id.memberdetail_img)
        val nameView: TextView = findViewById(R.id.memberdetail_name)
        val aliasView: TextView = findViewById(R.id.memberdetail_alias)
        val descriptionView: TextView = findViewById(R.id.memberdetail_description)
        val knowMore: Button = findViewById(R.id.memberdetail_knowmore)
        val share: Button = findViewById(R.id.memberdetail_share)

        val name: String? = intent.getStringExtra(NAME)
        val alias: String? = intent.getStringExtra(ALIAS)
        val desc: String? = intent.getStringExtra(DESCRIPTION)
        val url: String? = intent.getStringExtra(URL)
        val color: Int = intent.getIntExtra(COLOR, 0)


        knowMore.text = "Know more about $name"
        knowMore.setBackgroundColor(this.getColor(color))
        share.text = "Share"
        share.setBackgroundColor(this.getColor(color))

        val toolbar: Toolbar = findViewById(R.id.activitymemberdetail_toolbar)
        toolbar.title = name

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        nameView.text = name
        aliasView.text = "Known as $alias"
        descriptionView.text = desc
        Glide.with(this)
            .load(intent.getIntExtra(IMAGE, 0))
            .apply(RequestOptions().transform(CenterCrop()))
            .into(imageView)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            toolbar.setTitleTextColor(this.getColor(R.color.white))
            nameView.setTextColor(this.getColor(color))
            toolbar.setBackgroundColor(this.getColor(color))
        }

        toolbar.setNavigationOnClickListener { finish() }

        knowMore.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }

        share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name\nKnown as\n$alias\n\n$desc\nKnow more: $url")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

}