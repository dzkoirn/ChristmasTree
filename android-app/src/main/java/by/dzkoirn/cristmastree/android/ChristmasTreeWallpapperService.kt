package by.dzkoirn.cristmastree.android

import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder
import by.dzkoirn.christmastree.common.SceneHolder

class ChristmasTreeWallpapperService : WallpaperService() {

    override fun onCreateEngine(): Engine =
        ChristmasWallpaperEngine()

    private inner class ChristmasWallpaperEngine: WallpaperService.Engine() {

        override fun onCreate(holder: SurfaceHolder) {
            super.onCreate(holder)

//            val frame = holder.surfaceFrame
//            SceneHolder.create(frame.width(), frame.height(),
//                16f.dp2Px(this@ChristmasTreeWallpapperService),
//                16f.dp2Px(this@ChristmasTreeWallpapperService),
        }

        override fun onSurfaceCreated(holder: SurfaceHolder) {
            super.onSurfaceCreated(holder)

            holder.surfaceFrame
            val canvas = holder.surface.lockCanvas(holder.surfaceFrame)
//            canvas.
        }

        override fun onSurfaceChanged(
            holder: SurfaceHolder?,
            format: Int,
            width: Int,
            height: Int
        ) {
            super.onSurfaceChanged(holder, format, width, height)

        }

    }
}