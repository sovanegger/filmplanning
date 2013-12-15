/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	
	// %REMOVE_START%
	// The configuration options below are needed when running CKEditor from source files.
	config.bodyPrepend = '<div>';
	config.bodyAppend = '</div>';
	config.plugins = 'screenplayformat,ajaxsave,basicstyles,dialogui,dialog,clipboard,list,indent,enterkey,entities,floatingspace,wysiwygarea,undo,save,xml,ajax,print,button,toolbar,panel,floatpanel,listblock,richcombo,onchange,selectall,maximize,maxheight,popup,filebrowser,find,menu,contextmenu,div';
	config.skin = 'moono';
	// %REMOVE_END%

	// Define changes to default configuration here.
	// For the complete reference:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config
	config.toolbar = [
  		{ name: 'screenplayformat', items: [ 'Screenplay' ] },
  		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Ajaxsave', 'Print' ] },
  		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
  		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll' ] },
  		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Strike', '-', 'RemoveFormat' ] },
  		//{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote' ] },
  		{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
  		{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar' ] },
  		{ name: 'styles', items: [ 'Styles', 'Format' ] },
  		{ name: 'tools', items: [ 'Maximize' ] },
  		{ name: 'others', items: [ '-' ] },
  		{ name: 'about', items: [ 'About' ] }
  	];

	// The toolbar groups arrangement, optimized for a single toolbar row.
//	config.toolbarGroups = [
//		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
//		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
//		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
//		{ name: 'forms' },
//		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
//		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
//		{ name: 'links' },
//		{ name: 'insert' },
//		{ name: 'styles' },
//		{ name: 'colors' },
//		{ name: 'tools' },
//		{ name: 'others' },
//		{ name: 'about' }
//	];

	// The default plugins included in the basic setup define some buttons that
	// we don't want too have in a basic editor. We remove them here.
	//config.removeButtons = 'Cut,Copy,Paste,Undo,Redo,Anchor,Underline,Strike,Subscript,Superscript';
	// Let's have it basic on dialogs as well.
	config.removeDialogTabs = 'link:advanced';
};
