package spocktest

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

import spock.lang.Specification;
import spock.lang.Unroll;


class MyFirstSpec extends Specification {

	def setup(){
		println "setup"
	}
	
	def cleanup(){
		println "clean"
	}
	
	def setupSpec(){
		println "setupSpec"
	}
	
	def cleanupSpec(){
		println "cleanSpec"
	}
	
//	@Unroll("tallet er #tal")
	def "man kan skrive alm tekst i metodenavnet"(){
		expect:
		println "test tal=$tal"
		
		where:
		tal << [1,2,3,4]
	}

}
