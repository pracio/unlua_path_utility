package com.github.pracio.unluapathutility.action

import com.github.pracio.unluapathutility.utils.ActionUtils
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

//Copy Get Module Name Path
//For UMG GetModuleName Interface
class CopyModuleNameAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        var path = ActionUtils.getCurrentFilePath(e)
        var modulePath = ActionUtils.convertPath(path!!)
        ActionUtils.setClipboard(modulePath!!)
    }
}