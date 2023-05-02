package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class NewsPopup(
    private val from: String,
    private val title: String,
    private val description: String
) : DialogFragment() {

    override fun onStart() {
        super.onStart()

        val dialog = dialog
        dialog?.window?.setLayout(
            getDialogMaxWeight(),
            getDialogMaxHeight()
        )
    }

    private fun getDialogMaxHeight(): Int {
        val displayMetrics = resources.displayMetrics
        val screenHeight = displayMetrics.heightPixels

        return (screenHeight * 0.75).toInt()
    }

    private fun getDialogMaxWeight(): Int {
        val displayMetrics = resources.displayMetrics
        val screenWeight = displayMetrics.widthPixels

        return (screenWeight * 0.9).toInt()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_dialog, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvFrom: TextView = view.findViewById(R.id.tv_from)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)
        tvFrom.text = from
        tvTitle.text = title
        tvDescription.text = description
        Log.d("popup", description)

        val bOk = view.findViewById<Button>(R.id.b_ok)

        bOk.setOnClickListener {
            dismiss()
        }
    }

}