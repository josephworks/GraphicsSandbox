package scene.api

import jdk.nashorn.api.scripting.JSObject
import java.awt.Color

class ColorBinds
{

    fun rgba(jsObject: JSObject): Color
    {
        val r = jsObject.getMember("red") as Float
        val g = jsObject.getMember("green") as Float
        val b = jsObject.getMember("blue") as Float
        val a = if (jsObject.hasMember("alpha")) jsObject.getMember("alpha") as Float else 255F
        return Color(r, g, b, a)
    }

    fun hsb(jsObject: JSObject): Color
    {
        val h = jsObject.getMember("hue") as Float
        val s = jsObject.getMember("saturation") as Float
        val b = jsObject.getMember("brightness") as Float
        return Color.getHSBColor(h, s, b)
    }

}