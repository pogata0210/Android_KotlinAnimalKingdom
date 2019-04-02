abstract class AnimalClass(val id : Int, val name: String, val year: Int) {
    fun consumeFood(){
        println("$name consume food")
    }
    //, var canMove: canMove, var canBreath: canBreath, val canReproduce: canReproduce

    abstract fun canMove(): String
    abstract fun canBreath(): String
    abstract fun canReproduce(): String
}

sealed class Move(animalName: String){
    abstract fun performMove(animalName: String): String
}

class Walk(animalName: String): Move(animalName) {
    override fun performMove(animalName: String): String {
        return "$animalName walks"
    }


    class Mammal(id: Int, name: String, year: Int) : AnimalClass(id, name, year) {
        override fun canMove(): String {
            return Walk(name).performMove(name)
        }

        override fun canBreath() = "Breathe with lungs"

        override fun canReproduce() = "Live births"
    }
}