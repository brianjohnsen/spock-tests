package spocktest

class MyFineController {

	def myaction() {
		def xxx = params.int('xxx')
		xxx = xxx*2
		[xxx:xxx, sometext:"some text", alist:[1,2,3,4,5]]
	}
	
	def renderaction(String cvr) {
		render("more text $cvr")
	}
}
