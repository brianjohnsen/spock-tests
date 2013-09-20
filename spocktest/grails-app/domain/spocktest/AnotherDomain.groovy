package spocktest

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes = 'metaClass,class,version')
class AnotherDomain {
	
	String navn

    static constraints = {
    }
}
