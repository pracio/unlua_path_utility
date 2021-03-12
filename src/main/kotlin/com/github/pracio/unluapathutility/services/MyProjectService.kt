package com.github.pracio.unluapathutility.services

import com.github.pracio.unluapathutility.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
