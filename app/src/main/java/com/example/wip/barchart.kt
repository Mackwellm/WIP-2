package com.example.wip

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.ArrayList


class barchart : AppCompatActivity() {

    private lateinit var barGArrayList: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barchart)

        val barChart: BarChart = findViewById(R.id.bar_graph)
        val barDataSet: BarDataSet = BarDataSet(barGArrayList, "Hours")
        val barData: BarData = BarData(barDataSet)

        barChart.setData(barData)
        //color bar data set
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS)
        //text color
        barDataSet.setValueTextColor(Color.BLACK)
        //settting text size
        barDataSet.setValueTextSize(16f)
        barChart.getDescription().setEnabled(true)
    }

    private fun BarDataSet(barGArrayList: ArrayList<Int>, s: String): BarDataSet {
        TODO("Not yet implemented")
    }


    fun getData() {
        barGArrayList = ArrayList()
        barGArrayList.add(BarEntry(2f, 10))
        barGArrayList.add(BarEntry(3f, 20))
        barGArrayList.add(BarEntry(4f, 30))
        barGArrayList.add(BarEntry(5f, 40))
        barGArrayList.add(BarEntry(6f, 50))
    }

    private fun BarEntry(fl: Float, i: Int): Int {
        TODO("Not yet implemented")
    }

}

private fun BarDataSet.setColors(colorfulColors: IntArray?) {
    TODO("Not yet implemented")
}

