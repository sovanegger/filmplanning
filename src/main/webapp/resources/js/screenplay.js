function initScreenplay() {
	var editor = new wysihtml5.Editor("wysihtml5-textarea", { // id of textarea element
	  toolbar:      "wysihtml5-toolbar", // id of toolbar element
	  parserRules:  wysihtml5ParserRules // defined in parser rules set 
	});
}