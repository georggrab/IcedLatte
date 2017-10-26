package apps.gjg.io.icedlatte.ui.main


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import apps.gjg.io.icedlatte.R
import apps.gjg.io.icedlatte.data.COFFEETYPES


class CoffeeButtonAdapter(private val context: Context) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var btn = inflater.inflate(R.layout.coffee_button, null) as Button
        btn.setOnClickListener(CoffeeOnClickListener())

        if (convertView == null) {

            btn.text = COFFEETYPES.values()[position].name
            btn.setPadding(8, 8, 8, 8)

        } else {
            btn = convertView as Button
        }
        return btn
    }

    override fun getItem(position: Int): COFFEETYPES {
        return COFFEETYPES.values()[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return COFFEETYPES.values().size
    }
}

class CoffeeOnClickListener : View.OnClickListener {
    override fun onClick(v: View?) {
        Log.d("Info", ((v as Button).text).toString())
    }


}