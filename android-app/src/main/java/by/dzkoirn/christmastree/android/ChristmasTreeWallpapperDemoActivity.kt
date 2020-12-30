package by.dzkoirn.christmastree.android

import android.os.Bundle
import android.util.Log
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
        val value = object : SurfaceHolder.Callback {

            private lateinit var sceneHolder: SceneHolder

            override fun surfaceCreated(holder: SurfaceHolder) {
                sceneHolder = with(holder) {
                    val dp32 = 32f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
                    val dp16 = 16f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
                    val dp8 = 8f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
                    val dp4 = 4f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
                    val dp2 = 2f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
                    val dp1 = 1f.dp2Px(this@ChristmasTreeWallpapperDemoActivity)
                    SceneHolder(
                        generateProportionalTree(
                            surfaceFrame.width(),
                            surfaceFrame.height(),
                            dp32,
                            dp32
                        ),
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
                Log.d("surfaceChanged", "$width $height")
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                sceneHolder.stop()
            }

        }
        surfaceView.holder.addCallback(value)

    }
}