package work.icu007.activitylifecycletest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import work.icu007.activitylifecycletest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private val tag = "MainActivity LCR"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate: Activity第一次被创建的时候调用 TaskId is $taskId")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState != null){
            val tempData = savedInstanceState.getString("data_key",null)
            Log.d(tag, "onCreate: ")
        }

        binding.startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }

        binding.startDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }

        binding.finishActivity.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart: Activity由不可见变为可见的时候调用。")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume: Activity准备好和用户进行交互的时候调用。")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause: 在系统准备去启动或者恢复另一个Activity的时候调用。")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop: Activity完全不可见的时候调用。")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy: Activity被销毁之前调用.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart: Activity由停止状态变为运行状态之前调用.")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "Something u just typed"
        outState.putString("data_key", tempData)
    }
}