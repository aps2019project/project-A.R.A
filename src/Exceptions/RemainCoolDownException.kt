package Exceptions

class RemainCoolDownException : CustomException() {
    override fun printStackTrace() {
        println("cool down remain")
    }
}
