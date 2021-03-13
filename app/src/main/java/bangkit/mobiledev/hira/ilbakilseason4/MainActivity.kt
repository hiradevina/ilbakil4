package bangkit.mobiledev.hira.ilbakilseason4

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bangkit.mobiledev.hira.ilbakilseason4.adapter.ListMemberAdapter
import bangkit.mobiledev.hira.ilbakilseason4.data.IlbakMembers.ilbakMemberList
import bangkit.mobiledev.hira.ilbakilseason4.data.Member
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.CollapsingToolbarLayout


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.mainactivity_toolbar)
        setSupportActionBar(toolbar)

        val collapsingToolbarLayout: CollapsingToolbarLayout =
            findViewById(R.id.mainactivity_collapsing_toolbar)

        collapsingToolbarLayout.title = "2 Days 1 Night Season 4"

        Glide.with(this)
            .load(R.drawable.members)
            .apply(RequestOptions().transform(CenterCrop()))
            .into(findViewById(R.id.mainactivity_members))

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            collapsingToolbarLayout.setCollapsedTitleTextColor(
                getColor(R.color.white)
            )
            collapsingToolbarLayout.setExpandedTitleColor(
                TRANSPARENT
            )
        }

        recyclerView = findViewById(R.id.mainactivity_rv)
        recyclerView.setHasFixedSize(true)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val listMemberAdapter = ListMemberAdapter(ilbakMemberList)
        recyclerView.adapter = listMemberAdapter

        listMemberAdapter.setOnItemClickCallback(object : ListMemberAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Member) {
                val detailMemberIntent = Intent(this@MainActivity, MemberDetailActivity::class.java)
                detailMemberIntent.putExtra(MemberDetailActivity.NAME, data.name)
                detailMemberIntent.putExtra(MemberDetailActivity.DESCRIPTION, data.description)
                detailMemberIntent.putExtra(MemberDetailActivity.ALIAS, data.knownAs)
                detailMemberIntent.putExtra(MemberDetailActivity.COLOR, data.color)
                detailMemberIntent.putExtra(MemberDetailActivity.IMAGE, data.img)
                detailMemberIntent.putExtra(MemberDetailActivity.URL, data.url)
                startActivity(detailMemberIntent)
            }
        })

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainactivity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_profile) {
            val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profileIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}