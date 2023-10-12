package work.icu007.activitylifecycletest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import work.icu007.activitylifecycletest.databinding.ActivityThirdBinding

class ThirdActivity : BaseActivity() {
    private lateinit var binding: ActivityThirdBinding
    companion object : BaseActivity() {
        fun actionStart(context: Context, data1: String, data2: String){
            val intent = Intent(context, ThirdActivity::class.java)
            intent.putExtra("param1", data1)
            intent.putExtra("param2", data2)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LCR", "onCreate: TaskId is $taskId")
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("LCR ThirdActivity", "onCreate: ${intent.getStringExtra("param1")} ${intent.getStringExtra("param2")}")

        binding.btnFinish.setOnClickListener {
            ActivityCollector.finishAll()
//            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }
}