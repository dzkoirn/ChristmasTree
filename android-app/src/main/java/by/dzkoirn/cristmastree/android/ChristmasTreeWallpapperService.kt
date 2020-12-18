package by.dzkoirn.cristmastree.android

import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder

class ChristmasTreeWallpapperService : WallpaperService() {
    override fun onCreateEngine(): Engine {
        TODO("Not yet implemented")
    }

    private inner class WallpaperEngine : WallpaperService.Engine() {

        override fun onSurfaceCreated(holder: SurfaceHolder) {
            super.onSurfaceCreated(holder)
            val canvas = holder.lockCanvas()
            canvas.width

            holder.unlockCanvasAndPost(canvas)
        }

    }
}