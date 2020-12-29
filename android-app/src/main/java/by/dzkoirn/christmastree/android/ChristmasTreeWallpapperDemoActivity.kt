package by.dzkoirn.christmastree.android

import android.os.Bundle
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import by.dzkoirn.christmastree.common.SceneHolder
import by.dzkoirn.christmastree.common.generateProportionalTree
import kotlin.time.ExperimentalTime

class ChristmasTreeWallpapperDemoActivity : AppCompatActivity() {

    private lateinit var holder: SceneHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val surfaceView = findViewById<SurfaceView>(R.id.surface)

        holder = with(surfaceView.holder) {
            val dp16 = 16f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
            SceneHolder(
                generateProportionalTree(surfaceFrame.width(), surfaceFrame.height(), dp16, dp16),
                AndroidArtist(this)
            )
        }
    }

    @ExperimentalUnsignedTypes
    @ExperimentalTime
    override fun onResume() {
        super.onResume()
        holder.start()
    }

    override fun onStop() {
        super.onStop()
        holder.stop()
    }


}