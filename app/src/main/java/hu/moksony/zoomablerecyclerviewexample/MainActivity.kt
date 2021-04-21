package hu.moksony.zoomablerecyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import hu.moksony.zoomable_recyclerview.ZoomableRecyclerView

class MainActivity() : AppCompatActivity() {

    val adapter = ExampleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<ZoomableRecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

    class ExampleAdapter : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

        val items = listOf(
            R.drawable.cat1,
            R.drawable.cat2
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.row_image, parent, false)
            return ExampleViewHolder(view)
        }

        override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
            holder.setImage(items[position])
        }

        override fun getItemCount(): Int {
            return items.size
        }

        class ExampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val imageView: ImageView = view.findViewById(R.id.imageView)

            fun setImage(@DrawableRes resId: Int) {
                this.imageView.setImageResource(resId)
            }
        }
    }
}