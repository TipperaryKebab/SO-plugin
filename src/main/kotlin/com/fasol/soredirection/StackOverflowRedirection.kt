package com.fasol.soredirection

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiDocumentManager
class StackOverflowRedirection : AnAction(){
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val fileEditorManager = FileEditorManager.getInstance(project)
        val selectedTextEditor = fileEditorManager.selectedTextEditor ?: return
        val file = selectedTextEditor.document
        val psifile = PsiDocumentManager.getInstance(project).getPsiFile(file) ?: return
        val ideLanguage = psifile.language.displayName
        val url = "https://stackoverflow.com/questions/tagged/$ideLanguage"
        BrowserUtil.browse(url)
    }
}