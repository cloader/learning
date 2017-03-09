<html>
<head>
<script src="./static/js/vue.js"></script>
</head>
<body>
	<h2>Hello World!</h2>
	<div id="app">{{ message }} {{a}}</div>
	<div id="app2">
		<span v-bind:title="message"> Hover your mouse over me for a
			few seconds to see my dynamically bound title! </span>
	</div>

	<div id="app-4">
		<ol>
			<li v-for="todo in todos">{{ todo.text }}</li>
		</ol>
	</div>

	<div id="comp">
		<ol>
			<!-- Create an instance of the todo-item component -->
			<todo-item></todo-item>
			<my-component></my-component>
			<li>123</li>
		</ol>
	</div>
</body>
</html>

<script type="text/javascript">
	var app = new Vue({
		el : '#app',
		data : {
			message : 'Hello Vue!',
			a : "this is a"
		}
	})

	var app2 = new Vue({
		el : '#app2',
		data : {
			message : 'Hello Vue!',
			a : "this is a"
		}
	})

	var app4 = new Vue({
		el : '#app-4',
		data : {
			todos : [ {
				text : 'Learn JavaScript'
			}, {
				text : 'Learn Vue'
			}, {
				text : 'Build something awesome'
			} ]
		}
	});

	Vue.component('todo-item', {
		template : '<li>This is a todo</li>'
	});
	new Vue({
		el : "#comp",
		components : {
			// <my-component> 将只在父模板可用
			'my-component' : {
				template:"<li>this is custom component</li>"
			}
		}
	})
</script>
