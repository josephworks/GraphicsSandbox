import gui.GUI
import sandbox.Manager

object Main {

    private lateinit var gui: GUI

    @JvmStatic
    fun main(args: Array<String>) {

        Manager.init()

        gui = GUI().init()

    }

}