import java.util.concurrent.ConcurrentHashMap

def timer = new ConcurrentHashMap()

eventTestCaseStart = { name ->
    timer[name] = System.currentTimeMillis()
    println '-' * 60
    println "| $name : started"
}

eventTestCaseEnd = { name, err, out ->
    def lap = System.currentTimeMillis() - timer[name]
    println "\n|$name : finished in $lap ms."
}