package com.genymotion

import main.groovy.com.genymotion.GenymotionTool
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GenymotionTask extends DefaultTask {

    @TaskAction
    def exec() {

        //we set the config inside the GenymotionTool
        GenymotionTool.CONFIG = project.genymotion.config

        println("Starting devices")
        //get the declared devices
        project.genymotion.getDevices().each(){

            println("Starting ${it.name}")
            GenymotionTool.startDevice(it)
        }

//        println("-- All devices --")
//        def result = GenymotionTool.getAllDevices(false)
//        result.each(){
//            println it.name
//        }
        println("-- Running devices --")
        GenymotionTool.getRunningDevices(true)
//        println("-- Stopped devices --")
//        GenymotionTool.getStoppedDevices(true)

    }
}