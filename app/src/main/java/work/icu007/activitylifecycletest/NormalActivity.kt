package work.icu007.activitylifecycletest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import work.icu007.activitylifecycletest.databinding.ActivityNormalBinding

class NormalActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNormalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LCR", "onCreate: NormalActivity TaskId is $taskId")
        binding = ActivityNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartFirstActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnStartThirdActivity.setOnClickListener {
//            val intent = Intent(this, ThirdActivity::class.java)
//            startActivity(intent)
            ThirdActivity.actionStart(this,"hello","world")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("NormalActivity LCR", "onDestroy: NormalActivity Destroy")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_normal)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}