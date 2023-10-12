package work.icu007.activitylifecycletest

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


/*
 * Author: Charlie_Liao
 * Time: 2023/10/8-12:08
 * E-mail: rookie_l@icu007.work
 */

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LCR BaseActivity", javaClass.simpleName)
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
//        Log.d("LCR BaseActivity", "onCreate: ${javaClass.simpleName} added")
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
//        Log.d("LCR BaseActivity", "onDestroy: ${javaClass.simpleName} removed")
    }
}