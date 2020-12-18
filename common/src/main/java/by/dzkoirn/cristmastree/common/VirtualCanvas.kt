package by.dzkoirn.cristmastree.common

/**
 * Clients should implement this interface and provide instance
 */
interface VirtualCanvas {
    /**
     * @return canvas width in pixels
     */
    val width: Int
    /**
     * @return canvas height in pixels
     */
    val height: Int
}