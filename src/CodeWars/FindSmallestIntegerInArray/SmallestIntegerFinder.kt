package CodeWars.FindSmallestIntegerInArray

class SmallestIntegerFinder {
    //couple different ways to try this
    fun findSmallestInt(nums: List<Int>): Int {
//        return nums.min() ?: -1
//        return nums.min() as Int
        return nums.min()!!
    }
}