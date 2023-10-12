package work.icu007.activitylifecycletest

import android.app.Activity
import android.util.Log


/*
 * Author: Charlie_Liao
 * Time: 2023/10/11-11:09
 * E-mail: rookie_l@icu007.work
 */

object ActivityCollector {
    private val activites = ArrayList<Activity>()

    fun addActivity(activity: Activity){
        Log.d("LCR ActivityCollector", "addActivity: ${activity.componentName} add")
        activites.add(activity)
    }

    fun removeActivity(activity: Activity){
        Log.d("LCR ActivityCollector", "removeActivity: ${activity.componentName} remove")
        activites.remove(activity)
    }

    fun finishAll(){
        for (activity in activites){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
        activites.clear()
        android.os.Process.killProcess(android.os.Process.myPid())
        Log.d("LCR ActivityCollector", "finishAll: ")
    }
}