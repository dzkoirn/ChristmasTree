package by.dzkoirn.christmastree.common

fun pow2(n: Int): Int = ipow2(1, n)

private tailrec fun ipow2(acc: Int, n: Int): Int {
    return if (n == 0) {
        acc
    } else {
        ipow2(acc * 2 ,n - 1)
    }
}