package cz.davidbilik.bulletsample

import org.intellij.lang.annotations.Language

@Language("html")
val html = """
        <div>
            <div>
                First paragraph with a little of text before actual star of this demo - the list.
            </div>
            <ul>
                <li>First option that is relatively short</li>
                <li>Second option that contains as much info as the first one, but is quite long due to its representative nature</li>
                <li>Three makes a crowd</li>
            </ul>
            <div>
                Something at the end so its not so sad down here
            </div>
        </div>
    """.trimIndent()