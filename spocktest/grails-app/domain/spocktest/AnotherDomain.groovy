package spocktest

import groovy.transform.ToString

@ToString(includeNames = true, includePackage = false, includeFields = true, excludes = 'metaClass,class,version')
class AnotherDomain {
	
	String navn

    static constraints = {
    }
}
