package scene

import sandbox.Manager
import utils.FileSystem
import java.io.File

open class Scene(name: String, author: String, version: String) {

    val file = File("Scenes/${name}.js")

    open suspend fun load() {
        val scene = FileSystem.read(file)
        Manager.engine.eval(scene)
    }

}