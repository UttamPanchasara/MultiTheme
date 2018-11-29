package com.uttampanchasara.multitheme.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import com.uttampanchasara.multitheme.R
import com.uttampanchasara.multitheme.adapter.MultiThemeListAdapter
import com.uttampanchasara.multitheme.adapter.ThemeChangeListener
import com.uttampanchasara.multitheme.extension.setPrefValue
import com.uttampanchasara.multitheme.model.ThemeModel
import kotlinx.android.synthetic.main.activity_switch_theme.*

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 11/2/2018
 */
class SwitchThemeActivity : BaseActivity(), ThemeChangeListener {
    override fun onThemeChanged(themeModel: ThemeModel) {
        setPrefValue(getString(R.string.currentTheme), themeModel.themeName.toString())
        recreate()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_theme)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Switch Theme"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = MultiThemeListAdapter(this)
        rvThemes.adapter = adapter
        rvThemes.layoutManager = GridLayoutManager(this, 4) as RecyclerView.LayoutManager?
        adapter.setData(getThemes())
    }

    private fun getThemes(): ArrayList<ThemeModel> {
        val themesList: ArrayList<ThemeModel> = ArrayList()

        val default = ThemeModel()
        default.themeColor = R.color.colorPrimary
        default.themeName = "Default"
        themesList.add(default)

        val black = ThemeModel()
        black.themeColor = R.color.blackColorPrimary
        black.themeName = "Black"
        themesList.add(black)

        val green = ThemeModel()
        green.themeColor = R.color.greenColorPrimary
        green.themeName = "Green"
        themesList.add(green)

        return themesList
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}