package io.dwak.boiler.retrorxbinding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import com.jakewharton.rxbinding.view.clicks
import com.jakewharton.rxbinding.widget.changes
import com.jakewharton.rxbinding.widget.progress
import com.jakewharton.rxbinding.widget.text
import io.dwak.boiler.retrorxbinding.databinding.MainActivityBinding


public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.activity_main)
        val mainViewModel = MainViewModel()
        val intToString: (Int) -> String = { it.toString() }

        bind<String>(mainViewModel.counter().map(intToString), binding.counterOutput.text())

        bind<String>(mainViewModel.progress().map(intToString), binding.seekbarOutput.text())

        bind<Int>(mainViewModel.progress(), binding.progBar.progress())

        bind(binding.counterButton.clicks(), mainViewModel.counterClicked())

        bind(binding.seekbar.changes(), mainViewModel.seekProgress())
    }
}
