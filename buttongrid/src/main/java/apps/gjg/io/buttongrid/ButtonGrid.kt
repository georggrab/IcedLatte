package apps.gjg.io.buttongrid

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridView

var LOG_TAG : String = "ButtonGridComponent"

class ButtonGrid(ctx: Context, attrs: AttributeSet) : GridView(ctx, attrs) {
    fun configure(buttonGridConfig: ButtonGridConfig) {
        numColumns = buttonGridConfig.columnWidth
        adapter = ButtonGridAdapter(buttonGridConfig)
    }
}

class ButtonGridConfig(val columnWidth: Int, val gridDescription: List<GridButtonDescription>) {

}

class GridButtonDescription(var label: String) {
    var id: Long? = null

    var row: Int? = null
    var col: Int? = null

    var color: Int = 0xFFFFFF

    init {
        id = id ?: System.nanoTime()
    }

    constructor(label: String, id: Long, color: Int): this(label) {
       this.id = id
       this.color = color
    }
}

class ButtonGridAdapter(var buttonGridConfig: ButtonGridConfig) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return if (convertView == null) {
            val button = LayoutInflater.from(parent!!.context)
                    .inflate(R.layout.button, parent, false) as Button

            button.text = buttonGridConfig.gridDescription[position].label
            button.background = ColorDrawable(buttonGridConfig.gridDescription[position].color)

            button.setOnClickListener {
                notify(buttonGridConfig.gridDescription[position])
            }
            button
        } else {
            convertView
        }
    }

    fun notify(description: GridButtonDescription) {
        Log.i(LOG_TAG, "Getting description: ${description.label}")
    }

    override fun getItem(position: Int): Any {
        return buttonGridConfig.gridDescription[position]
    }

    override fun getItemId(position: Int): Long {
        return buttonGridConfig.gridDescription[position].id!!
    }

    override fun getCount(): Int {
        return buttonGridConfig.gridDescription.size
    }

    override fun isEmpty(): Boolean {
        return buttonGridConfig.gridDescription.isEmpty()
    }

}
