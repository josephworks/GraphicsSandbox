package scene.api

import jdk.nashorn.api.scripting.JSObject
import scene.Scene

class SceneBinds {

    fun scene(jsObject: JSObject): Scene {
        val n = jsObject.getMember("name") as String
        val a = jsObject.getMember("author") as String
        val v = jsObject.getMember("version") as String
        return Scene(n, a, v)
    }

}