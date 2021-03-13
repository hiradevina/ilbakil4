package bangkit.mobiledev.hira.ilbakilseason4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bangkit.mobiledev.hira.ilbakilseason4.R
import bangkit.mobiledev.hira.ilbakilseason4.data.Member
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class ListMemberAdapter(private var data: ArrayList<Member>) :
    RecyclerView.Adapter<ListMemberAdapter.ListMemberItemViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListMemberItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.listitem_image)
        var name: TextView = itemView.findViewById(R.id.listitem_title)
        var alias: TextView = itemView.findViewById(R.id.listitem_alias)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMemberItemViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_member, parent, false)
        return ListMemberItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ListMemberItemViewHolder, position: Int) {
        val member = data[position]
        Glide.with(holder.itemView.context)
            .load(member.img)
            .apply(RequestOptions().override(65, 65).transform(CenterCrop(), RoundedCorners(16)))
            .into(holder.image)
        holder.name.text = member.name
        holder.alias.text = member.knownAs
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            holder.name.setTextColor(holder.itemView.context.getColor(member.color))
        }
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(data[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Member)
    }
}