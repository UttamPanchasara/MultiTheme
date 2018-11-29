package com.uttampanchasara.multitheme.fragment

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uttampanchasara.multitheme.R
import com.uttampanchasara.multitheme.activity.MainActivity
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
class ThemeSwitherFragmentDialog : DialogFragment(), ThemeChangeListener {

    companion object {
        const val TAG = "SwitcherDialog"
    }

    override fun onThemeChanged(themeModel: ThemeModel) {
        mActivity.setPrefValue(getString(R.string.currentTheme), themeModel.themeName.toString())
        mActivity.recreate()
        dismiss()
    }

    lateinit var mActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_switch_theme, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity as MainActivity

        val adapter = MultiThemeListAdapter(this)
        rvThemes.adapter = adapter
        rvThemes.layoutManager = GridLayoutManager(mActivity, 4) as RecyclerView.LayoutManager?
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

        val purple = ThemeModel()
        purple.themeColor = R.color.purpleColorPrimary
        purple.themeName = "Purple"
        themesList.add(purple)

        return themesList
    }
}