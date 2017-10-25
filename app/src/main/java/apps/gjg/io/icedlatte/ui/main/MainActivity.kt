package apps.gjg.io.icedlatte.ui.main

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import apps.gjg.io.icedlatte.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.coffee_control_fragment.*
import kotlinx.android.synthetic.main.coffee_state_fragment.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = MainFragmentPagerAdapter(supportFragmentManager)
        slidingTabs.setupWithViewPager(viewPager)
    }
}

class MainFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val coffeeControlFragment = CoffeeControlFragment()
    private val coffeeStateFragment = CoffeeStateFragment()

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            coffeeControlFragment
        } else {
            coffeeStateFragment
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Machine Control"
            1 -> "Machine State"
            else -> "Error"
        }
    }
}

class CoffeeControlFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.coffee_control_fragment, container, false)
    }
}

class CoffeeStateFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.coffee_state_fragment, container, false)
    }
}
