CKEDITOR.plugins.add('ajaxsave',
    {
		icons: 'ajaxsave', // %REMOVE_LINE_CORE%
		init: function(editor)
        {
            var pluginName = 'ajaxsave';
            var keyStrokes = 0;
            editor.addCommand( pluginName,
            {
                exec : function( editor )
                {
                	var form = editor.element.$.form;
                	var element = editor.document.getBody();
                	var JSONObject= {
            			'id': form.id.value,
            			'title': 'kokot',
            	        'screenplay': editor.getSnapshot()
            	    };
                	$.ajax({
                		type: 'PUT',
                		url: form.action,
                		contentType: "application/json; charset=utf-8",
                        data: JSON.stringify(JSONObject),
                        dataType: 'json',
                        beforeSend: function() {
                        	editor.setReadOnly();
                        	element.setStyle('background-color', '#c3c3c3');
                        },
                        complete: function() {
                        	editor.setReadOnly(false);
                        	element.setStyle('background-color', '#ffffff');
                        },
                	});
                },
                canUndo : true
            });
            editor.on('key', function(ev) {
            	keyStrokes++;
            	if (keyStrokes == 1000) {
            		editor.commands[pluginName].exec(editor);
            		keyStrokes = 0;
            	}
            });
            setInterval(function() {
            	editor.commands[pluginName].exec(editor);
            }, 15*60000);
            editor.ui.addButton('Ajaxsave',
            {
                label: 'Save Ajax',
                command: pluginName,
                className : 'cke_button_save'
            });
        }
    });