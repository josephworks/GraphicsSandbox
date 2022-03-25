package sandbox

import jdk.nashorn.api.scripting.NashornScriptEngineFactory

import scene.api.ColorBinds
import scene.api.SceneBinds

import javax.script.Bindings
import javax.script.ScriptContext
import javax.script.SimpleBindings

object Manager {

    val factory = NashornScriptEngineFactory()
    val engine = factory.getScriptEngine()
    val bindings: Bindings = SimpleBindings()

    fun init()
    {
        bindings.put("Color", ColorBinds())
        bindings.put("Scene", SceneBinds())

        engine.setBindings(bindings, ScriptContext.GLOBAL_SCOPE)
    }

}