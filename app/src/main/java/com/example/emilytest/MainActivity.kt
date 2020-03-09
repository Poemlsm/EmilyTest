package com.example.emilytest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity : AppCompatActivity(), View.OnClickListener {
    // BottomSheetBehavior variable
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var bottomSheetHeading: TextView
    private lateinit var expandBottomSheetButton: Button
    private lateinit var collapseBottomSheetButton: Button
    private lateinit var hideBottomSheetButton: Button
    private lateinit var showBottomSheetDialogButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    private fun initView() {

        bottomSheetBehavior =
            BottomSheetBehavior.from(findViewById<RelativeLayout>(R.id.bottomSheetLayout))
        bottomSheetHeading = findViewById(R.id.bottomSheetHeading)
        expandBottomSheetButton = findViewById(R.id.expand_bottom_sheet_button)
        collapseBottomSheetButton = findViewById(R.id.collapse_bottom_sheet_button)
        hideBottomSheetButton = findViewById(R.id.hide_bottom_sheet_button)
        showBottomSheetDialogButton = findViewById(R.id.show_bottom_sheet_dialog_button)
    }

    private fun initListener() {
        expandBottomSheetButton.setOnClickListener(this)
        collapseBottomSheetButton.setOnClickListener(this)
        hideBottomSheetButton.setOnClickListener(this)
        showBottomSheetDialogButton.setOnClickListener(this)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            @SuppressLint("SwitchIntDef")
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetHeading.text = "Expanded Me"
                } else {
                    bottomSheetHeading.text = "Collapse Me"
                }
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_EXPANDED"
                    )
                    BottomSheetBehavior.STATE_COLLAPSED -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_COLLAPSED"
                    )
                    BottomSheetBehavior.STATE_HIDDEN -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_HIDDEN"
                    )
                    BottomSheetBehavior.STATE_DRAGGING -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_DRAGGING"
                    )
                    BottomSheetBehavior.STATE_SETTLING -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_SETTLING"
                    )

                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) = Unit
        })

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.expand_bottom_sheet_button -> bottomSheetBehavior.state =
                BottomSheetBehavior.STATE_EXPANDED

            R.id.collapse_bottom_sheet_button -> bottomSheetBehavior.state =
                BottomSheetBehavior.STATE_COLLAPSED

            R.id.hide_bottom_sheet_button -> bottomSheetBehavior.state =
                BottomSheetBehavior.STATE_HIDDEN

        }
    }

}
