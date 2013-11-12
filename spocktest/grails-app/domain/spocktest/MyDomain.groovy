package spocktest

import groovy.transform.ToString

@ToString(includeNames = true, includePackage = false, includeFields = true, excludes = 'metaClass,class,version')
class MyDomain {

    String card
    Integer tal
    String dyr

    static hasMany = [others: AnotherDomain]

    static constraints = {
        dyr(inList: ["hest", "ko"])
        tal(min: 42, max: 44)
        card(creditCard: true)
        others(minSize: 1, nullable: false)
    }
}
