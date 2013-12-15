CKEDITOR.plugins.add( 'screenplayformat',
{
	requires: 'richcombo',
	lang: 'en,cs',
	init: function( editor )
	{
		if ( editor.blockless )
			return;
		var config = editor.config;
		var lang = editor.lang.screenplayformat,
		styles = {},
		stylesCount = 0,
		allowedContent = [];
		var tags = config.screenplayformat_tags.split( ';' );
		for ( var i = 0; i < tags.length; i++ ) {
			var tag = tags[i];
			var style = new CKEDITOR.style( config[ 'screenplayformat_' + tag ] );
			if (!editor.filter.customConfig || editor.filter.check( style )) {
				stylesCount++;
				styles[ tag ] = style;
				styles[ tag ]._.enterMode = editor.config.enterMode;
				allowedContent.push( style );
			}
		}
		
		editor.ui.addRichCombo('Screenplay', {
			label: lang.label,
			title: lang.panelTitle,
			toolbar: 'styles,20',
			allowedContent: allowedContent,
			
			panel: {
				css: [ CKEDITOR.skin.getPath( 'editor' ) ].concat( config.contentsCss ),
				multiSelect: false,
				attributes: { 'aria-label': lang.panelTitle }
			},
			
			init: function() {
				this.startGroup( lang.panelTitle );
				for ( var tag in styles ) {
					var label = lang[ 'tag_' + tag ];
					this.add( tag, label, label );
				}
			},
			
			onClick: function( value ) {
				editor.focus();
				editor.fire( 'saveSnapshot' );
					
				var style = styles[ value ];
				var pom = this.getValue() == value ? 'removeStyle' : 'applyStyle';
				
				editor[pom]( style );
				editor.fire( 'saveSnapshot' );
			},
			
			onRender: function() {
				editor.on( 'selectionChange', function( ev ) {
					var currentTag = this.getValue(),
						elementPath = ev.data.path,
						isEnabled = !editor.readOnly && elementPath.isContextFor( 'p' );
					
					// Disable the command when selection path is "blockless".
					this[ isEnabled ? 'enable' : 'disable' ]();

					if ( isEnabled ) {
						for ( var tag in styles ) {
							if ( styles[ tag ].checkActive( elementPath ) ) {
								if ( tag != currentTag ) {
									this.setValue( tag, editor.lang.screenplayformat[ 'tag_' + tag ] );
								}
								return;
							}
						}
						editor.applyStyle(styles['action']);
					}
				}, this );
				
				editor.on('key', function(ev) {
					if( ev.data.keyCode == 13 ) {
						setTimeout(function () {
							var tag = ev.editor.getSelection().getStartElement();
							switch (tag.$.className) {
								case config.screenplayformat_sceneheading.attributes['class']:
									editor.applyStyle(styles[config.screenplayformat_action.attributes['class']]);
									break;
								case config.screenplayformat_dialogue.attributes['class']:
									editor.applyStyle(styles[config.screenplayformat_character.attributes['class']]);
									break;
								case config.screenplayformat_character.attributes['class']:
									editor.applyStyle(styles[config.screenplayformat_dialogue.attributes['class']]);
									break;
								default:
									editor.applyStyle(styles[config.screenplayformat_action.attributes['class']]);
									break;
							}
						}, 5);
					}
				});
			}	
		});
	}
});

CKEDITOR.config.screenplayformat_tags = 'sceneheading;action;character;dialogue;parenthetical;transition;shot;text';
CKEDITOR.config.screenplayformat_sceneheading = { element: 'p', attributes: {'class' : 'sceneheading'} };
CKEDITOR.config.screenplayformat_action = { element: 'p', attributes: {'class' : 'action'}  };
CKEDITOR.config.screenplayformat_character = { element: 'p', attributes: {'class' : 'character'}  };
CKEDITOR.config.screenplayformat_dialogue = { element: 'p', attributes: {'class' : 'dialogue'}  };
CKEDITOR.config.screenplayformat_parenthetical = { element: 'p', attributes: {'class' : 'parenthetical'}  };
CKEDITOR.config.screenplayformat_transition = { element: 'p', attributes: {'class' : 'transition'}  };
CKEDITOR.config.screenplayformat_shot = { element: 'p', attributes: {'class' : 'shot'}  };
CKEDITOR.config.screenplayformat_text = { element: 'p', attributes: {'class' : 'text'}  };