<template>
 <div class="hello">
   <h1>{{ msg }}</h1>
   <h3>Javascript-Java interaction button</h3>
   <button class="spacing" @click="clickEvent()">Click me</button>
   <div class="spacing">{{ message }}</div>
 </div>
</template>
 
<script>
import { EquoCommService } from "@equo/comm"
let comm = EquoCommService.get()
 
export default {
 name: "HelloWorld",
 props: {
   msg: String,
 },
 data() {
   return {
     message: "",
   }
 },
 mounted() {
   comm.on("MyJSEvent", (res) => {
     console.log(res)
     this.message = res
   })
 },
 methods: {
   clickEvent() {
     comm.send("MyEventHandler", "Hi, I am a message from JS (using NPM)")
   },
 },
}
</script>
 
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
 margin: 40px 0 0;
}
 
button {
 background-color: rgb(59, 182, 110);
 border: none;
 border-radius: 10px;
 padding: 15px;
}
 
button:hover {
 background-color: rgb(144, 255, 190);
}
 
button:active {
 background-color: rgb(24, 124, 66);
}
 
.spacing {
 margin: 20px;
}
</style>
