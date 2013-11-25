package spocktest

import grails.converters.JSON

class MyFineController {

    def myaction() {
        def arg1 = params.int('arg1')
        arg1 = arg1 * 2
        session.arg1 = arg1
        [arg1: arg1, sometext: "some text", alist: [1, 2, 3, 4, 5]]
    }

    def renderaction(String cvr) {
        render("more text $cvr")
    }

    def redirectaction(String cvr) {
        redirect(action: "myaction", params: [cvr: cvr])
    }

    def renderactionjson(String cvr) {
        render(['cvr': cvr] as JSON)
    }
}
