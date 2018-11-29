package com.uttampanchasara.multitheme.activity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.uttampanchasara.multitheme.R
import com.uttampanchasara.multitheme.adapter.MainPagerAdapter
import com.uttampanchasara.multitheme.fragment.ThemeSwitherFragmentDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var liveData: MutableLiveData<String> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "MultiTheme"

        //assign pager adapter to viewpager
        viewPager.adapter = MainPagerAdapter(supportFragmentManager)
        //setup viewpager with tabLayout
        tabLayout.setupWithViewPager(viewPager)

        liveData.observe(this, Observer {
            Log.d("MainActivity", it + "")
        })

        liveData.value = "Activity Created"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_switch_theme) {
            //startActivity(Intent(this, SwitchThemeActivity::class.java))
            val dialog = ThemeSwitherFragmentDialog()
            liveData.value = "Option item selected"
            dialog.show(supportFragmentManager, ThemeSwitherFragmentDialog.TAG)
        }
        return super.onOptionsItemSelected(item)
    }
}