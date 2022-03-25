package gui

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.*

import org.lwjgl.opengl.GL

import org.lwjgl.opengles.GLES20.*

import org.lwjgl.system.MemoryUtil.NULL

class GUI
{


    private var errorCallback : GLFWErrorCallback? = null
    private var keyCallback : GLFWKeyCallback? = null
    var window: Long? = null

    fun init(): GUI
    {
        errorCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))

        if ( glfwInit() != GLFW_TRUE )
            throw IllegalStateException("Unable to initialize GLFW")

        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

        window = glfwCreateWindow(800, 800, "GraphicsSandbox", NULL, NULL)

        if (window == NULL)
            throw RuntimeException("Failed to create the GLFW window")

        keyCallback = glfwSetKeyCallback(window!!, object : GLFWKeyCallback() {
            override fun invoke(window: kotlin.Long,
                                key: kotlin.Int,
                                scancode: kotlin.Int,
                                action: kotlin.Int,
                                mods: kotlin.Int) {

                if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                    glfwSetWindowShouldClose(window, GLFW_TRUE)

            }
        })

        glfwMakeContextCurrent(window!!)
        glfwSwapInterval(1)
        glfwShowWindow(window!!)

        GL.createCapabilities()
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f)

        while (glfwWindowShouldClose(window!!) == GLFW_FALSE )
        {
            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
            glfwSwapBuffers(window!!)
            glfwPollEvents()
        }

        return this
    }

}