package by.dzkoirn.christmastree.android

import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import by.dzkoirn.christmastree.common.SceneHolder
import by.dzkoirn.christmastree.common.generateProportionalTree
import kotlin.time.ExperimentalTime

class ChristmasTreeWallpapperDemoActivity : AppCompatActivity() {

    @ExperimentalUnsignedTypes
    @ExperimentalTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val surfaceView = findViewById<SurfaceView>(R.id.surface)
        surfaceView.holder.addCallback(object : SurfaceHolder.Callback {

            private lateinit var sceneHolder: SceneHolder

            override fun surfaceCreated(holder: SurfaceHolder) {
                sceneHolder = with(holder) {
                    val dp16 = 16f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
                    SceneHolder(
                        generateProportionalTree(surfaceFrame.width(), surfaceFrame.height(), dp16, dp16),
                        AndroidArtist(this)
                    )
                }
                sceneHolder.start()
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                sceneHolder.stop()
            }

        })

    }
}