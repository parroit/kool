# Kool Template Sample

This sample is a really basic little web page that shows dynamic content generation using [Kool Templates](http://kool.io/templates.html) on the client side to dynamically render DOM content in a web browser.

You can run this sample in a web browser using JavaScript, or in a rich Java client with JavaFX.

Here's a breakdown of the source code used to implement this:

* [test.kool.myapp.MyApp.kt](https://github.com/koolio/kool/blob/master/samples/kool-template-sample/src/main/kotlin/test/kool/myapp/MyApp.kt) the actual application which interacts with the DOM using the standard [kotlin.browser](http://jetbrains.github.com/kotlin/versions/snapshot/apidocs/kotlin/browser/package-summary.html) package.
* [sampleTemplate()](https://github.com/koolio/kool/blob/master/samples/kool-template-sample/src/main/kotlin/test/kool/myapp/MyApp.kt#L24) a function which is a simple [Kool Template](http://kool.io/templates.html) that generates a DOM fragment in the client


## Using a web browser

Just run a build, then open the sample.html

    mvn install
    open sample.html


## Using Kool JavaFX

**NOTE** JavaFX requires [Java 7 update 4](http://www.oracle.com/technetwork/java/javase/overview/index.html) or later which ships with JavaFX. If you install Java 7 and use a Mac you might want to run this first...

    export JAVA_HOME=/Library/Java/JavaVirtualMachines/1.7.0.jdk/Contents/Home
    export PATH=$JAVA_HOME/bin:$PATH

You can check you have JavaFX in your JDK install via

    ls -l $JAVA_HOME/lib/javafx-mx.jar

which should find the javafx jar.

### Running the sample

To run the sample try...

    mvn -Pui

Assuming you've Java 7 enabled and JAVA_HOME points to the JRE/JDK for Java 7 or later.

### Kool JavaFX code walkthrough

Here's a breakdown of the kool-javafx source code used to implement this:

* [io.kool.javafx.WebApplication](https://github.com/koolio/kool/tree/master/kool-javafx/src/main/kotlin/io/kool/javafx/WebApplication.kt) : standard kool.io browser Application
* [io.kool.javafx.namespace](https://github.com/koolio/kool/tree/master/kool-javafx/src/main/kotlin/io/kool/javafx/Main.kt) : Java main() function launcher for the JavaFX web app

### How a kool.io JavaFX application works

When using your web application in the kool.io JavaFX browser, you need to bind your Kotlin application code to the web page. This is done by adding a [text/kotlin script tag](https://github.com/koolio/kool/blob/master/samples/kool-template-sample/src/main/resources/sample.html#L6) or using the WebApplication.ready() function to pass a block when the document is ready.

For example if you add this to a HTML file:

    <script type="text/kotlin">
        test.kool.myapp.namespace.myApp()
    </script>

when opening in the HTML in the kool.io JavaFX browser (running the io.kool.javafx.namespace class as a Java main() function)

    java io.kool.javafx.namespace file://foo.html

The browser will startup, load the HTML and then when it sees the text/kotlin script it will invoke your function; once the document has loaded (and the kotlin.browser.document property is updated).

The same Kotlin code should then work if the code is compiled to JavaScript. The only change is required is that the script tag with text/kotlin needs to be replaced with the actual JavaScript file; this could be done dynamically on the server or as part of your build process.
