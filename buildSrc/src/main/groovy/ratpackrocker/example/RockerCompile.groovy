package ratpackrocker.example

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.process.JavaExecSpec

class RockerCompile extends DefaultTask {

    @InputFiles
    FileCollection rockerClasspath

    @InputDirectory
    File templateDir

    @OutputDirectory
    File outputDir

    @TaskAction
    void run() {
        project.delete outputDir

        def out = new ByteArrayOutputStream()
        def result = project.javaexec { JavaExecSpec spec ->
            spec.classpath rockerClasspath
            spec.main = 'com.fizzed.rocker.compiler.JavaGeneratorMain'
            spec.systemProperty "rocker.template.dir", templateDir.absolutePath
            spec.systemProperty "rocker.output.dir", outputDir.absolutePath
            spec.systemProperty "rocker.class.dir", outputDir.absolutePath
            spec.systemProperty "rocker.option.optimize", "true"
            spec.standardOutput = out
            spec.errorOutput = out
            spec.ignoreExitValue = true
        }

        if (result.exitValue != 0) {
            throw new RuntimeException("Rocker template compilation failed: " + out.toString())
        }
    }

}
