package com.testdevlab.notesapp.common

import timber.log.Timber

class LineNumberDebugThree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement) =
        "$TAG_NAME: (${element.fileName}:${element.lineNumber}) #${element.methodName} "
}
